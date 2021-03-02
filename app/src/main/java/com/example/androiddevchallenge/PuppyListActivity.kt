package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.typography

class PuppyListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp(dogs = DogRepository.getDogList(), this)
        }
    }
}


// Start building your app here!
@Composable
fun MyApp(dogs: List<Dog>, context: Context) {
    Column {
        LazyColumn(
            modifier = Modifier.clip(shape = RoundedCornerShape(10.dp)),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(dogs) { dog ->
                DogItem(dog = dog, context)

            }
        }
    }
}

@Composable
fun DogItem(dog: Dog, context: Context) {
    Card(elevation = 10.dp, modifier = Modifier.clip(shape = RoundedCornerShape(10.dp))) {
        Surface(color = MaterialTheme.colors.background) {
            Row(
                modifier = Modifier
                    .fillMaxSize().clickable(onClick = {
                        val intent = Intent(context, PuppyDetailActivity::class.java)
                        intent.putExtra("name", dog.name).toString()
                        intent.putExtra("pic", dog.pictureId)
                        intent.putExtra("age", dog.age)
                        context.startActivity(intent)
                    }),
                verticalAlignment = Alignment.Top
            ) {
                Image(
                    painter = painterResource(id = dog.pictureId),
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                )
                Spacer(modifier = Modifier.size(10.dp))
                Column {
                    Text(text = dog.name, style = typography.h3)
                    Text(text = "${dog.age} Weeks old", style = typography.body1)
                }
            }
        }
    }
}