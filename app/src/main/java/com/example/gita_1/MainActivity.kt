package com.example.gita_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gita_1.ui.theme.GITA1Theme
import com.example.gita_1.ui.theme.backColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GITA1Theme {
                UserProfileUI()
            }
        }
    }
}


@Composable
fun UserProfileUI() {


    Background()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        UserProfile()
    }

    Column(
        modifier = Modifier
            .padding(top = 260.dp)
    ) {

        StatsRow()

        ContactInfo()

        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp),
            colors = ButtonDefaults.textButtonColors(
               containerColor = backColor
            )
        ) {
            Text(text = "Follow Me",
                fontSize = 20.sp, fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

    }


}


@Composable
fun StatsRow(

) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White)
            .clip(shape = RoundedCornerShape(10.dp))
            .border(1.dp, Color.Gray)
    ) {

        items(statsItems) { item ->
            StatItemUi(item)
        }
    }

}


@Composable
fun StatItemUi(item: StatsItem) {
    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = item.title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Gray
            )

            Spacer(Modifier.height(5.dp))
            Text(
                text = item.number,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = backColor
            )
        }
    }

}


@Composable
fun UserProfile() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            painter = painterResource(id = R.drawable.neymar),
            contentDescription = "Profile",
            modifier = Modifier
                .size(120.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(50.dp)),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "Neymar Jr",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(10.dp)
        )
    }

}

@Composable
fun ContactInfo() {
    Column(
        modifier = Modifier
            .width(360.dp)
            .padding(horizontal = 35.dp, vertical = 35.dp)
    ) {

        InfoRow(iconRes = R.drawable.baseline_email_24, text = "neymarjr@gmail.com")
        Spacer(modifier = Modifier.height(25.dp))
        InfoRow(iconRes = R.drawable.baseline_phone_24, text = "+266 225 225")
        Spacer(modifier = Modifier.height(25.dp))
        InfoRow(iconRes = R.drawable.baseline_group_24, text = "Add to group")
        Spacer(modifier = Modifier.height(25.dp))
        InfoRow(iconRes = R.drawable.baseline_comment_24, text = "Show all comments")

    }

}


@Composable
fun InfoRow(iconRes: Int, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically)
    {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = "Icon",
            modifier = Modifier.size(36.dp),
            colorFilter = ColorFilter.tint(
                backColor
            )
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = text, fontWeight = FontWeight.Bold)
    }

}


@Composable
fun Background() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f)
                .background(backColor)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f)
                .background(Color.White)
        )
    }


}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserProfileUIPreview() {
    GITA1Theme {
        UserProfileUI()
    }
}
