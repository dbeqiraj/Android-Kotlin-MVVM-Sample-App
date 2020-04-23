package com.dbeqiraj.android_kotlin_mvvm_sample_app.di.modules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers

@Module
class CoroutineModule {
    @Provides
    fun coroutineDispatcher() = Dispatchers.Default
}