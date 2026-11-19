
package com.example.contoh7.uicontroller

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.contoh7.view.DestinasiEntry
import com.example.contoh7.view.DestinasiHome
import com.example.contoh7.view.EntrySiswaScreen
import com.example.contoh7.view.HomeScreen
import com.example.contoh7.view.route.DestinasiDetailSiswa
import com.example.contoh7.view.route.DestinasiEditSiswa

@Composable
fun SiswaApp(
    navController: NavHostController = rememberNavController()
) {
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {

        // Halaman Home
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = {
                    navController.navigate(DestinasiEntry.route)
                },
                navigateToDetailItem = { id ->
                    navController.navigate(
                        "${DestinasiDetailSiswa.route}/$id"
                    )
                }
            )
        }

        // Halaman Entry
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

        // Halaman Detail
        composable(
            route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiDetailSiswa.itemIdArg) {
                    type = NavType.IntType
                }
            )
        ) {
            DetailSiswaScreen(
                navigateToEditItem = { id ->
                    navController.navigate(
                        "${DestinasiEditSiswa.route}/$id"
                    )
                },
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

        // Halaman Edit
        composable(
            route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(
                navArgument(DestinasiEditSiswa.itemIdArg) {
                    type = NavType.IntType
                }
            )
        ) {
            EditSiswaScreen(
                navigateBack = {
                    navController.popBackStack()
                },
                onNavigateUp = {
                    navController.popBackStack()
                }
            )
        }
    }
}
