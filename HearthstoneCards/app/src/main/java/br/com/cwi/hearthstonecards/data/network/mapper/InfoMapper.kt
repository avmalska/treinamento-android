package br.com.cwi.hearthstonecards.data.network.mapper

import br.com.cwi.hearthstonecards.data.network.entity.InfoResponse
import br.com.cwi.hearthstonecards.domain.entity.Info

class InfoMapper: DomainMapper<InfoResponse, Info> {

    override fun toDomain(from: InfoResponse) = Info (
        patch = from.patch,
        classes = from.classes,
        sets = from.sets,
        types = from.types,
        factions = from.factions,
        qualities = from.qualities,
        races = from.races,
        locales = InfoLocalesMapper().toDomain(from.locales)
    )

    override fun toDomain(from: List<InfoResponse>) = from.map {
        toDomain(it)
    }

}