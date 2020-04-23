package com.dbeqiraj.android_kotlin_mvvm_sample_app.network

import com.dbeqiraj.android_kotlin_mvvm_sample_app.BuildConfig
import com.dbeqiraj.android_kotlin_mvvm_sample_app.utils.Constants.Companion.BASE_URL_PROD
import com.dbeqiraj.android_kotlin_mvvm_sample_app.utils.Constants.Companion.BASE_URL_TEST
import com.dbeqiraj.android_kotlin_mvvm_sample_app.utils.Constants.Companion.ENV_PROD
import com.dbeqiraj.android_kotlin_mvvm_sample_app.utils.Constants.Companion.ENV_TEST

internal object EnvironmentManager {

    internal fun getBaseUrl(): String = when (BuildConfig.ENVIRONMENT) {
        ENV_PROD -> BASE_URL_PROD
        ENV_TEST -> BASE_URL_TEST
        else -> throw IllegalStateException("Unknown environment: ${BuildConfig.ENVIRONMENT}")
    }

}