package com.dbeqiraj.android_kotlin_mvvm_sample_app.utils

sealed class CoroutineResponse {
    data class Error(val error: Throwable): CoroutineResponse()
    data class Success<T>(val result: T): CoroutineResponse()
}