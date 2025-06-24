package com.android.abhaynoteapp.model

import java.util.UUID

data class Notes(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val time: String,
)
