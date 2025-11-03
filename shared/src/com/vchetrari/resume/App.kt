package com.vchetrari.resume

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vchetrari.resume.feature.home.HomeScreen
import com.vchetrari.resume.feature.home.homeModule
import com.vchetrari.resume.feature.launch.LaunchScreen
import com.vchetrari.resume.feature.launch.launchModule
import org.koin.compose.KoinApplication

@Composable
fun App() {
    KoinApplication(
        application = {
            modules(
                launchModule,
                homeModule,
            )
        }
    ) {
        MaterialTheme {
            AppRouting()
        }
    }
}

@Composable
private fun AppRouting() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppRoute.Launch,
    ) {
        composable<AppRoute.Launch> {
            LaunchScreen(
                onResult = { result ->
                    if (result.isSuccess) navController.navigate(AppRoute.Home) {
                        launchSingleTop = true
                    } else {
                        //TODO check how to action with errors
                        navController.popBackStack()
                    }
                },
            )
        }
        composable<AppRoute.Home> { HomeScreen() }
    }
}
