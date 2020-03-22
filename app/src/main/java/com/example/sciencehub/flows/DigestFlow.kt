package com.example.sciencehub.flows

import android.util.Log
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.layout.Center
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutSize
import base.ServiceLocator
import kotlinx.coroutines.*

@Composable
fun DigestFlow() {
    Center {
        CoroutineScope(Dispatchers.IO).launch {
            val result = ServiceLocator.fetchSpaceXRocketsUseCase.run(params = Unit)
            withContext(Dispatchers.Main) {
                result.fold(failed = { exception ->
                    Log.e("TAG", "Sorry, we can't load the rockets, because ${exception.localizedMessage}")
                }, succeeded = { response ->
                    response.rockets.forEach { spaceRocket ->
                        Log.e("TAG", "Rocket name is - ${spaceRocket.name}")
                    }
                })
            }
        }
    }
}