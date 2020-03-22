package features.space.rockets.fetch_space_x_rockets

import base.Either
import base.Failure
import base.Success
import base.UseCase
import features.space.rockets.fetch_productions.ResponseModel
import features.space.rockets.models.SpaceRocketProduction
import features.space.rockets.models.mapToDomain
import features.space.space_x.rockets.RocketsApi
import kotlinx.coroutines.delay

/**
 * This is use case for Fetching Rockets from Space X.
 */

class FetchSpaceXRocketsUseCase(private val rocketsApi: RocketsApi): UseCase<RocketsResponseModel, Unit>() {

    override suspend fun run(params: Unit): Either<Exception, RocketsResponseModel> {
        return try {
            Success(RocketsResponseModel(rockets = rocketsApi.fetchRockets().map { it.mapToDomain() }))
        } catch (e: Exception) {
            Failure(e)
        }
    }
}