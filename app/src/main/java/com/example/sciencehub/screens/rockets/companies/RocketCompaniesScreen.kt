package com.example.sciencehub.screens.rockets.companies

import android.util.Log
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.Border
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.DataTable
import androidx.ui.unit.dp
import base.ServiceLocator
import com.example.sciencehub.base.BaseScreen
import com.example.sciencehub.components.smallInfoCard.SmallInfoCard
import com.example.sciencehub.components.smallInfoCard.SmallInfoCardLayoutParams
import com.example.sciencehub.components.smallInfoCard.SmallInfoCardModel
import com.example.sciencehub.navigation.ScreenModel
import com.example.sciencehub.navigation.getKey
import com.example.sciencehub.screens.rockets.list.RocketListScreen
import features.space.rockets.models.SpaceRocket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RocketCompaniesScreen(private val navigateTo: (ScreenModel) -> Unit): BaseScreen(navigateTo = navigateTo) {

    private val viewModel = RocketsCompaniesViewModel()

    init {
        viewModel.obtainEvent(event = RocketCompaniesEvent.FetchRocketsCompanies)
    }

    @Composable
    override fun initScreen() {
        when (val viewModel = viewModel.state.viewState) {
            is RocketsCompaniesViewState.Empty -> drawEmpty()
            is RocketsCompaniesViewState.Error -> drawError(error = viewModel.t)
            is RocketsCompaniesViewState.Progress -> drawProgress()
            is RocketsCompaniesViewState.ShowContent -> drawContent(data = viewModel.data)
        }
    }

    // Internal composable logic
    @Composable
    private fun drawEmpty() {
        Center {
            Text("No companies")
        }
    }

    @Composable
    private fun drawError(error: Throwable) {
        Center {
            Text("Error ${error.localizedMessage}")
        }
    }

    @Composable
    private fun drawContent(data: List<SmallInfoCardModel>) {
        VerticalScroller {
            DataTable(
                columns = 2, dataRowHeight = SmallInfoCardLayoutParams.cardHeight,
                cellSpacing = EdgeInsets(left = 0.dp, right = 0.dp),
                border = Border(color = Color.White, size = 0.dp)
            ) {
                data.forEach { model ->
                    dataRow { index ->
                        when (index) {
                            0 -> SmallInfoCard(model = model, onClick = {
                                navigateTo.invoke(ScreenModel(key = getKey<RocketListScreen>(), data = it))
                            })
                            1 -> SmallInfoCard(model = model, onClick = {
                                navigateTo.invoke(ScreenModel(key = getKey<RocketListScreen>(), data = it))
                            })
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun drawProgress() {
        Center {
            Text("Loading data")
        }
    }
}