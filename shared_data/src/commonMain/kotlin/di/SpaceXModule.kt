package di

import features.space.space_x.rockets.RocketsApi
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import org.kodein.di.Kodein
import org.kodein.di.erased.bind
import org.kodein.di.erased.factory
import org.kodein.di.erased.with

val spaceXModule = Kodein.Module("spaceXModule") {
    constant(tag = "spaceXUrl") with "api.spacexdata.com/v3"
    constant(tag = "spaceXRocketsPath") with "rockets"

    bind<RocketsApi>() with factory { clientEngine: HttpClientEngine ->
        RocketsApi(clientEngine = clientEngine)
    }

    bind<HttpClient>() with factory { clientEngine: HttpClientEngine ->
        HttpClient(clientEngine) {
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.HEADERS
            }
        }
    }
}