package com.dbeqiraj.android_kotlin_mvvm_sample_app.di.components

import com.dbeqiraj.android_kotlin_mvvm_sample_app.SampleAppApplication
import com.dbeqiraj.android_kotlin_mvvm_sample_app.di.modules.ActivityBuilder
import com.dbeqiraj.android_kotlin_mvvm_sample_app.di.modules.CoroutineModule
import com.dbeqiraj.android_kotlin_mvvm_sample_app.di.modules.DaggerViewModelFactoryModule
import com.dbeqiraj.data.di.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilder::class,
        DaggerViewModelFactoryModule::class,
        RetrofitModule::class,
        CoroutineModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: SampleAppApplication): Builder

        fun build(): ApplicationComponent
    }

    override fun inject(instance: DaggerApplication)

    fun inject(application: SampleAppApplication)

}
