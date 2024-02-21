package com.breens.jetpackcomposeuiconcepts

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mail
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.breens.jetpackcomposeuiconcepts.components.BottomBar
import com.breens.jetpackcomposeuiconcepts.components.ProfileHeaderComponent
import com.breens.jetpackcomposeuiconcepts.components.TaskComponent
import com.breens.jetpackcomposeuiconcepts.components.TitleComponent
import com.breens.jetpackcomposeuiconcepts.taskmanager.data.Task
import com.breens.jetpackcomposeuiconcepts.taskmanager.data.taskList
import com.breens.jetpackcomposeuiconcepts.ui.theme.TaskManagerAppJetpackComposeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerAppJetpackComposeTheme {
               NavigationManager()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun App(gotoSecondScreen:(task : Task)->Unit) {
    var selectedScreen by remember { mutableStateOf(1) }
    val screens = listOf("CalendarMonth", "Home", "Mail")
    var taskList by remember{ mutableStateOf(taskList) }

    Scaffold(
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.height(90.dp),
                backgroundColor = Color.White,
                elevation = 0.dp
            ) {
                screens.forEachIndexed { index, value ->
                    val icon: ImageVector = when(index){
                        0 -> Icons.Filled.CalendarMonth
                        1 -> Icons.Filled.Home
                        2 -> Icons.Filled.Mail
                        else -> Icons.Filled.Error

                    }
                    BottomNavigationItem(
                        selected = selectedScreen == index,
                        onClick = { selectedScreen = index },
                        icon = {
                            Box(modifier = Modifier
                                .size(80.dp)
                                .clip(CircleShape)
                                .background(if (selectedScreen == index) Color.Black else Color.White),
                                contentAlignment = Alignment.Center){
                                Icon(imageVector = icon,
                                    contentDescription = "",
                                    tint = if(selectedScreen==index) Color.White else Color.Black,
                                    modifier = if(selectedScreen==index) Modifier.size(50.dp) else Modifier.size(35.dp))
                            }
                        })
                }
            }
        }
    ) {
        LazyColumn(modifier = Modifier
            .padding(20.dp)
            .fillMaxHeight(.9f)) {
            item {
                ProfileHeaderComponent()
                Spacer(modifier = Modifier.height(20.dp))
                TitleComponent()

                Spacer(modifier = Modifier.height(20.dp))

            }
            items(taskList){
                TaskComponent(task = it, { gotoSecondScreen(it) })
            }
        }
    }

}