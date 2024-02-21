package com.breens.jetpackcomposeuiconcepts.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.breens.jetpackcomposeuiconcepts.R
import com.breens.jetpackcomposeuiconcepts.taskmanager.data.taskList
import com.breens.jetpackcomposeuiconcepts.ui.theme.LightBlue
import com.breens.jetpackcomposeuiconcepts.ui.theme.LightGreen
import com.breens.jetpackcomposeuiconcepts.ui.theme.LightPurple

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewSecondScreen() {
    TaskDetailScreen(title = "dbfjbf", body = "sdfsfsd", startTime = "5:00AM", "6:00PM") {
        
    }
}
@Composable
fun TaskDetailScreen(
    title: String,
    body: String,
    startTime: String,
    endTime: String,
    navigateToFirstScreen: () -> Unit
) {
    val taskColor = listOf(LightBlue, LightPurple, LightGreen).random()
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth(.8f)
                    .height(200.dp)
                    .padding(10.dp, 10.dp, 0.dp, 10.dp)
                    .clickable { navigateToFirstScreen() },
                backgroundColor = taskColor
            ) {
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = title,
                        fontFamily = FontFamily(Font(R.font.nunito_bold)),
                        style = MaterialTheme.typography.h4

                    )



                    Text(
                        text = body,
                        fontFamily = FontFamily(Font(R.font.nunito_regular)),
                        fontSize = 18.sp,
                        modifier = Modifier.fillMaxWidth(.85f)
                    )
                    Text(
                        text = "$startTime - $endTime",
                        fontFamily = FontFamily(Font(R.font.nunito_bold)),
                        fontSize = 16.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                val iterator = taskList.iterator()
                while (iterator.hasNext()) {
                    val task = iterator.next()
                    if (task.title == title) {
                        iterator.remove()
                        break // Exit loop once item is removed
                    }
                }
                navigateToFirstScreen() // Navigate after task removal
            }) {
                Icon(imageVector = Icons.Filled.DeleteForever, contentDescription = "")
            }
        }
    }

}