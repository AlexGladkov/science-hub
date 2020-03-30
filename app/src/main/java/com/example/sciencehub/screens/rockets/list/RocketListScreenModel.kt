package com.example.sciencehub.screens.rockets.list

import com.example.sciencehub.components.smallInfoCard.SmallInfoCardModel

data class RocketListScreenModel(val id: String, val title: String?)

fun SmallInfoCardModel.mapToRocketList(): RocketListScreenModel {
    return RocketListScreenModel(id = this.id, title = this.title)
}