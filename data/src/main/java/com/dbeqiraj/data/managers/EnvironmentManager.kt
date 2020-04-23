package com.dbeqiraj.data.managers

import com.dbeqiraj.data.BuildConfig
import com.dbeqiraj.data.utils.Constants.Companion.BASE_URL_PROD
import com.dbeqiraj.data.utils.Constants.Companion.BASE_URL_TEST
import com.dbeqiraj.data.utils.Constants.Companion.ENV_PROD
import com.dbeqiraj.data.utils.Constants.Companion.ENV_TEST
import java.lang.IllegalStateException

internal object EnvironmentManager {

    internal fun getBaseUrl(): String = when (BuildConfig.ENVIRONMENT) {
        ENV_PROD -> BASE_URL_PROD
        ENV_TEST -> BASE_URL_TEST
        else -> throw IllegalStateException("Unknown environment: ${BuildConfig.ENVIRONMENT}")
    }

}