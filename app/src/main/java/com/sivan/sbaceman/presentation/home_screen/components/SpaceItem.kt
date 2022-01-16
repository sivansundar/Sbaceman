package com.sivan.sbaceman.presentation.home_screen.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.sivan.sbaceman.presentation.home_screen.Footer
import com.sivan.sbaceman.ui.theme.SbacemanTheme

@Composable
fun SpaceItem(
    modifier: Modifier,
    onSpaceClicked: (String) -> Unit,
    spaceStatus: String
) {
    Card(
        modifier = modifier.clickable {
            onSpaceClicked("Space name")
        },
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (title, participants, spaceType, hostedBy, timings, footer) = createRefs()

            Text(
                text = "filmmaking NFTs + chill ad asd asd as",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(title) {
                        top.linkTo(spaceType.bottom)
                        start.linkTo(parent.absoluteLeft)
                        absoluteRight.linkTo(parent.absoluteRight)
                    }
                    .padding(top = 10.dp, bottom = 20.dp, start = 20.dp, end = 20.dp)
            )

            SpaceTypeChip(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topEnd = 20.dp))
                    .constrainAs(spaceType) {
                        absoluteRight.linkTo(parent.absoluteRight)
                    },
                type = spaceStatus
            )

            SpaceTimings(
                modifier = Modifier
                    .wrapContentSize()
                    .constrainAs(timings) {
                        bottom.linkTo(hostedBy.top)
                        absoluteLeft.linkTo(parent.absoluteLeft)
                    }
                    .padding(horizontal = 20.dp, vertical = 8.dp),
                time = "08:00 PM, Jan 04th 2022"
            )

            HostedBy(
                modifier = Modifier
                    .wrapContentSize()
                    .constrainAs(hostedBy) {
                        bottom.linkTo(footer.top)
                        absoluteLeft.linkTo(parent.absoluteLeft)
                    }
                    .padding(start = 20.dp, bottom = 12.dp),
                hostedBy = "Sivan"
            )

            ParticipantCount(
                modifier = Modifier
                    .constrainAs(participants) {
                        bottom.linkTo(footer.top)
                        absoluteRight.linkTo(parent.absoluteRight)
                    }
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            )

            Footer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clickable {
                        // If type is Live -> Take me to space
                        // If scheduled -> set reminder
                    }
                    .constrainAs(footer) {
                        bottom.linkTo(parent.bottom)
                    }
                    .background(color = MaterialTheme.colorScheme.onSurfaceVariant)
            )
        }
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun SpaceItemPreview() {
    SbacemanTheme(isDark = true) {
        SpaceItem(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(topEnd = 20.dp)),
            onSpaceClicked = {
            },
            spaceStatus = "Live"
        )
    }
}