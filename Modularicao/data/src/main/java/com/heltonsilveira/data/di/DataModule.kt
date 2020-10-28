package com.heltonsilveira.data.di

import com.heltonsilveira.data.repository.ProductRepositoryImpl
import com.heltonsilveira.domain.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<ProductRepository> {
        ProductRepositoryImpl(
            productsCacheDataSource = get(),
            productRemoteDataSource = get()
        )
    }
}
val dataModules = listOf(remoteDataSourceModule, repositoryModule, cacheDataModule)