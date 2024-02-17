package com.breens.jetpackcomposeuiconcepts.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.breens.jetpackcomposeuiconcepts.R
import com.breens.jetpackcomposeuiconcepts.taskmanager.data.Task
import com.breens.jetpackcomposeuiconcepts.ui.theme.LightBlue
import com.breens.jetpackcomposeuiconcepts.ui.theme.LightGreen
import com.breens.jetpackcomposeuiconcepts.ui.theme.LightPurple

@Composable
fun TaskComponent(task: Task) {
    val taskColor = listOf(LightBlue, LightPurple, LightGreen).random()
    Row(modifier = Modifier
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)) {

        Text(text = "${task.startTime}\nAM",
            fontFamily = FontFamily(Font(R.font.nunito_bold)),
                textAlign = TextAlign.Center)


        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(modifier = Modifier
                .size(15.dp)
                .clip(CircleShape)
                .background(Color.White)
                .border(
                    border = BorderStroke(4.dp, Color.Black),
                    shape = CircleShape
                ))

            Divider(modifier = Modifier.width(10.dp), color = Color.Black)

            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(10.dp,10.dp,0.dp,10.dp),
                backgroundColor = taskColor
            ) {
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = task.title,
                        fontFamily = FontFamily(Font(R.font.nunito_bold)),
                        style = MaterialTheme.typography.h6
                        
                    )



                    Text(text = task.body,
                        fontFamily = FontFamily(Font(R.font.nunito_regular)),
                        fontSize = 13.sp,
                        modifier = Modifier.fillMaxWidth(.85f)
                    )
                    Text(text = "${task.startTime} - ${task.endTime} AM",
                        fontFamily = FontFamily(Font(R.font.nunito_bold)),
                        fontSize = 12.sp
                    )
                }
            }
            Divider(modifier = Modifier.fillMaxWidth(), color = Color.Black)

            }

        }
    }
