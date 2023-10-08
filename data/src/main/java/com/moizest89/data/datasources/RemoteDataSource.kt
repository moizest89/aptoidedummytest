package com.moizest89.data.datasources

import com.moizest89.data.model.AppDetails
import com.moizest89.data.model.AppSearchList
import com.moizest89.data.utils.NetworkResult

interface RemoteDataSource {
    suspend fun getAppsList(appName: String): NetworkResult<AppSearchList>
    suspend fun getAppDetails(packageName: String): NetworkResult<AppDetails>
}
