package com.android.abhaynoteapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.abhaynoteapp.model.Notes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    modifier: Modifier
) {

    val notesViewModel = viewModel<NotesViewModel>()
    val uiState = notesViewModel.notes.collectAsState()


    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    ) {

        item {
            AppTextField(
                modifier = Modifier,
                value = uiState.value.title,
                onValueChange = {
                    notesViewModel.updateTitle(it)
                },
                maxLines = 1,
                imeAction = ImeAction.Next,
                label = {
                    Text(text = "Title")
                }
            )
        }

        item {
            AppTextField(
                modifier = Modifier,
                value = uiState.value.description,
                onValueChange = {
                    notesViewModel.updateDescription(it)
                },
                maxLines = 5,
                label = {
                    Text(text = "Note Description")
                },
                imeAction = ImeAction.Done
            )
        }

        item {
            NotesButton(onClickBtn = {
                if (uiState.value.title.isNotEmpty() && uiState.value.description.isNotEmpty()) {
                    notesViewModel.addNote()
                }
            }
            )
        }

        items(uiState.value.notes.size) { index ->
            ShowNotes(uiState.value.notes[index], notesViewModel)
        }

    }
}

@Composable
fun ShowNotes(notes: Notes, notesViewModel: NotesViewModel) {

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        onClick = {
            // when click remove the item from the list
            notesViewModel.removeNote(notes)
        }

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = notes.title
            )

            Spacer(
                modifier = Modifier.size(10.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = notes.description
                )

                Text(
                    text = "12:30 PM",
                    fontSize = 10.sp
                )
            }
        }
    }
}

@Composable
private fun NotesButton(
    onClickBtn: () -> Unit = {}
) {
    ElevatedButton(
        onClick = onClickBtn,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Submit",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black,
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(Modifier.fillMaxSize())
}

