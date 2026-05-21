package com.example.quiz.presentation.composables.bars

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.quiz.R
import com.example.quiz.presentation.navigation.Destinations


@Composable
fun BottomNavigationItem(
    scope: RowScope,
    navController: NavHostController,
    destination: Destinations,
) {
    val currentDestination = navController.currentBackStackEntryAsState()
    //RowScope required
    scope.NavigationBarItem(
        selected = currentDestination == destination,
        onClick = {
            navController.navigate(route = destination)
        },
        icon = {
            Icon(
                painterResource(id = destination.icon ?: R.drawable.ic_eye_close),
                contentDescription = null
            )

        },
//        colors = NavigationBarItemColors(
//            selectedIndicatorColor =
//                MaterialTheme.colorScheme.secondaryContainer
//        )
    )
}