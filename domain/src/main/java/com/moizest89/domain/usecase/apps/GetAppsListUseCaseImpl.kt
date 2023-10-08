package com.moizest89.domain.usecase.apps

import com.moizest89.domain.model.apps.AppItem
import com.moizest89.domain.repository.apps.AppsRepository
import com.moizest89.domain.utils.DataHandler

class GetAppsListUseCaseImpl(
    private val appsRepository: AppsRepository
) : GetAppsListUseCase {

    override suspend fun invoke(appName: String): DataHandler<List<AppItem>> = appsRepository.getAppsList(appName)
}
