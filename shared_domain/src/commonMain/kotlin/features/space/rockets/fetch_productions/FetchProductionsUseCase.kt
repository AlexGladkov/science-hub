package features.space.rockets.fetch_productions

import base.Either
import base.Failure
import base.Success
import base.UseCase
import features.space.rockets.models.SpaceRocketProduction
import features.space.space_x.rockets.RocketsApi
import kotlinx.coroutines.delay

/**
 * This is use case for Fetching Rockets Production teams e.g.
 * Amazon, SpaceX, RussianSpaceCrafts, etc..
 */

class FetchProductionsUseCase: UseCase<ResponseModel, Unit>() {

    override suspend fun run(params: Unit): Either<Exception, ResponseModel> {
        delay(3000)
        return try {
            Success(
                ResponseModel(
                    productions = listOf(
                        SpaceRocketProduction(
                            id = "1",
                            title = "SpaceX",
                            image = ""
                        ),
                        SpaceRocketProduction(
                            id = "2",
                            title = "Amazon",
                            image = ""
                        ),
                        SpaceRocketProduction(
                            id = "2",
                            title = "Russian SpaceCraft",
                            image = ""
                        )
                    )
                )
            )
        } catch (e: Exception) {
            Failure(e)
        }
    }
}