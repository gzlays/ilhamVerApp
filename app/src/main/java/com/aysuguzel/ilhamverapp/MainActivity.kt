package com.aysuguzel.ilhamverapp

import android.annotation.SuppressLint
import android.graphics.Paint.Align
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aysuguzel.ilhamverapp.ui.theme.IlhamVerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IlhamVerAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Sayfa()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sayfa() {


    var isExpanded by remember { mutableStateOf(false) }

    val surfaceColor by animateColorAsState(if (isExpanded) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.surface,
    )


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "İlham Ver",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center

                        ) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                   // containerColor = Color.LightGray,
                    containerColor = colorResource(id = R.color.gunduz),
                    titleContentColor = colorResource(id = R.color.gece)

                    )
            )
        },
        content = {
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    Image(painter = painterResource(id = R.drawable.steve) ,
                        contentDescription ="" ,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(120.dp))
                    Text(text = "steve Jobs",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                }
                Text(text = " Hayattaki en çok değer verdiğim şeyi parayla satın alamazsınız." +
                        "Hayatta sahip olduğumuz en önemli kaynak açıkça zamandır",
                        modifier = Modifier.fillMaxWidth().clickable { isExpanded=!isExpanded },
                          maxLines=if(isExpanded) Int.MAX_VALUE else 1,
                          textAlign = TextAlign.Center
                       )

                Button(onClick = { Log.e("button","ilham verildi") },
                    colors=ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.gunduz),
                        contentColor = colorResource(id = R.color.gece)
                    ),
                    modifier = Modifier
                        .size(170.dp,50.dp)
                        ) {
                            Text(text = "İlham Ver")
                }
            }

        }

        //must
       /* floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {

            }
        }*/


    )






      //must
       /* LazyColumn(
            contentPadding = it
        ) {
            items(3) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = ""
                )
            }
        }*/



    }



@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    IlhamVerAppTheme {
        Sayfa()
    }
}