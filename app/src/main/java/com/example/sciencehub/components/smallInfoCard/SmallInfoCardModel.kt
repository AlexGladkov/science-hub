package com.example.sciencehub.components.smallInfoCard

import features.space.rockets.models.SpaceRocket

data class SmallInfoCardModel(val id: String, val title: String, val subtitle: String)

fun SpaceRocket.toSmallCard(): SmallInfoCardModel {
    return SmallInfoCardModel(id = this.id, title = this.name,
        subtitle = if (this.description.orEmpty().count() > 20) {
            this.description?.substring(0, 20).orEmpty()
        } else {
            this.description.orEmpty()
        })
}