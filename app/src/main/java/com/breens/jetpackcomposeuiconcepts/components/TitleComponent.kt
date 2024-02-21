package com.breens.jetpackcomposeuiconcepts.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.breens.jetpackcomposeuiconcepts.R
import com.breens.jetpackcomposeuiconcepts.taskmanager.data.Task
import com.breens.jetpackcomposeuiconcepts.taskmanager.data.taskList
import com.breens.jetpackcomposeuiconcepts.ui.theme.LightGray


@Composable
fun TitleComponent() {

    var showDialog by remember { mutableStateOf(false) }
    var taskTitle by remember {
        mutableStateOf("")
    }
    var taskBody by remember {
        mutableStateOf("")
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                text = "Hi David!",
                fontFamily = FontFamily(Font(R.font.nunito_extrabold)),
                fontSize = 22.sp
            )



            Text(
                text = taskList.size.toString() + " tasks for today",
                modifier = Modifier.offset(x = 14.dp),
                fontFamily = FontFamily(Font(R.font.nunito_regular)),
                fontSize = 18.sp,
                color = LightGray
            )
        }

        Icon(imageVector = Icons.Filled.AddCircle,
            contentDescription = "add",
            modifier = Modifier.clickable {
                    showDialog = true
            })

        if (showDialog){
            AlertDialog(onDismissRequest = { showDialog=false },
                confirmButton = { /*TODO*/ },
                title = { Text("Add a new task")},
                text = {
                    Column {
                        OutlinedTextField(value = taskTitle, 
                            onValueChange = {taskTitle=it},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp))

                        OutlinedTextField(value = taskBody,
                            onValueChange = {taskBody=it},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp))
                        
                        Button(onClick = {
                            showDialog=false
                           taskList.add( Task(
                                15,
                                taskTitle,
                                taskBody,
                                "10:00",
                                "11:00"
                            )
                           )

                        }) {
                            Text(text = "Submit")
                            
                        }
                    }
                })
            }
        }
    }

