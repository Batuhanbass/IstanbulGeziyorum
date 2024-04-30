package com.example.istanbulgeziyorum

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetaySayfa(yer:Yerler) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = yer.yer_ad) }, colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0, 123, 167)))
    }) {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
                    val activity=(LocalContext.current as Activity)
                Image(bitmap = ImageBitmap.imageResource(id=activity.resources.getIdentifier(yer.resim_ad,"drawable",activity.packageName)),
                    contentDescription = "",
                    modifier =Modifier.size(300.dp) )
                Text(text = yer.yer_ad, color = Color.Blue, fontSize = 25.sp)
            }

    }

}