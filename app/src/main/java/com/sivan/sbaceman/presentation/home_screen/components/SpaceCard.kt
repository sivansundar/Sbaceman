package com.sivan.sbaceman.presentation.home_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sivan.sbaceman.Constants
import com.sivan.sbaceman.data.remote.dto.SpaceData

@Composable
fun SpaceCard(
    modifier: Modifier,
    onSpaceClicked: (String) -> Unit,
    spaceItem: SpaceData,
    backgroundColor: Color
) {

    val spaceType by remember {
        mutableStateOf(spaceItem.state)
    }
    Card(
        modifier = modifier,
        backgroundColor = backgroundColor,
        border = BorderStroke(4.dp, color = MaterialTheme.colorScheme.tertiary),
        elevation = 4.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = spaceItem.title.toString(),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )

            ParticipantCount(
                modifier = Modifier.fillMaxWidth(),
            )

            HostedByContainer(
                modifier = Modifier
                    .fillMaxWidth(),
                users = spaceItem.users

            )

            if (spaceType == "scheduled") {
                SpaceTimings(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(horizontal = 20.dp, vertical = 8.dp),
                    time = spaceItem.scheduled_start
                )
            }

            Footer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                spaceType = spaceType,
                onSpaceItemClicked = {
                    onSpaceClicked(it)
                }
            )
        }
    }
}

@Composable
fun Footer(
    modifier: Modifier,
    spaceType: String,
    onSpaceItemClicked: (String) -> Unit
) {
    Button(modifier = modifier, onClick = {
        onSpaceItemClicked(spaceType)
    }) {
        Text(
            text = if (spaceType.equals(Constants.LIVE, ignoreCase = true)) "TAKE ME TO SPACE \uD83D\uDE80" else "REMIND ME",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.surface
            ),
            textAlign = TextAlign.Center
        )
    }
}
