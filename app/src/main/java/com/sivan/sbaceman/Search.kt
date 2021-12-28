package com.sivan.sbaceman

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun SearchContainer() {
    Box(modifier = Modifier.fillMaxWidth()) {

        var textState by remember { mutableStateOf("") }
        var showResult by remember { mutableStateOf(false) }

        SearchBox(onTextChanged = {
            textState = it
        }, textValue = textState, onShowResult = showResult)

        Button(modifier = Modifier.align(Alignment.BottomCenter), onClick = {
            Log.d("TAG", "onTextChanged! -> $textState ")
            if (textState.isNotEmpty()) {
                showResult = true
            }
        }) {
            Text(text = "Search!")
        }
    }
}

@Composable
private fun SearchBox(textValue: String, onTextChanged: (String) -> Unit, onShowResult : Boolean) {

    var showResult by remember {
        mutableStateOf(onShowResult)
    }

    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        val maxLength = 110
        val lightBlue = Color(0xffd8e6ff)
        val blue = Color(0xff76a9ff)

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = textValue,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = lightBlue,
                cursorColor = Color.Black,
                disabledLabelColor = lightBlue,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = {
                if (it.length <= maxLength) {
                    onTextChanged(it)
                }
            },
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            trailingIcon = {
                if (textValue.isNotEmpty()) {
                    IconButton(onClick = { onTextChanged("") }) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = null
                        )
                    }
                }
            }
        )
        Text(
            text = "${textValue.length} / $maxLength",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            textAlign = TextAlign.End,
            color = blue
        )
    }
}
