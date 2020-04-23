package com.dbeqiraj.android_kotlin_mvvm_sample_app.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.dbeqiraj.android_kotlin_mvvm_sample_app.R
import com.dbeqiraj.android_kotlin_mvvm_sample_app.base.BaseFragment
import com.dbeqiraj.android_kotlin_mvvm_sample_app.databinding.FragmentHomeBinding
import com.dbeqiraj.android_kotlin_mvvm_sample_app.models.CakeUiModel
import com.dbeqiraj.android_kotlin_mvvm_sample_app.ui.DetailFragment.Companion.CAKE
import com.dbeqiraj.android_kotlin_mvvm_sample_app.utils.LiveDataResult
import com.dbeqiraj.android_kotlin_mvvm_sample_app.viewModels.CakesViewModel
import com.dbeqiraj.android_kotlin_mvvm_sample_app.viewModels.DaggerViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    @Inject
    lateinit var daggerAndroidViewModelFactory: DaggerViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AndroidSupportInjection.inject(this)
        hideBackArrow()
        initializeList()
        cakesViewModel.fetchResult.observe(viewLifecycleOwner, observer)
        cakesViewModel.getCakes()
    }

    private val observer = Observer<LiveDataResult<List<CakeUiModel>>> {
        when (it) {
            is LiveDataResult.Loading -> {
                showDialog("Fetching cakes...")
            }
            is LiveDataResult.Success -> {
                hideDialog()
                (fragmentLayoutBinding.cakeList.adapter as CakesAdapter).submitList(it.result)
            }
            is LiveDataResult.Error -> {
                hideDialog()
            }
        }
    }

    private val cakesViewModel: CakesViewModel by lazy {
        daggerAndroidViewModelFactory.create(CakesViewModel::class.java)
    }

    private fun initializeList() {
        fragmentLayoutBinding.cakeList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = CakesAdapter(diffUtil, adapterDelegate)
        }
    }

    private val adapterDelegate = object : AdapterDelegate {
        override fun onClick(cakeUiModel: CakeUiModel) {
            val bundle = bundleOf(
                CAKE to cakeUiModel
            )
            navController.navigate(R.id.goToDetail, bundle)
        }
    }

    private val diffUtil = object : DiffUtil.ItemCallback<CakeUiModel>() {
        override fun areItemsTheSame(oldItem: CakeUiModel, newItem: CakeUiModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CakeUiModel, newItem: CakeUiModel): Boolean {
            return oldItem.id == newItem.id
        }
    }

    interface AdapterDelegate {
        fun onClick(cakeUiModel: CakeUiModel)
    }
}