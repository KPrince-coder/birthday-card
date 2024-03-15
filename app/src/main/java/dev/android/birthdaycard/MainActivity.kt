package dev.android.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.android.birthdaycard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingCard(
                        message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(R.string.from),
                        to = stringResource(R.string.to),
                        // modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingImage() {
    val image = painterResource(R.drawable.birthday_cake)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        alpha = 0.6F
    )
}

@Composable
fun GreetingText(message: String, from: String, to: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "$message $to!",
            fontSize = 80.sp,
            fontWeight = FontWeight.W500,
            lineHeight = 108.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = from, fontSize = 36.sp,
            fontWeight = FontWeight.W400,
            lineHeight = 100.sp,
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingCard(message: String, from: String, to: String, modifier: Modifier = Modifier) {
    Box(modifier) {
        GreetingImage()
        GreetingText(
            message = message,
            from = from,
            to = to,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        )
    }
}

@Preview(name = "birthday card", showBackground = true)
@Composable
fun GreetingCardPreview() {
    BirthdayCardTheme {
        val text = "Happy Birthday"
        GreetingCard(message = text, from = "~ From Prince", to = "Macayla")

    }
}