package br.com.cwi.hearthstonecards.data.network.entity

import com.squareup.moshi.Json

class InfoResponse (
    @Json(name = "patch") val patch: String,
    @Json(name = "classes") val classes: List<String>,
    @Json(name = "sets") val sets: List<String>,
    @Json(name = "types") val types: List<String>,
    @Json(name = "factions") val factions: List<String>,
    @Json(name = "qualities") val qualities: List<String>,
    @Json(name = "races") val races: List<String>,
    @Json(name = "locales") val locales: InfoLocalesResponse,
)
