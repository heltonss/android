package com.heltonsilveira.data.di

import com.heltonsilveira.data.local.database.ProductsDatabase
import com.heltonsilveira.data.local.datasource.ProductCacheDataSource
import com.heltonsilveira.data.local.datasource.ProductCacheDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val cacheDataModule = module {

    single { ProductsDatabase.createDatabase(androidContext()) }

    factory<ProductCacheDataSource> { ProductCacheDataSourceImpl(productDao = get())  }

}
