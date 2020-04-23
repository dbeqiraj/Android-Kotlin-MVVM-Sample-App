package com.dbeqiraj.android_kotlin_mvvm_sample_app

import com.dbeqiraj.android_kotlin_mvvm_sample_app.di.components.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class SampleAppApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerApplicationComponent.builder()
            .application(this)
            .build().apply {
                inject(this@SampleAppApplication)
            }
    }
}