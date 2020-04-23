package com.dbeqiraj.android_kotlin_mvvm_sample_app.base

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.CallSuper
import dagger.android.support.DaggerAppCompatActivity

internal abstract class BaseActivity(private val layout: Int) : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        onViewReady(savedInstanceState, intent)
    }

    @CallSuper
    protected open fun onViewReady(savedInstanceState: Bundle?, intent: Intent) {
    }

    protected fun showBackArrow() {
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
