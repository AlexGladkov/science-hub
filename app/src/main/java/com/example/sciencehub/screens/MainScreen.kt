package com.example.sciencehub.screens

import android.app.Application
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Text
import androidx.ui.layout.*
import androidx.ui.material.BottomNavigation
import androidx.ui.material.BottomNavigationItem
import androidx.ui.unit.dp
import com.example.sciencehub.components.bottomNavigation.TabItem
import com.example.sciencehub.flows.DigestFlow
import com.example.sciencehub.flows.EventsFlow
import com.example.sciencehub.flows.FeedFlow
import com.example.sciencehub.flows.ProfileFlow

@Model
class ApplicationState {
    var tabItem: TabItem = TabItem.Feed
}

@Composable
fun MainScreen() {
    val applicationState = ApplicationState()

    Column(modifier = LayoutSize.Fill) {
        Container(modifier = LayoutWeight(1f) + LayoutWidth.Fill) {
            when (applicationState.tabItem) {
                TabItem.Feed -> FeedFlow()
                TabItem.Event -> EventsFlow()
                TabItem.Profile -> ProfileFlow()
                TabItem.Digest -> DigestFlow()
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