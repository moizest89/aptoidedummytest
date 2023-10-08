package com.moizest89.domain.usecase.apps

import com.moizest89.domain.model.apps.AppItem
import com.moizest89.domain.repository.apps.AppsRepository
import com.moizest89.domain.utils.DataHandler

class GetAppDetailsUseCaseImpl(
    private val appsRepositoryImpl: AppsRepository
) : GetAppDetailsUseCase {
    override suspend fun invoke(packageName: String): DataHandler<AppItem> =
        appsRepositoryImpl.getAppDetails(packageName)
}
