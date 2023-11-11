package com.lomu.uielement.element.composable

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.lomu.uielement.theme.dimen.CustomDimens
import com.lomu.uielement.theme.mode.CustomColors
import java.util.ArrayList

@Composable
fun RowScope.BottomNavigation(
    navController: NavHostController,
    items: List<ArrayList<out Any>>,
    dimen: CustomDimens,
    theme: CustomColors,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    items.forEach { screen ->
        BottomNavigationItem(
            icon = {
                Icon(
                    painter = painterResource(
                        id = screen[1] as Int
                    ),
                    contentDescription = ""
                )
            },
            label = {
                TextItem(
                    text = stringResource(
                        id = screen[2] as Int
                    ),
                    dimens = dimen
                )
            },
            selectedContentColor = theme.itemSelected,
            unselectedContentColor = theme.colorItemNav,
            selected = currentDestination?.hierarchy?.any { it.route == screen[0] } == true,
            onClick = {
                navController.navigate(screen[0].toString()) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}