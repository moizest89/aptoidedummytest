package com.moizest89.domain.usecase.apps

import com.moizest89.domain.model.apps.AppItem
import com.moizest89.domain.utils.DataHandler

interface GetAppDetailsUseCase {
    suspend fun invoke(packageName: String): DataHandler<AppItem>
}
