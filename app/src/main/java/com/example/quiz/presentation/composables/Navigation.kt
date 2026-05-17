package com.example.quiz.presentation.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quiz.R
import com.example.quiz.presentation.screen.create.CreateScreen
import com.example.quiz.presentation.screen.mywork.workquiz.MyWorkScreen
import com.example.quiz.presentation.screen.profile.ProfileScreen
import com.example.quiz.presentation.screen.resolved.ResolvedWorkScreen
import com.example.quiz.presentation.screen.search.SerchScreen
import com.example.quiz.ui.theme.QuizTheme

enum class Destination(
    val route: String,
    val icon: Int,
    val contentDescription: String
) {
    HOME("home", R.drawable.ic_home, ""),
    SEARCH("search", R.drawable.ic_search, ""),
    ADD("add", R.drawable.ic_file_addition, ""),
    LOOK("look", R.drawable.ic_all_application, ""),
    PROFILE("profile", R.drawable.ic_profile, "")
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: Destination,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController,
        startDestination = startDestination.route
    ) {
        Destination.entries.forEach { destination ->
            composable(destination.route) {
                when (destination) {
                    Destination.SEARCH -> SerchScreen()
                    Destination.HOME -> MyWorkScreen()
                    Destination.LOOK -> ResolvedWorkScreen()
                    Destination.ADD -> CreateScreen(Modifier, navHostController = rememberNavController() )
                    Destination.PROFILE -> ProfileScreen()
                }
            }
        }
    }
}


@Composable
fun NavigationBar(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val startDestination = Destination.HOME
    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    Scaffold(
        modifier = modifier,
        bottomBar = {
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
                Destination.entries.forEachIndexed { index, destination ->
                    NavigationBarItem(
                        selected = selectedDestination == index,
                        onClick = {
                            navController.navigate(route = destination.route)
                            selectedDestination = index
                        },
                        icon = {
                            Icon(painterResource(id = destination.icon), contentDescription = null)

                        },
//                        colors = NavigationBarItemColors(
//                            selectedIndicatorColor =
//                                MaterialTheme.colorScheme.secondaryContainer
//                        )
                    )
                }
            }
        }
    ) { contentPadding ->
        AppNavHost(navController, startDestination, modifier = Modifier.padding(contentPadding))
    }
}

@Preview
@Composable
private fun Prev() {
    QuizTheme { NavigationBar(Modifier) }

}