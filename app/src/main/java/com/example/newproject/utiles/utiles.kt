package com.example.newproject.utiles

import android.util.Log
import com.example.newproject.R
import com.example.newproject.data.model.remote.GeneralErrorResponse
import com.example.newproject.utiles.state.UiText
import com.google.gson.Gson
import com.example.newproject.utiles.state.ApiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

fun <T> toResultFlow(call: suspend () -> Response<T>): Flow<ApiState<T>> = flow {
    emit(ApiState.Loading())
    try {
        val response = call()
        if (response.isSuccessful) {
            emit(ApiState.Success(response.body()))
            Log.e("networkResponse", "Success\n" + response.body().toString())

        } else {
            val errorBody = response.errorBody()?.string()
            val errorObject = Gson().fromJson(errorBody, GeneralErrorResponse::class.java)
            emit(ApiState.Error(UiText.DynamicString(errorObject.error.orEmpty())))
            Log.e("networkResponse", "Failure\n $errorBody")
        }

    } catch (e: HttpException) {
        Log.d("networkResponse", "HttpException\n ${e.message.toString()}")
        emit(ApiState.Error(UiText.StringResource(R.string.something_went_wrong)))

    } catch (e: IOException) {
        Log.d("networkResponse", "IOException\n ${e.message.toString()}")
        emit(ApiState.Error(UiText.StringResource(R.string.check_your_internet_connection)))

    } catch (e: Exception) {
        Log.d("networkResponse", "Exception\n ${e.message.toString()}")
        emit(ApiState.Error(UiText.StringResource(R.string.something_went_wrong)))
    }
}
