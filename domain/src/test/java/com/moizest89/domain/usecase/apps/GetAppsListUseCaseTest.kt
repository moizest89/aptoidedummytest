package com.moizest89.domain.usecase.apps

import com.moizest89.domain.model.apps.AppItem
import com.moizest89.domain.repository.apps.AppsRepository
import com.moizest89.domain.utils.DataHandler
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
class GetAppsListUseCaseTest {

    private lateinit var getAppsListUseCase: GetAppsListUseCase
    private val appsRepository: AppsRepository = mock()

    @Before
    fun setUp() {
        getAppsListUseCase = GetAppsListUseCaseImpl(
            appsRepository
        )
    }

    @Test
    fun WHEN_try_to_get_app_list_by_name_THEN_get_app_list() = runBlocking {
        Mockito.`when`(appsRepository.getAppsList(DUMMY_APP_NAME))
            .thenReturn(DataHandler.onSuccess(data = dummyAppList()))

        getAppsListUseCase.invoke(DUMMY_APP_NAME)
        val expected = DataHandler.onSuccess(data = dummyAppList())
        assertEquals(expected, getAppsListUseCase.invoke(DUMMY_APP_NAME))
    }

    @Test
    fun WHEN_try_to_get_app_list_by_invalid_name_THEN_get_empty_list() = runBlocking {
        Mockito.`when`(appsRepository.getAppsList(DUMMY_APP_NAME))
            .thenReturn(DataHandler.onSuccess(data = emptyList()))
        getAppsListUseCase.invoke(DUMMY_APP_NAME)
        val expected = 0
        val result = (getAppsListUseCase.invoke(DUMMY_APP_NAME) as DataHandler.onSuccess).data
        assertEquals(expected, result.size)
    }

    private fun dummyAppList() = mutableListOf(
        AppItem(
            name = DUMMY_APP_NAME
        )
    )

    companion object {
        const val DUMMY_APP_NAME = "appName"
    }
}
