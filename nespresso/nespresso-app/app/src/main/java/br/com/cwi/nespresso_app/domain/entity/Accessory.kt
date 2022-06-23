package br.com.cwi.nespresso_app.domain.entity

class Accessory(
    id: Int,
    name: String,
    price: Double,
    urlImage: String,
    val description: String?
) : Product(
    id,
    name,
    urlImage,
    price
)