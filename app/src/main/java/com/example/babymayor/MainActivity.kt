package com.example.babymayor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.CurrencyExchange
import androidx.compose.material.icons.outlined.Event
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.babymayor.data.model.NavBar
import com.example.babymayor.ui.screens.EventView
import com.example.babymayor.ui.screens.FinanceView
import com.example.babymayor.ui.screens.MyView
import com.example.babymayor.ui.screens.TaskView
import com.example.babymayor.ui.theme.BabyMayorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            BabyMayorTheme {
                CustomScaffold()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomScaffold() {
    // topBar title
    val topBarTitle = remember { mutableStateOf("Tasks") }

    val navBarList = listOf(
        NavBar(Icons.Outlined.CheckCircle, "Tasks"),
        NavBar(Icons.Outlined.Event, "Events"),
        NavBar(Icons.Outlined.CurrencyExchange, "Finance"),
        NavBar(Icons.Outlined.Person, "My")
    )
    val selectedNavBarIndex = remember { mutableStateOf(0) }

    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(topBarTitle.value)
                }
            )
        },
        bottomBar = {
            NavigationBar {
                // traverses the list of navBarList
                navBarList.forEachIndexed { index, navBar ->
                    NavigationBarItem(
                        selected = selectedNavBarIndex.value == index,
                        onClick = {
                            topBarTitle.value = navBar.label
                            selectedNavBarIndex.value = index
                            navController.navigate(navBar.label)
                        },
                        icon = {
                            Icon(
                                imageVector = navBar.icon,
                                contentDescription = navBar.label
                            )
                        },
                        label = {
                            Text(navBar.label)
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        )
        {
            NavHost(
                navController = navController,
                startDestination = "tasks"
            ) {
                composable("Tasks") { TaskView() }
                composable("Events") { EventView() }
                composable("Finance") { FinanceView() }
                composable("My") { MyView() }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    BabyMayorTheme {
        CustomScaffold()
    }
}