package com.dbeqiraj.android_kotlin_mvvm_sample_app.di.modules

import androidx.lifecycle.ViewModel
import com.dbeqiraj.android_kotlin_mvvm_sample_app.di.scope.ViewModelKey
import com.dbeqiraj.android_kotlin_mvvm_sample_app.viewModels.CakesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(CakesViewModel::class)
    abstract fun bindMainViewModel(cakesViewModel: CakesViewModel): ViewModel

}