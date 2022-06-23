package br.com.cwi.nespresso_app.domain.entity

class Machine(
    id: Int,
    var description: String,
    var imageUrl: String,
    name: String,
    urlImage: String?,
    unitPrice: Double
) : Product(id, name, urlImage, unitPrice)