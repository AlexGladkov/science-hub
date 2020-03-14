package base

import features.space.rockets.fetch_productions.FetchProductionsUseCase
import features.space.rockets.fetch_space_x_rockets.FetchSpaceXRocketsUseCase
import features.space.space_x.rockets.RocketsApi
import io.ktor.client.engine.HttpClientEngine
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object ServiceLocator {

    private val rocketsApi by lazy { RocketsApi(PlatformServiceLocator.httpClientEngine) }

    val fetchProductionsUseCase: FetchProductionsUseCase
        get() = FetchProductionsUseCase()

    val fetchSpaceXRocketsUseCase: FetchSpaceXRocketsUseCase
        get() = FetchSpaceXRocketsUseCase(rocketsApi = rocketsApi)
}

/**
 * Contains some expected dependencies for the [ServiceLocator] that have to be resolved by Android/iOS.
 */
expect object PlatformServiceLocator {
    val httpClientEngine: HttpClientEngine
}