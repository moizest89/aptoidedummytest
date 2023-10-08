package com.moizest89.data.repository.user

import com.moizest89.domain.model.user.User
import com.moizest89.domain.repository.user.UserRepository
import com.moizest89.domain.utils.DataHandler
import kotlinx.coroutines.delay

class UserRepositoryImpl() : UserRepository {
    override suspend fun getUser(): DataHandler<User> {
        delay(3000L)
        return DataHandler.onSuccess(
            User(
                dummyName,
                dummyLastName,
                true
            )
        )
    }

    companion object {
        private val dummyName = "Suzanne"
        private val dummyLastName = "Delee"
    }
}
