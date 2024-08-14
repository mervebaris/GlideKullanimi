package com.example.glidekullanimi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.glidekullanimi.ui.theme.GlideKullanimiTheme
import com.skydoves.landscapist.glide.GlideImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlideKullanimiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    // Resim adını tutan state, başlangıçta "makarna.png" olarak ayarlanmış
    val pictureName = remember { mutableStateOf("makarna.png") }

    // Scaffold, bir üst app bar ve içerik alanı ile temel bir düzen yapısı sağlar
    Scaffold(
        topBar = {
            // Başlığı "Home" olan TopAppBar
            TopAppBar(title = { Text(text = "Home") })
        }
    ) { paddingValues ->
        // Öğeleri dikey olarak yerleştiren, eşit aralıklı ve yatayda ortalanmış bir Column
        Column(
            modifier = Modifier
                .fillMaxSize() // Kullanılabilir alanı doldur
                .padding(paddingValues), // Scaffold'dan gelen padding değerlerini uygula
            verticalArrangement = Arrangement.SpaceEvenly, // Öğeleri Column içinde eşit aralıklarla yerleştir
            horizontalAlignment = Alignment.CenterHorizontally // Öğeleri yatayda ortala
        ) {
            // pictureName state kullanılarak resim URL'sini oluştur
            val url = "http://kasimadalan.pe.hu/yemekler/resimler/${pictureName.value}"

            // GlideImage ile resmi 200x200 dp boyutlarında göster
            GlideImage(imageModel = url, modifier = Modifier.size(200.dp, 200.dp))

            // Tıklandığında resmi değiştiren Button
            Button(onClick = {
                pictureName.value = "baklava.png" // pictureName state'ini güncelle
            }) {
                // Butonun içindeki metin
                Text(text = "Show Picture")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GlideKullanimiTheme {
        Home()
    }
}