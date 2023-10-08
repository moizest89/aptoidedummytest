package com.moizest89.domain.usecase.user

import com.moizest89.domain.repository.user.UserRepository
import com.moizest89.domain.utils.DataHandler
import com.moizest89.domain.utils.DataHandler.onSuccess

class CheckValidUserUseCaseImpl(
    private val userRepository: UserRepository
) : CheckValidUserUseCase {
    override suspend fun invoke(): DataHandler<Boolean> {
        return onSuccess(userRepository.getUser().isSuccess())
    }
}
