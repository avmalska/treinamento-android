package br.com.cwi.hearthstonecards.data.network.entity

import com.squareup.moshi.Json

class InfoLocalesResponse(
    @Json(name = "DE_DE") val de_de: String,
    @Json(name = "EN_GB") val en_gb: String,
    @Json(name = "EN_US") val en_us: String,
    @Json(name = "ES_ES") val es_es: String,
    @Json(name = "ES_MX") val es_mx: String,
    @Json(name = "FR_FR") val fr_fr: String,
    @Json(name = "IT_IT") val it_it: String,
    @Json(name = "KO_KR") val ko_kr: String,
    @Json(name = "PL_PL") val pl_pl: String,
    @Json(name = "PT_BR") val pt_br: String,
    @Json(name = "RU_RU") val ru_ru: String,
    @Json(name = "ZH_CN") val zh_cn: String,
    @Json(name = "ZH_TW") val zh_tw: String,
    @Json(name = "JA_JP") val ja_jp: String,
    @Json(name = "TH_TH") val th_th: String,
)