package com.moizest89.aptoidedummytest.di

import com.moizest89.aptoidedummytest.presentation.app.appdetails.AppDetailsViewModel
import com.moizest89.aptoidedummytest.presentation.app.applist.AppListViewModel
import com.moizest89.aptoidedummytest.presentation.splash.SplashViewModel
import com.moizest89.data.datasources.RemoteDataSource
import com.moizest89.data.datasources.RemoteDataSourceImpl
import com.moizest89.data.network.KtorHttpClient
import com.moizest89.data.repository.apps.AppsRepositoryImpl
import com.moizest89.data.repository.user.UserRepositoryImpl
import com.moizest89.domain.repository.apps.AppsRepository
import com.moizest89.domain.repository.user.UserRepository
import com.moizest89.domain.usecase.apps.GetAppDetailsUseCase
import com.moizest89.domain.usecase.apps.GetAppDetailsUseCaseImpl
import com.moizest89.domain.usecase.apps.GetAppsListUseCase
import com.moizest89.domain.usecase.apps.GetAppsListUseCaseImpl
import com.moizest89.domain.usecase.user.CheckValidUserUseCase
import com.moizest89.domain.usecase.user.CheckValidUserUseCaseImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getModules() = listOf(
    appModule,
    viewModels,
    domain,
    data,
    dataSources
)

private val appModule = module {
}

private val viewModels = module {
    viewModel { SplashViewModel(get()) }
    viewModel { AppListViewModel(get()) }
    viewModel { AppDetailsViewModel(get()) }
}

private val domain = module {
    single<CheckValidUserUseCase> {
        CheckValidUserUseCaseImpl(get())
    }
    single<GetAppsListUseCase> { GetAppsListUseCaseImpl(get()) }
    single<GetAppDetailsUseCase> { GetAppDetailsUseCaseImpl(get()) }
}
private val data = module {
    single<UserRepository> { UserRepositoryImpl() }
    single<AppsRepository> { AppsRepositoryImpl(get()) }
}
private val dataSources = module {
    single { KtorHttpClient() }
    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }
}
