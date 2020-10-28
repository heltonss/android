package com.heltonsilveira.domain.usecases

import com.heltonsilveira.domain.entity.Product
import com.heltonsilveira.domain.repository.ProductRepository
import io.reactivex.Scheduler
import io.reactivex.Single

class GetProductsUseCase(
    private val productRepository: ProductRepository,
    private val scheduler: Scheduler
) {
    fun execute(forceUpdate: Boolean): Single<List<Product>> {
        return productRepository.getProducts(forceUpdate)
            .subscribeOn(scheduler)
    }
}