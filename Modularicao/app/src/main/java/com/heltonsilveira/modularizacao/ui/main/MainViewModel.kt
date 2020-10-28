package com.heltonsilveira.modularizacao.ui.main

import androidx.lifecycle.MutableLiveData
import com.heltonsilveira.domain.entity.Product
import com.heltonsilveira.domain.usecases.GetProductsUseCase
import com.heltonsilveira.modularizacao.viewmodel.BaseViewModel
import com.heltonsilveira.modularizacao.viewmodel.StateMachineSingle
import com.heltonsilveira.modularizacao.viewmodel.ViewState
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.plusAssign

class MainViewModel(
    val useCase: GetProductsUseCase,
    val uiScheduler: Scheduler
): BaseViewModel() {

    val state = MutableLiveData<ViewState<List<Product>>>().apply {
        value = ViewState.Loading
    }

    fun getProducts(forceUpdate: Boolean = false) {
        disposables += useCase.execute(forceUpdate = forceUpdate)
            .compose(StateMachineSingle())
            .observeOn(uiScheduler)
            .subscribe(
                {
                    //onSuccess
                    state.postValue(it)
                },
                {
                    //onError
                }
            )
    }
}