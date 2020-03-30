package com.example.sciencehub.screens.rockets.list

import androidx.compose.Composable
import com.example.sciencehub.base.BaseScreen
import com.example.sciencehub.flows.DigestFlow
import com.example.sciencehub.navigation.NotImplemented
import com.example.sciencehub.navigation.getKey

class RocketListScreen(val rocketListScreenModel: RocketListScreenModel? = null): BaseScreen() {

    @Composable
    override fun initScreen() {
        NotImplemented<DigestFlow>(key = getKey<RocketListScreen>())
    }

}