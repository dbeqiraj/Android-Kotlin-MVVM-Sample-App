package com.dbeqiraj.android_kotlin_mvvm_sample_app.models

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.dbeqiraj.domain.base.BaseModel

data class CakeUiModel(val id: Int, val title: String, val previewDsc: String, val description: String, val imageUrl: String?): BaseModel() {
    companion object {
        @BindingAdapter("cakeImage")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String?) {
            imageUrl?.let {
                Glide.with(view.context)
                    .load(imageUrl)
                    .into(view)
            }
        }
    }
}