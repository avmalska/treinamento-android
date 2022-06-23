package br.com.cwi.nespresso_app.domain.entity

abstract class Product(
    var id: Int,
    var name: String,
    var urlImage: String?,
    var unitPrice: Double
): Type(ItemType.PRODUCT)

