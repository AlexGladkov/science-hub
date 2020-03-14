package features.space.rockets.models

import features.space.space_x.models.SpaceXRocket

data class SpaceRocket(val id: String, val name: String, val description: String?,
                       val images: List<String>?, val type: String?)

fun SpaceXRocket.mapToDomain(): SpaceRocket {
    return SpaceRocket(id = rocketId, name = rocketName, description = description,
        images = rocketImages, type = rocketType)
}

