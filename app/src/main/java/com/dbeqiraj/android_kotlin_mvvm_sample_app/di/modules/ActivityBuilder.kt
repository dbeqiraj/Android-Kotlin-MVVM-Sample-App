package com.dbeqiraj.android_kotlin_mvvm_sample_app.di.modules

import com.dbeqiraj.android_kotlin_mvvm_sample_app.ui.MainActivity
import com.dbeqiraj.android_kotlin_mvvm_sample_app.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun bindMainActivity(): MainActivity?

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    internal abstract fun bindHomeFragment(): HomeFragment?
}