package com.example.sciencehub.flows

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Center
import com.example.sciencehub.base.BaseFlowModel
import com.example.sciencehub.base.BaseFlowViewState
import com.example.sciencehub.navigation.NotImplemented
import com.example.sciencehub.navigation.ScreenModel
import com.example.sciencehub.navigation.getKey
import com.example.sciencehub.screens.rockets.companies.RocketCompaniesScreen
import com.example.sciencehub.screens.rockets.list.RocketListScreen
import com.example.sciencehub.screens.rockets.list.RocketListScreenModel
import kotlinx.coroutines.flow.flow

class DigestFlow {

    private val flowModel = BaseFlowModel()
    private val navigateTo: (ScreenModel) -> Unit = {
        flowModel.state.viewState = BaseFlowViewState.Navigate(it)
    }

    init {
        flowModel.state.viewState = BaseFlowViewState.Navigate(
            ScreenModel(key = getKey<RocketCompaniesScreen>(), data = null)
        )
    }

    @Composable
    fun initFlow() {
        (flowModel.state.viewState as? BaseFlowViewState.Navigate)?.let { viewState ->
            when (viewState.screenModel.key) {
                getKey<RocketCompaniesScreen>() -> RocketCompaniesScreen(navigateTo = navigateTo).initScreen()
                getKey<RocketListScreen>() -> {
//                    (viewState.screenModel.data as? RocketListScreenModel)?.let { screenModel ->
                        RocketListScreen().initScreen()
//                    }
                }
                else -> NotImplemented<DigestFlow>(key = viewState.screenModel.key)
            }
        }
    }
}