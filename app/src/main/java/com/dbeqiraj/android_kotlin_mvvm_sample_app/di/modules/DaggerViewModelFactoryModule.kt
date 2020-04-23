package com.dbeqiraj.android_kotlin_mvvm_sample_app.di.modules

import androidx.lifecycle.ViewModelProvider
import com.dbeqiraj.android_kotlin_mvvm_sample_app.viewModels.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class DaggerViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}