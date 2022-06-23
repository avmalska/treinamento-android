package br.com.cwi.nespresso_app.domain.entity

class Category(
    val category: String,
    val products: List<Product>,
): Type(ItemType.CATEGORY)