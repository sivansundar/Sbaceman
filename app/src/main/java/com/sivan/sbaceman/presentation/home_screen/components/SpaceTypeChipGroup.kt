package com.sivan.sbaceman.presentation.home_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sivan.sbaceman.Constants

@Preview(showBackground = true)
@Composable
fun SpaceTypeChipGroup(
    type: List<String> = listOf(Constants.LIVE, Constants.SCHEDULED),
    selectedType: String? = null,
    onSelectedChanged: (String) -> Unit = {},
) {
    Column(modifier = Modifier.padding(8.dp)) {
        LazyRow(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            itemsIndexed(type) { index, item ->
                SpaceChip(
                    name = item,
                    isSelected = selectedType == item,
                    onSelectionChanged = {
                        onSelectedChanged(it)
                    },
                    chipColor = if (item == Constants.LIVE) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.secondaryContainer
                )
            }
        }
    }
}

@Composable
@Preview()
fun SpaceTypeDropDownPreview() {
    SpaceTypeChipGroup()
}

@Preview(showBackground = true)
@Composable
fun SpaceChip(
    name: String = "Chip",
    isSelected: Boolean = false,
    onSelectionChanged: (String) -> Unit = {},
    chipColor: Color = MaterialTheme.colorScheme.primary,
) {
    Surface(
        modifier = Modifier.padding(4.dp),
        shape = CircleShape,
        color = chipColor,
        border = if (isSelected) BorderStroke(
            width = 2.dp,
            color = MaterialTheme.colorScheme.primary,
        ) else null
    ) {
        Row(
            modifier = Modifier
                .toggleable(
                    value = isSelected,
                    onValueChange = {
                        onSelectionChanged(name)
                    }
                )
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                modifier = Modifier
                    .width(100.dp)
                    .padding(8.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}
