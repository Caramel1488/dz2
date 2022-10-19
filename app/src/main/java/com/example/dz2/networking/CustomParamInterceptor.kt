package com.example.dz2.networking

import okhttp3.Interceptor
import okhttp3.Response

class CustomParamInterceptor(
    private val paramName: String,
    private val paramValue: String
):Interceptor {


        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()

            val modifiedUrl = originalRequest.url.newBuilder()
                .addQueryParameter(paramName,paramValue)
                .build()

            return chain.proceed(originalRequest.newBuilder().url(modifiedUrl).build())
        }

}