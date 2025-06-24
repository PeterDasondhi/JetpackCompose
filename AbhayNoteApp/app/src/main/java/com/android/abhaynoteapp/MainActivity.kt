package com.android.abhaynoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.abhaynoteapp.presentation.NoteScreen
import com.android.abhaynoteapp.ui.theme.AbhayNoteAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AbhayNoteAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp),
                            title = {
                                Text(
                                    "Notes",
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .fillMaxHeight().padding(6.dp),
                                    textAlign = TextAlign.Start
                                )
                            },
                        )
                    }) { innerPadding ->
                    NoteScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}