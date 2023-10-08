package com.moizest89.aptoidedummytest.presentation.app.appdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moizest89.domain.model.apps.AppItem
import com.moizest89.domain.usecase.apps.GetAppDetailsUseCase
import com.moizest89.domain.utils.DataHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppDetailsViewModel(
    private val getAppDetailsUseCase: GetAppDetailsUseCase
) : ViewModel() {

    private val _dataState = MutableStateFlow<DataHandler<AppItem>>(DataHandler.onLoad(true))
    val dataState: StateFlow<DataHandler<AppItem>> = _dataState

    fun fetchData(packageName: String) {
        viewModelScope.launch {
            _dataState.value = getAppDetailsUseCase.invoke(packageName)
        }
    }
}
