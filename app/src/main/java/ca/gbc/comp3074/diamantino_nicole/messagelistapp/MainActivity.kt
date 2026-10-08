package ca.gbc.comp3074.diamantino_nicole.messagelistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ca.gbc.comp3074.diamantino_nicole.messagelistapp.ui.theme.MessageListAppTheme
import androidx.compose.foundation.background

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MessageListAppTheme {
                MessageList()
            }
        }
    }
}

@Composable
fun MessageList() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8FF))
            .padding(16.dp)
    ) {
        MessageItem("Joe", "Hi!")
        MessageItem("Jim", "How are you?")
        MessageItem("Joe", "Test..1..2...3")
    }
}

@Composable
fun MessageItem(name: String, message: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_launcher_foreground
            ),
            contentDescription = "Profile picture",
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .border(
                    width = 3.dp,
                    color = Color.Red,
                    shape = CircleShape
                )
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                shape = RoundedCornerShape(20.dp),
                color = Color(0xFFF8F3FA),
                shadowElevation = 2.dp
            ) {
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(
                        horizontal = 12.dp,
                        vertical = 8.dp
                    )
                )
            }
        }
    }
}