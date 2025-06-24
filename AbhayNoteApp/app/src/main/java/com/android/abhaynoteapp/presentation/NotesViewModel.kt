package com.android.abhaynoteapp.presentation

import androidx.lifecycle.ViewModel
import com.android.abhaynoteapp.model.Notes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class NotesUiState(
    val notes: List<Notes> = emptyList(),
    val title: String = "",
    val description: String = "",
    val time: String = ""
)

class NotesViewModel: ViewModel() {

    private val _notes = MutableStateFlow(NotesUiState())
    val notes: StateFlow<NotesUiState> = _notes.asStateFlow()

    fun updateTitle(title: String) {
        _notes.value = _notes.value.copy(
            title = title
        )
    }

    fun updateDescription(description: String) {
        _notes.value = _notes.value.copy(
            description = description
        )
    }


    fun addNote() {
        _notes.value = _notes.value.copy(
            notes = _notes.value.notes + Notes(title = _notes.value.title, description = _notes.value.description, time =  LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("HH:mm")))
        )

        _notes.value = _notes.value.copy(
            title = "",
            description = ""
        )
    }

    fun removeNote(note: Notes) {
        _notes.value = _notes.value.copy(
            notes = _notes.value.notes - note
        )
    }
}