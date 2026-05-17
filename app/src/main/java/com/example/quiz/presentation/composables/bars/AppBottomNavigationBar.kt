package com.example.quiz.presentation.composables.bars

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.quiz.presentation.navigation.Destinations
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun AppBottomNavigationBar(navController: NavHostController) {
    val backStackEntry = navController.currentBackStackEntryAsState().value

    val whitelistedScreens = listOf(
        Destinations.Home,
        Destinations.Search,
        Destinations.Create,
        Destinations.Look,
        Destinations.Profile
    )

    val isBarVisible =
        backStackEntry?.destination?.let { destination ->
            whitelistedScreens.any { screen ->
                destination.hasRoute(screen::class)
            }
        } == true

    if (!isBarVisible)
        return

    NavigationBar(
        modifier = Modifier.clip(
            shape = RoundedCornerShape(
                topStart = 20.dp,
                topEnd = 20.dp
            )
        ),
        windowInsets = NavigationBarDefaults.windowInsets,
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        BottomNavigationItem(this, navController, Destinations.Home)
        BottomNavigationItem(this, navController, Destinations.Search)
        BottomNavigationItem(this, navController, Destinations.Create)
        BottomNavigationItem(this, navController, Destinations.Look)
        BottomNavigationItem(this, navController, Destinations.Profile)
    }
}


@Preview
@Composable
private fun Prev() {
    QuizTheme { AppBottomNavigationBar(rememberNavController()) }
}