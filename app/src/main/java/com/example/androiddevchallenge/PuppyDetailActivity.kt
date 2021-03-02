package com.example.androiddevchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.typography

class PuppyDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogItem(
                Dog(
                    intent.getStringExtra("name").toString(),
                    intent.getIntExtra("pic", 0),
                    intent.getIntExtra("age", 0)
                )
            )
        }

    }

    @Composable
    fun DogItem(dog: Dog) {
        Card(elevation = 10.dp, modifier = Modifier.clip(shape = RoundedCornerShape(10.dp))) {
            Surface(color = MaterialTheme.colors.background) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = dog.pictureId),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Crop,
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(text = dog.name,
                        style = typography.h3,
                        modifier = Modifier.padding(16.dp))
                    Text(text = "${dog.age} Weeks old",
                        style = typography.body1,
                        modifier =  Modifier.padding(16.dp))
                    Text(text = "${dog.name} is an active boy, so he needs lots of exercise. " +
                            "${dog.name} needs high fences. He also needs a family with someone home during the day. " +
                            "${dog.name} needs your help.",
                        Modifier.padding(16.dp))
                }
            }
        }
    }
}