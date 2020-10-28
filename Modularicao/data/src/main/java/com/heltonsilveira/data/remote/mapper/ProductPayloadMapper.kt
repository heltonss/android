package com.heltonsilveira.data.remote.mapper

import com.heltonsilveira.data.remote.model.ProductPayload
import com.heltonsilveira.domain.entity.Product

object ProductPayloadMapper {
    fun map(products: List<ProductPayload>) = products.map { map(it) }
    private fun map(productPayload: ProductPayload) = Product(
        name = productPayload.name,
        imageURL = productPayload.imageURL,
        description = productPayload.description
    )
}