package br.com.cwi.nespresso_app.data.mapper

import br.com.cwi.nespresso_app.data.entity.CoffeeResponse
import br.com.cwi.nespresso_app.domain.entity.Coffee

class CoffeeMapper: DomainMapper<CoffeeResponse, Coffee> {

    override fun toDomain(from: CoffeeResponse) = Coffee(
        id = from.id,
        name = from.name,
        description = from.description,
        intensity = from.intensity,
        unitPrice = from.unitPrice,
        urlImage = from.urlImage,
        measures = from.measures
    )


    override fun toDomain(from: List<CoffeeResponse>) = from.map {
        toDomain(it)
    }
}