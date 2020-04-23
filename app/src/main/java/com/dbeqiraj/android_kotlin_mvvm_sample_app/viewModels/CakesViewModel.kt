package com.dbeqiraj.android_kotlin_mvvm_sample_app.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dbeqiraj.android_kotlin_mvvm_sample_app.models.CakeUiMapper
import com.dbeqiraj.android_kotlin_mvvm_sample_app.models.CakeUiModel
import com.dbeqiraj.android_kotlin_mvvm_sample_app.utils.CoroutineResponse
import com.dbeqiraj.android_kotlin_mvvm_sample_app.utils.LiveDataResult
import com.dbeqiraj.data.interactors.GetCakesUseCase
import com.dibeqiraj.cakeapp.mvp.model.CakesResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CakesViewModel @Inject constructor(
    private val getCakesUseCase: GetCakesUseCase,
    private val coroutineDispatcher: CoroutineDispatcher,
    private val cakeUiMapper: CakeUiMapper
) : ViewModel() {

    private val _fetchResult = MutableLiveData<LiveDataResult<List<CakeUiModel>>>()

    val fetchResult: LiveData<LiveDataResult<List<CakeUiModel>>>
        get() = this._fetchResult

    fun getCakes() {
        viewModelScope.launch {
            _fetchResult.value = LiveDataResult.Loading()

            when (val res = loadData()) {
                is CoroutineResponse.Success<*> -> {
                    val cakes = res.result as CakesResponse
                    _fetchResult.value =
                        LiveDataResult.Success(cakes.cakes.map { cakeUiMapper.map(it) })
                }
                is CoroutineResponse.Error -> {
                    _fetchResult.value = LiveDataResult.Error(res.error)
                }
                else -> {
                }
            }
        }
    }

    private suspend fun loadData(): CoroutineResponse =
        withContext(coroutineDispatcher) {
            try {
                CoroutineResponse.Success(getCakesUseCase.execute())
            } catch (e: Exception) {
                CoroutineResponse.Error(e)
            }
        }
}