package com.moizest89.aptoidedummytest.presentation.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moizest89.domain.usecase.user.CheckValidUserUseCase
import com.moizest89.domain.utils.DataHandler
import kotlinx.coroutines.launch

class SplashViewModel(
    private val checkValidUserUseCase: CheckValidUserUseCase
) : ViewModel() {

    private val splashStatus = MutableLiveData<DataHandler<Boolean>>()
    val _splasStatus get() = this.splashStatus

    fun validateUser() = apply {
        viewModelScope.launch {
            splashStatus.value = DataHandler.onLoad(true)
            splashStatus.value = checkValidUserUseCase.invoke()
        }
    }
}
