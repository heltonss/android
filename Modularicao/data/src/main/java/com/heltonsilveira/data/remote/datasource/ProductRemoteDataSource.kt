package com.heltonsilveira.data.remote.datasource

import com.heltonsilveira.domain.entity.Product
import io.reactivex.Single

interface ProductRemoteDataSource {
    fun getProducts() : Single<List<Product>>
}
