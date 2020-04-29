package com.example.sciencehub.screens

import android.app.Application
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Text
import androidx.ui.layout.*
import androidx.ui.material.BottomNavigation
import androidx.ui.material.BottomNavigationItem
import androidx.ui.unit.dp
import com.example.sciencehub.base.BaseScreen
import com.example.sciencehub.components.bottomNavigation.TabItem
import com.example.sciencehub.flows.DigestFlow
import com.example.sciencehub.flows.EventsFlow
import com.example.sciencehub.flows.FeedFlow
import com.example.sciencehub.flows.ProfileFlow

@Model
class ApplicationState {
    var tabItem: TabItem = TabItem.Digest
}

class MainScreen: BaseScreen() {

    private val feedFlow = FeedFlow()
    private val eventsFlow = EventsFlow()
    private val profileFlow = ProfileFlow()
    private val digestFlow = DigestFlow()

    @Composable
    override fun initScreen() {
        val applicationState = ApplicationState()

        Column(modifier = LayoutSize.Fill) {
            Container(modifier = LayoutWeight(1f) + LayoutWidth.Fill) {
                when (applicationState.tabItem) {
                    TabItem.Feed -> feedFlow.initFlow()
                    TabItem.Event -> eventsFlow.initFlow()
                    TabItem.Profile -> profileFlow.initFlow()
                    TabItem.Digest -> digestFlow.initFlow()
                }
            }
            BottomNavigation(
                modifier = LayoutWidth.Fill + LayoutHeight.Constrain(
                    maxHeight = 56.dp, minHeight = 56.dp
                )
            ) {
                listOf(
                    BottomNavigationItem(icon = { }, text = { Text("Feed") },
                        selected = true, onSelected = { applicationState.tabItem = TabItem.Feed }),
                    BottomNavigationItem(icon = { }, text = { Text("Digest") },
                        selected = false, onSelected = { applicationState.tabItem = TabItem.Digest }),
                    BottomNavigationItem(icon = { }, text = { Text("Events") },
                        selected = false, onSelected = { applicationState.tabItem = TabItem.Event }),
                    BottomNavigationItem(icon = { }, text = { Text("Profile") },
                        selected = false, onSelected = { applicationState.tabItem = TabItem.Profile })
                )
            }
        }
    }

}