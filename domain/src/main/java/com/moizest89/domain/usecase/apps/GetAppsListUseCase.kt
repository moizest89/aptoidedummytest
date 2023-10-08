package com.moizest89.domain.usecase.apps

import com.moizest89.domain.model.apps.AppItem
import com.moizest89.domain.utils.DataHandler

interface GetAppsListUseCase {
    suspend fun invoke(appName: String): DataHandler<List<AppItem>>
}
