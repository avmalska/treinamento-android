package br.com.cwi.nespresso_app.data.mapper

import br.com.cwi.nespresso_app.data.entity.MachineResponse
import br.com.cwi.nespresso_app.domain.entity.Machine

class MachineMapper : DomainMapper<MachineResponse, Machine> {

    override fun toDomain(from: MachineResponse) = Machine(
        id = from.id,
        description = from.description,
        imageUrl = from.imageUrl,
        name = from.name,
        urlImage = from.imageUrl,
        unitPrice = from.price
    )

    override fun toDomain(from: List<MachineResponse>) = from.map {
        toDomain(it)
    }
}