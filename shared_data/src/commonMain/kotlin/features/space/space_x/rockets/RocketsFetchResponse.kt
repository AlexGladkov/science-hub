package features.space.space_x.rockets

import features.space.space_x.models.SpaceXRocket
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RocketsFetchResponse(val response: List<SpaceXRocket>)