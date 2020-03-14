package features.space.rockets.fetch_space_x_rockets

import features.space.rockets.models.SpaceRocket
import features.space.rockets.models.mapToDomain
import features.space.space_x.rockets.RocketsFetchResponse

data class RocketsResponseModel(val rockets: List<SpaceRocket>)

fun RocketsFetchResponse.mapToDomain(): RocketsResponseModel {
    return RocketsResponseModel(rockets = response.map { it.mapToDomain() })
}