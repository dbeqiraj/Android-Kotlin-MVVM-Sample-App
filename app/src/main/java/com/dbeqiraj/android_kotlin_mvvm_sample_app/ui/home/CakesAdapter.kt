package com.dbeqiraj.android_kotlin_mvvm_sample_app.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dbeqiraj.android_kotlin_mvvm_sample_app.BR
import com.dbeqiraj.android_kotlin_mvvm_sample_app.databinding.ListItemLayoutBinding
import com.dbeqiraj.android_kotlin_mvvm_sample_app.models.CakeUiModel

class CakesAdapter(
    diffUtilCallback: DiffUtil.ItemCallback<CakeUiModel>,
    private val delegate: HomeFragment.AdapterDelegate
) :
    ListAdapter<CakeUiModel, CakesAdapter.ListItemViewHolder>(diffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListItemViewHolder(
        ListItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ListItemViewHolder(private val adapterListRowBinding: ListItemLayoutBinding) :
        RecyclerView.ViewHolder(adapterListRowBinding.root) {

        fun bind(cakeUiModel: CakeUiModel) {
            this.adapterListRowBinding.setVariable(BR.model, cakeUiModel)
            // Handle click event
            this.adapterListRowBinding.cakeImage.setOnClickListener {
                delegate.onClick(cakeUiModel)
            }
        }
    }

}