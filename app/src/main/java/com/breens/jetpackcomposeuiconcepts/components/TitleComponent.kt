package com.breens.jetpackcomposeuiconcepts.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.breens.jetpackcomposeuiconcepts.R
import com.breens.jetpackcomposeuiconcepts.ui.theme.LightGray

@Preview
@Composable
fun TitleComponent() {

    Column(modifier=Modifier
        .fillMaxWidth()
        .padding(10.dp)) {
        Text(text = "Hi David!",
            fontFamily = FontFamily(Font(R.font.nunito_extrabold)),
            fontSize = 22.sp
        )



        Text(text = "8 tasks for today Monday",
            modifier = Modifier.offset(x = 14.dp),
            fontFamily = FontFamily(Font(R.font.nunito_regular)),
            fontSize = 18.sp,
            color = LightGray
        )
    }
}