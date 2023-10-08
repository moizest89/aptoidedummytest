package com.moizest89.data.datasources

import com.moizest89.data.model.AppDetails
import com.moizest89.data.model.AppSearchList
import com.moizest89.data.network.KtorHttpClient
import com.moizest89.data.network.KtorHttpClientConstants
import com.moizest89.data.utils.NetworkResult
import io.ktor.client.request.get

class RemoteDataSourceImpl(
    private val client: KtorHttpClient
) : RemoteDataSource {
    override suspend fun getAppsList(
        appName: String
    ): NetworkResult<AppSearchList> {
        return try {
            val requestData = client.getClient().get<AppSearchList>(KtorHttpClientConstants.GET_APP_LIST.plus(appName))
            NetworkResult.Success(requestData)
        } catch (e: Exception) {
            NetworkResult.Exception(e)
        }
    }

    override suspend fun getAppDetails(packageName: String): NetworkResult<AppDetails> {
        return try {
            val requestData = client.getClient()
                .get<AppDetails>(KtorHttpClientConstants.GET_APP_DETAILS.plus(packageName))
            NetworkResult.Success(requestData)
        } catch (e: Exception) {
            NetworkResult.Exception(e)
        }
    }
}
