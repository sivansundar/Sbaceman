package com.sivan.sbaceman.presentation.home_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun SearchBar(
    modifier: Modifier,
    hint: String
) {
    var searchText by rememberSaveable { mutableStateOf("") }

    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    ConstraintLayout(
        modifier = modifier
    ) {

        val (textField, filterIcon) = createRefs()

        OutlinedTextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .constrainAs(textField) {
                    top.linkTo(parent.top)
                    absoluteRight.linkTo(parent.absoluteRight)
                    absoluteLeft.linkTo(parent.absoluteLeft)
                }
                .fillMaxWidth()
                .onFocusChanged {
                    isHintDisplayed = !it.hasFocus
                },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = MaterialTheme.colorScheme.onSurface
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search icon"
                )
            },
            trailingIcon = {
                if (searchText.isNotEmpty()) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "Close",
                        modifier = Modifier.clickable { isHintDisplayed = false }
                    )
                }
            },
            label = {
                Text(
                    text = hint,
                    color = if (!isHintDisplayed) androidx.compose.material.MaterialTheme.colors.primary.copy(
                        alpha = ContentAlpha.high
                    ) else MaterialTheme.colorScheme.onSurface,
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search,
                autoCorrect = true
            ),
            shape = CircleShape
        )
    }
}

@Composable
fun SpaceTypeChip(title: String) {
    Surface(
        modifier = Modifier
            .wrapContentWidth()
            .clip(shape = CircleShape),
        color = MaterialTheme.colorScheme.tertiaryContainer,
        onClick = {}
    ) {
        Box(modifier = Modifier.wrapContentSize().padding(15.dp)) {
            Text(
                text = title,
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold)
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun SearchBarPreview() {
    SearchBar(
        modifier = Modifier.padding(bottom = 18.dp),
        hint = "Search for a space"
    )
}
