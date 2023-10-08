package com.moizest89.aptoidedummytest.presentation.app.applist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moizest89.domain.model.apps.AppItem
import com.moizest89.domain.usecase.apps.GetAppsListUseCase
import com.moizest89.domain.utils.DataHandler
import kotlinx.coroutines.launch

class AppListViewModel(
    private val getAppsListUseCase: GetAppsListUseCase
) : ViewModel() {

    private val data = MutableLiveData<DataHandler<List<AppItem>>>()
    val _data get() = this.data

    fun getAppListInformation(
        appName: String
    ) = apply {
        viewModelScope.launch {
            _data.value = DataHandler.onLoad(true)
            _data.value = getAppsListUseCase.invoke(appName)
            _data.value = DataHandler.onLoad(false)
        }
    }
}
