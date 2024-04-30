package com.example.istanbulgeziyorum

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.istanbulgeziyorum.ui.theme.IstanbulGeziyorumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IstanbulGeziyorumTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnaSayfa()
                }
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "DiscouragedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnaSayfa() {
    val yerListesi= remember {
            mutableStateListOf<Yerler>()
    }
    LaunchedEffect(key1 = true) {
        val y1 = Yerler(1, "Ayasofya Cami", "a1", " 34122 Fatih/İstanbul"
        )
        val y2 = Yerler(2, "Kapalı Çarsı", "a2", "Beyazıt, 34126 Fatih")
        val y3 = Yerler(3, "Rumeli Hisarı", "a3", "Yahya Kemal Cd., 34470 Sarıyer")
        val y4=Yerler(4,"Rahmi Koç Müzesi","a4"," Piri Paşa, Hasköy Cd 34445 Beyoğlu")
        val y5=Yerler(5,"Beylerbeyi Sarayı","a5"," Abdullahağa Cd., 34676 Üsküdar")
        val y6=Yerler(6,"Yerebatan Sarnacı","a6","Alemdar, Yerebatan Cd. 1/3, 34110 Fatih")
        val y7=Yerler(7,"Mısır Çarsısı","a7","Rüstem Paşa, 34116 Fatih")
        val y8=Yerler(8,"Arkeoloji müzesi","a8","Cankurtaran, 34122 Fatih")
        val y9=Yerler(9,"Galata Kulesi","a9","Bereketzade, 34421 Beyoğlu")
        yerListesi.add(y1)
        yerListesi.add(y2)
        yerListesi.add(y3)
        yerListesi.add(y4)
        yerListesi.add(y5)
        yerListesi.add(y6)
        yerListesi.add(y7)
        yerListesi.add(y8)
        yerListesi.add(y9)
    }
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Yerler") }, colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0, 123, 167)))
    }) {
        LazyColumn (modifier = Modifier.padding(top = 50.dp)){
            items(count = yerListesi.count(),
                itemContent = {
                    val yer=yerListesi[it]
                    Card(modifier = Modifier
                        .padding(all = 5.dp)
                        .fillMaxWidth()){
                        Row(modifier = Modifier.clickable {  }){
                            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                                .padding(all = 10.dp)
                                .fillMaxWidth()){
                                val activity= (LocalContext.current as Activity)
                                Image(bitmap = ImageBitmap.imageResource(id=activity.resources.getIdentifier(yer.resim_ad,"drawable",activity.packageName)),
                                    contentDescription = "",
                                    modifier =Modifier.size(100.dp) )
                                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().padding(all = 10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                                    Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxHeight().clipToBounds()) {
                                        Text(text = yer.yer_ad, fontSize = 20.sp)
                                        Icon(painter = painterResource(id = R.drawable.konum) , contentDescription =null )
                                        Text(text = yer.yer_konum, fontSize = 12.sp, color = Color.Blue)


                                    }
                                    Icon(painter = painterResource(id = R.drawable.arrowresim) , contentDescription =null )

                                }
                            }
                        }
                    }

                })
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IstanbulGeziyorumTheme {
        AnaSayfa()
    }
}