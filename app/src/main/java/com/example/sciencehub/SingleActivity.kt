package com.example.sciencehub

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.lifecycle.ViewModelProviders
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.layout.*
import androidx.ui.material.BottomNavigation
import androidx.ui.material.BottomNavigationItem
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.sciencehub.components.bottomNavigation.TabItem
import com.example.sciencehub.flows.DigestFlow
import com.example.sciencehub.flows.EventsFlow
import com.example.sciencehub.flows.FeedFlow
import com.example.sciencehub.flows.ProfileFlow
import com.example.sciencehub.screens.MainScreen

class SingleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MaterialTheme {
                MainScreen().initScreen()
            }
        }
    }
}


