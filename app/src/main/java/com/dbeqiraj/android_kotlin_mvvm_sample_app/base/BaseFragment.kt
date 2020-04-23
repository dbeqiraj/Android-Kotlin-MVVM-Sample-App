package com.dbeqiraj.android_kotlin_mvvm_sample_app.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

abstract class BaseFragment<T : ViewDataBinding>(private val layout: Int) : Fragment() {

    protected lateinit var navController: NavController
    protected lateinit var fragmentLayoutBinding: T
    protected lateinit var mProgressDialog: ProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentLayoutBinding = DataBindingUtil.inflate(inflater, layout, container, false)
        return fragmentLayoutBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    protected fun showDialog(message: String) {
        mProgressDialog = ProgressDialog(activity)
        mProgressDialog.setMessage(message)
        mProgressDialog.show()
    }

    protected fun hideDialog() {
        if (mProgressDialog.isShowing) {
            mProgressDialog.dismiss()
        }
    }

    protected fun showBackArrow() {
        (activity as AppCompatActivity).supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }
    }

    protected fun hideBackArrow() {
        (activity as AppCompatActivity).supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(false)
            it.setDisplayShowHomeEnabled(false)
        }
    }
}
