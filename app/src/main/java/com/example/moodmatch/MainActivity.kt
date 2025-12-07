package com.example.moodmatch

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moodmatch.ui.theme.MoodTemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoodTemplateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MoodHomeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MoodHomeScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "MOODMATCH",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Select your mood to get movie recommendations:",
            style = MaterialTheme.typography.bodyMedium
        )

        // Mood buttons now correctly pass EXTRA_MOOD
        Button(onClick = {
            context.startActivity(
                Intent(context, MovieListActivity::class.java).apply {
                    putExtra(MovieListActivity.EXTRA_MOOD, "happy")
                }
            )
        }) { Text("😊 Happy") }

        Button(onClick = {
            context.startActivity(
                Intent(context, MovieListActivity::class.java).apply {
                    putExtra(MovieListActivity.EXTRA_MOOD, "chill")
                }
            )
        }) { Text("😌 Chill") }

        Button(onClick = {
            context.startActivity(
                Intent(context, MovieListActivity::class.java).apply {
                    putExtra(MovieListActivity.EXTRA_MOOD, "sad")
                }
            )
        }) { Text("😢 Sad") }

        Button(onClick = {
            context.startActivity(
                Intent(context, MovieListActivity::class.java).apply {
                    putExtra(MovieListActivity.EXTRA_MOOD, "excited")
                }
            )
        }) { Text("🤩 Excited") }
    }
}

@Preview(showBackground = true)
@Composable
fun MoodHomePreview() {
    MoodTemplateTheme {
        MoodHomeScreen()
    }
}
