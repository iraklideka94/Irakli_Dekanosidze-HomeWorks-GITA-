package com.example.gita_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gita_1.ui.theme.GITA1Theme
import net.engawapg.lib.zoomable.rememberZoomState
import net.engawapg.lib.zoomable.zoomable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GITA1Theme {
                ZoomablePic()
            }
        }
    }
}


@Composable
fun ZoomablePic() {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Text(
            "Task-4", fontSize = 45.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 50.dp)
        )

        Text(
            "Zoomable is an android library working with Jetpack Compose. " +
                    "It enables the content zoomable by pinch gesture, by double-tap, or by double-tap and drag gesture.\n" +
                    "\n" +
                    "\t", fontSize = 15.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 10.dp, start = 10.dp)
        )

        val painter = painterResource(id = R.drawable.snacks)
        val zoomState = rememberZoomState(contentSize = painter.intrinsicSize)
        Image(
            painter = painter,
            contentDescription = "Zoomable image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp)
                .zoomable(zoomState),
        )
    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserProfileUIPreview() {
    GITA1Theme {
        ZoomablePic()
    }
}
