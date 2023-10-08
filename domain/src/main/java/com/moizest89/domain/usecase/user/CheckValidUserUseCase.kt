package com.moizest89.domain.usecase.user

import com.moizest89.domain.utils.DataHandler

interface CheckValidUserUseCase {
    suspend fun invoke(): DataHandler<Boolean>
}
