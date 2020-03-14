package features.space.space_x.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpaceXRocket(
    @SerialName(value = "id") val rawId: Int,
    @SerialName(value = "rocket_id") val rocketId: String,
    @SerialName(value = "rocket_name") val rocketName: String,
    @SerialName(value = "rocket_type") val rocketType: String?,
    @SerialName(value = "flickr_images") val rocketImages: List<String>?,
    @SerialName(value = "description") val description: String?
)