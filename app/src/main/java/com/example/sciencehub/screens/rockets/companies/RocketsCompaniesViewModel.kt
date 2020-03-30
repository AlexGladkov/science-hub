package com.example.sciencehub.screens.rockets.companies

import androidx.compose.Model
import base.ServiceLocator
import base.map
import com.example.sciencehub.components.smallInfoCard.SmallInfoCardModel
import com.example.sciencehub.components.smallInfoCard.toSmallCard
import features.space.rockets.models.SpaceRocket
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Model
class RocketsCompaniesState {
    var viewState: RocketsCompaniesViewState = RocketsCompaniesViewState.Empty
}

sealed class RocketsCompaniesViewState {
    object Empty : RocketsCompaniesViewState()
    object Progress : RocketsCompaniesViewState()
    class ShowContent(val data: List<SmallInfoCardModel>) : RocketsCompaniesViewState()
    class Error(val t: Throwable) : RocketsCompaniesViewState()
}

sealed class RocketCompaniesEvent {
    object FetchRocketsCompanies : RocketCompaniesEvent()
}

class RocketsCompaniesViewModel {

    val state: RocketsCompaniesState = RocketsCompaniesState()

    fun obtainEvent(event: RocketCompaniesEvent) {
        when (event) {
            is RocketCompaniesEvent.FetchRocketsCompanies -> fetchCompanies()
        }
    }

    // Internal logic
    private fun fetchCompanies() {
        state.viewState = RocketsCompaniesViewState.Progress
        CoroutineScope(Dispatchers.IO).launch {
            val result = ServiceLocator.fetchSpaceXRocketsUseCase.run(params = Unit)
                .map { response -> response.rockets.map { it.toSmallCard() } }
            withContext(Dispatchers.Main) {
                result.fold(failed = { exception ->
                    state.viewState = RocketsCompaniesViewState.Error(t = exception)
                }, succeeded = { response ->
                    state.viewState = RocketsCompaniesViewState.ShowContent(data = response)
                })
            }
        }
    }
}