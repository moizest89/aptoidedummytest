package com.moizest89.domain.usecase.user

import com.moizest89.domain.model.user.User
import com.moizest89.domain.repository.user.UserRepository
import com.moizest89.domain.utils.DataHandler
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class CheckValidUserUseCaseTest {

    private lateinit var checkValidUserUseCase: CheckValidUserUseCase
    private val userRepository: UserRepository = mock()

    @Before
    fun setUp() {
        checkValidUserUseCase = CheckValidUserUseCaseImpl(userRepository)
    }

    @Test
    fun WHEN_get_valid_user_THEN_usecase_return_true() = runBlocking {
        Mockito.`when`(userRepository.getUser()).thenReturn(DataHandler.onSuccess(getDummyUser()))

        val expected = true
        val result = checkValidUserUseCase.invoke()

        assertEquals(expected, result.isSuccess())
    }

    @Test
    fun WHEN_get_valid_invalid_user_THEN_usecase_return_true() = runBlocking {
        Mockito.`when`(userRepository.getUser()).thenReturn(DataHandler.onError())

        val expected = false
        val result = checkValidUserUseCase.invoke()

        assertEquals(expected, !result.isSuccess())
    }

    private fun getDummyUser() = User(
        dummyName,
        dummyLastName,
        true
    )

    companion object {
        private val dummyName = "Suzanne"
        private val dummyLastName = "Delee"
    }
}
