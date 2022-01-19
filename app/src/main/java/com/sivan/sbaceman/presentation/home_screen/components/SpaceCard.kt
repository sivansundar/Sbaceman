package com.sivan.sbaceman.presentation.home_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun SpaceCard(
    modifier: Modifier,
    onSpaceClicked: (String) -> Unit
) {

    val spaceType by remember {
        mutableStateOf("Scheduled")
    }
    Card(
        modifier = modifier,
        backgroundColor = MaterialTheme.colorScheme.tertiaryContainer,
        border = BorderStroke(4.dp, color = MaterialTheme.colorScheme.tertiary),
        elevation = 4.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()

        ) {

            val (title, participant_count, hosted_by, timings, footer) = createRefs()
            Text(
                text = "NFT Drop 2022",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                ),
                modifier = Modifier
                    .constrainAs(title) {

                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            ParticipantCount(
                modifier = Modifier.constrainAs(participant_count) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )

            HostedByContainer(
                modifier = Modifier
                    .constrainAs(hosted_by) {
                        top.linkTo(participant_count.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        if (spaceType == "Scheduled") {
                            bottom.linkTo(timings.top)
                        } else {
                            bottom.linkTo(footer.top)
                        }
                    }
                    .wrapContentWidth()
            )

            if (spaceType == "Scheduled") {
                SpaceTimings(
                    modifier = Modifier
                        .wrapContentSize()
                        .constrainAs(timings) {
                            bottom.linkTo(footer.top)
                            absoluteLeft.linkTo(parent.absoluteLeft)
                            absoluteRight.linkTo(parent.absoluteRight)
                        }
                        .padding(horizontal = 20.dp, vertical = 8.dp),
                    time = "08:00 PM, Jan 04th 2022"
                )
            }

            Footer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .constrainAs(footer) {
                        bottom.linkTo(parent.bottom)
                    },
                spaceType = "Live",
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
            text = "TAKE ME TO SPACE \uD83D\uDE80",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.surface
            ),
            textAlign = TextAlign.Center
        )
    }
}
