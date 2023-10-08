package com.moizest89.domain.repository.apps

import com.moizest89.domain.model.apps.AppItem
import com.moizest89.domain.utils.DataHandler

interface AppsRepository {
    suspend fun getAppsList(appName: String): DataHandler<List<AppItem>>
    suspend fun getAppDetails(packageName: String): DataHandler<AppItem>
}
