package com.breens.jetpackcomposeuiconcepts

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.breens.jetpackcomposeuiconcepts.components.TaskDetailScreen

@Composable
fun NavigationManager() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "first_screen"){

        composable(route="task_detail/{title}/{body}/{startTime}/{endTime}"){
            val title = it.arguments?.getString("title") ?: ""
            val body = it.arguments?.getString("body") ?: ""
            val startTime = it.arguments?.getString("startTime") ?: ""
            val endTime = it.arguments?.getString("endTime") ?: ""
            TaskDetailScreen(title,body,startTime, endTime){
                navController.navigate("first_screen")
            }
        }

        composable(route="first_screen"){
            App(){
                navController.navigate("task_detail/${it.title}/${it.body}/${it.startTime}/${it.endTime}")
            }
        }
    }

}