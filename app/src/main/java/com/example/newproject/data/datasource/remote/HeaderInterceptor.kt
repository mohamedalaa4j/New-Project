package com.example.newproject.data.datasource.remote

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .header("Accept", "application/json")
            .build()
        return chain.proceed(request)
    }
}