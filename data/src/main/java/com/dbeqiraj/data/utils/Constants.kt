package com.dbeqiraj.data.utils

internal class Constants private constructor() {

    init {
        throw IllegalStateException("Constants class: constructor called!")
    }

    companion object {
        internal const val BASE_URL_PROD = "https://gist.githubusercontent.com"
        internal const val BASE_URL_TEST = "https://gist.githubusercontent.com"

        internal const val ENV_PROD = "Production"
        internal const val ENV_TEST = "Test"

        internal const val TIMEOUT = 15 * 1000L
    }

}