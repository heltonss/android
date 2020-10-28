package com.heltonsilveira.data.remote.datasource

import com.heltonsilveira.data.remote.api.ProductAPI
import com.heltonsilveira.data.remote.mapper.ProductPayloadMapper
import com.heltonsilveira.domain.entity.Product
import io.reactivex.Single


class ProductRemoteDataSourceImpl(private val productAPI: ProductAPI) :
    ProductRemoteDataSource {
    override fun getProducts(): Single<List<Product>> {
        return productAPI.getProducts().map { ProductPayloadMapper.map(it) }
    }
}