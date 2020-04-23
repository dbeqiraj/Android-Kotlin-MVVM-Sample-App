package com.dbeqiraj.android_kotlin_mvvm_sample_app.utils

sealed class LiveDataResult<T> {
    data class Success<T>(val result: T): LiveDataResult<T>()
    data class Error<T>(val err: Throwable): LiveDataResult<T>()
    class Loading<T>() : LiveDataResult<T>()
}