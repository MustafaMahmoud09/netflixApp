package com.lomu.uielement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            App()
        }
    }
}

/**
 * JETPACK COMPOSE
 *    * APPLICATION SUPPORT MULTI MODE : DONE
 *    * APPLICATION SUPPORT MULTI SCREEN : DONE
 *    * NESTED NAVIGATION : DONE
 * RETROFIT
 * ROOM DATABASE
 * CACHING
 * HILT INJECTION
 * GOOGLE ARCH
 * PAGINATION
 * **/