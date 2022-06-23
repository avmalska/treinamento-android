package br.com.cwi.nespresso_app.data.mapper

import br.com.cwi.nespresso_app.data.entity.AccessoryResponse
import br.com.cwi.nespresso_app.domain.entity.Accessory

class AccessoryMapper : DomainMapper<AccessoryResponse, Accessory> {

    override fun toDomain(from: AccessoryResponse) = Accessory(
        id = from.id,
        name = from.name,
        description = from.description,
        price = from.price,
        urlImage = from.urlImage
    )


    override fun toDomain(from: List<AccessoryResponse>) = from.map {
        toDomain(it)
    }
}