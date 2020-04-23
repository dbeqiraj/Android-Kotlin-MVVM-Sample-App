package com.dbeqiraj.android_kotlin_mvvm_sample_app.ui

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.dbeqiraj.android_kotlin_mvvm_sample_app.BR
import com.dbeqiraj.android_kotlin_mvvm_sample_app.R
import com.dbeqiraj.android_kotlin_mvvm_sample_app.base.BaseFragment
import com.dbeqiraj.android_kotlin_mvvm_sample_app.databinding.FragmentDetailBinding
import com.dbeqiraj.android_kotlin_mvvm_sample_app.models.CakeUiModel

internal class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    companion object {
        internal const val CAKE: String = "cake"
    }

    private lateinit var cake: CakeUiModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showBackArrow()

        cake = arguments!!.getSerializable(CAKE) as CakeUiModel
        fragmentLayoutBinding.setVariable(BR.model, cake)

        loadImage()
    }

    private fun loadImage() {
        context?.let {
            Glide.with(it)
                .load(cake.imageUrl)
                .into(fragmentLayoutBinding.cakeImage)
        }
    }
}