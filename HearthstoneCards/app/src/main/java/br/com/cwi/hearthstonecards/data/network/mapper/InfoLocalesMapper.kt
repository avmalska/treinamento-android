package br.com.cwi.hearthstonecards.data.network.mapper

import br.com.cwi.hearthstonecards.data.network.entity.InfoLocalesResponse
import br.com.cwi.hearthstonecards.domain.entity.InfoLocales

class InfoLocalesMapper: DomainMapper<InfoLocalesResponse, InfoLocales> {
    override fun toDomain(from: InfoLocalesResponse) = InfoLocales (
        de_de = from.de_de,
        en_gb = from.en_gb,
        en_us = from.en_us,
        es_es = from.es_es,
        es_mx = from.es_mx,
        fr_fr = from.fr_fr,
        it_it = from.it_it,
        ko_kr = from.ko_kr,
        pl_pl = from.pl_pl,
        pt_br = from.pt_br,
        ru_ru = from.ru_ru,
        zh_cn = from.zh_cn,
        zh_tw = from.zh_tw,
        ja_jp = from.ja_jp,
        th_th = from.th_th
    )

    override fun toDomain(from: List<InfoLocalesResponse>) = from.map {
        toDomain(it)
    }

}