package com.example.myproject.Presentation.CustomComponents

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.VisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyLoginTextField(
    name: String,
    onChange: (String) -> Unit,
    label: String,
    LeadingIcon: Int? = null,
    TrailingIcon: Int? = null,
    TrailingOnClick: () -> Unit = {},
    visualTransformation: VisualTransformation,
    keyboardOption: KeyboardOptions,
) {
    OutlinedTextField(
        value = name,
        onValueChange = { onChange(it) },
        label = { Text(text = label) },
        singleLine = true,
        leadingIcon = {
            LeadingIcon?.let {
                Icon(
                    imageVector = ImageVector.vectorResource(id = it) ,
                    contentDescription = "")
            }
        },
        trailingIcon = {
            TrailingIcon?.let {
                IconButton(onClick = {
                    TrailingOnClick()
                }) {
                }
                Icon(
                    imageVector = ImageVector.vectorResource(id = it) ,
                    contentDescription = "")
            }
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOption,
    )
}