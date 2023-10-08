package com.moizest89.data.repository.apps

import com.moizest89.data.datasources.RemoteDataSource
import com.moizest89.data.mapper.toAppItem
import com.moizest89.data.utils.NetworkResult
import com.moizest89.data.utils.NetworkResult.Error
import com.moizest89.data.utils.NetworkResult.Exception
import com.moizest89.data.utils.NetworkResult.Success
import com.moizest89.domain.model.apps.AppItem
import com.moizest89.domain.repository.apps.AppsRepository
import com.moizest89.domain.utils.DataHandler
import com.moizest89.domain.utils.DataHandler.onError
import com.moizest89.domain.utils.DataHandler.onSuccess

class AppsRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : AppsRepository {
    override suspend fun getAppsList(
        appName: String
    ): DataHandler<List<AppItem>> {
        return when (val result = remoteDataSource.getAppsList(appName)) {
            is NetworkResult.Error -> onError(message = "Request Error")
            is NetworkResult.Exception -> onError(message = result.e.message)
            is Success -> {
                onSuccess(data = result.data.datalist.list.map { it.toAppItem() })
            }
        }
    }

    override suspend fun getAppDetails(
        packageName: String
    ): DataHandler<AppItem> {
        return when (val result = remoteDataSource.getAppDetails(packageName)) {
            is Error -> onError(message = "Request Error")
            is Exception -> onError(message = result.e.message)
            is Success -> {
                result.data.nodes.meta?.data?.let {
                    onSuccess(data = it.toAppItem())
                } ?: run {
                    onError(message = "Empty Info")
                }
            }
        }
    }
}
