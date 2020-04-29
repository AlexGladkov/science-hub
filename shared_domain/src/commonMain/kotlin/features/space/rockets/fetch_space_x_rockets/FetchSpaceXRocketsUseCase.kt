package features.space.rockets.fetch_space_x_rockets

import base.Either
import base.Failure
import base.Success
import base.UseCase
import di.kodein
import features.space.rockets.fetch_productions.ResponseModel
import features.space.rockets.models.SpaceRocketProduction
import features.space.rockets.models.mapToDomain
import features.space.space_x.rockets.RocketsApi
import io.ktor.client.engine.HttpClientEngine
import kotlinx.coroutines.delay
import org.kodein.di.erased.instance

/**
 * This is use case for Fetching Rockets from Space X.
 */

class FetchSpaceXRocketsUseCase(clientEngine: HttpClientEngine): UseCase<RocketsResponseModel, Unit>() {

    private val rocketsApi: RocketsApi by kodein.instance(arg = clientEngine)

    override suspend fun run(params: Unit): Either<Exception, RocketsResponseModel> {
        return try {
            Success(RocketsResponseModel(rockets = rocketsApi.fetchRockets().map { it.mapToDomain() }))
        } catch (e: Exception) {
            Failure(e)
        }
    }
}