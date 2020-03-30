package com.example.sciencehub.flows

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Center
import com.example.sciencehub.base.BaseFlowModel
import com.example.sciencehub.base.BaseFlowViewState
import com.example.sciencehub.navigation.ScreenModel
import com.example.sciencehub.navigation.getKey
import com.example.sciencehub.screens.rockets.companies.RocketCompaniesScreen

class EventsFlow {

    private val flowModel = BaseFlowModel()

    init {
        flowModel.state.viewState = BaseFlowViewState.Navigate(
            ScreenModel(key = getKey<RocketCompaniesScreen>(), data = null)
        )
    }

    @Composable
    fun initFlow() {
        (flowModel.state.viewState as? BaseFlowViewState.Navigate)?.let { viewState ->
            when (viewState.screenModel.key) {
                // TODO: - Add screen navigation
            }
        }
    }
}