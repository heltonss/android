package com.heltonsilveira.domain.repository

import com.heltonsilveira.domain.entity.Product
import io.reactivex.Single

interface ProductRepository {
    fun getProducts(forceUpdate: Boolean):
            Single<List<Product>>
}