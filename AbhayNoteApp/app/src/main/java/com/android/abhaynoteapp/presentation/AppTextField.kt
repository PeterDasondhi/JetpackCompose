package com.android.abhaynoteapp.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun AppTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    maxLines: Int,
    imeAction: ImeAction,
    label: @Composable (() -> Unit)? = null
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth().padding(16.dp),
        maxLines = maxLines,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = imeAction
        ),
        label = label
    )
}