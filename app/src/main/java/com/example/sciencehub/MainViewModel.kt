package com.example.sciencehub

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import base.ServiceLocator
import base.map
import features.space.rockets.fetch_productions.FetchProductionsUseCase
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    fun fetchProductions() {
        viewModelScope.launch {
            ServiceLocator.fetchSpaceXRocketsUseCase.invoke(params = Unit,
                onFailure = {
                    Log.e("TAG", "Error $it")
                }, onSuccess = {
                    it.rockets.forEach { rocket ->
                        Log.e("TAG", rocket.name)
                    }
                })
        }
    }
}