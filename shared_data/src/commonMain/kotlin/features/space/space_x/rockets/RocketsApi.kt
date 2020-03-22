package features.space.space_x.rockets

import common.RemoteContract
import features.space.space_x.models.SpaceXRocket
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.response.HttpResponse
import io.ktor.client.response.readText
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.parseList

@Suppress("EXPERIMENTAL_API_USAGE")
class RocketsApi(clientEngine: HttpClientEngine) {

    /**
     * Http client creation for this request
     * @param clientEngine - real engine
     */
    private val client = HttpClient(clientEngine) {
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

    /**
     * Fetch rockets from space x storage implementation
     */
    @UseExperimental(ImplicitReflectionSerializer::class)
    suspend fun fetchRockets(): List<SpaceXRocket> {
        val response = client.get<HttpResponse> {
            url {
                protocol = URLProtocol.HTTPS
                method = HttpMethod.Get
                host = RemoteContract.spaceXBaseUrl
                encodedPath = "rockets"
            }
        }

        val jsonBody = response.readText()
        return Json.nonstrict.parseList(jsonBody)
    }
}