package com.moizest89.domain.repository.user

import com.moizest89.domain.model.user.User
import com.moizest89.domain.utils.DataHandler

interface UserRepository {
    suspend fun getUser(): DataHandler<User>
}
