package com.sivan.sbaceman.presentation.home_screen

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sivan.sbaceman.domain.model.SearchOptions
import com.sivan.sbaceman.domain.model.SearchParams
import com.sivan.sbaceman.presentation.MainViewModel
import com.sivan.sbaceman.presentation.ui.theme.SbacemanTheme
import kotlinx.coroutines.launch
import timber.log.Timber


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(modifier: Modifier, viewmodel : MainViewModel) {
    val scope = rememberCoroutineScope()

    Box(modifier = modifier) {
        Column(modifier = Modifier.align(Alignment.TopCenter)) {

            SearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    ),
                hint = "Search for a space",
                onSearchButtonClicked = {

                })

            Spacer(modifier = Modifier.height(24.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                item {
                    SpaceItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .clip(
                                RoundedCornerShape(
                                    topEnd = 20.dp,
                                    bottomEnd = 10.dp,
                                    bottomStart = 10.dp,
                                    topStart = 10.dp
                                )
                            ), onSpaceClicked = {

                        },
                        spaceStatus = "Live"
                    )
                }
                item {
                    SpaceItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .clip(
                                RoundedCornerShape(
                                    topEnd = 20.dp,
                                    bottomEnd = 10.dp,
                                    bottomStart = 10.dp,
                                    topStart = 10.dp
                                )
                            ), onSpaceClicked = {

                        },
                        spaceStatus = "Scheduled"
                    )
                }
            }

        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier,
    hint: String,
    onSearchButtonClicked: (String) -> Unit
) {
    var searchText by rememberSaveable { mutableStateOf("") }

    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }

    Box(modifier = modifier) {
        BasicTextField(
            value = searchText,
            onValueChange = {
                searchText = it

            },
            singleLine = true,
            textStyle = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 16.dp)
                .onFocusChanged {
                    isHintDisplayed = !it.hasFocus
                },
        )

        if (isHintDisplayed && searchText.isEmpty() || searchText.isEmpty()) {
            Text(
                text = hint, modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(horizontal = 20.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
@Preview
fun SearchBarPreview() {
    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        hint = "Search for a space",
        onSearchButtonClicked = {

        })
}

@Composable
fun SpaceTypeChip(
    modifier: Modifier,
    type: String
) {
    Surface(
        modifier = modifier,
        shadowElevation = 8.dp,
        tonalElevation = 8.dp,
        color = if (type == "Live") {
            MaterialTheme.colorScheme.tertiary
        } else MaterialTheme.colorScheme.secondary
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                text = type,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
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
                .clip(RoundedCornerShape(topEnd = 20.dp)), onSpaceClicked = {

            },
            spaceStatus = "Live"
        )
    }

}

@Composable
fun SpaceItem(
    modifier: Modifier,
    onSpaceClicked: (String) -> Unit,
    spaceStatus: String
) {
    Card(modifier = modifier.clickable {
        onSpaceClicked("Space name")
    }, backgroundColor = MaterialTheme.colorScheme.secondaryContainer) {
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
                    .padding(top = 10.dp, bottom = 20.dp, start = 20.dp, end = 20.dp))

            SpaceTypeChip(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topEnd = 20.dp))
                    .constrainAs(spaceType) {
                        absoluteRight.linkTo(parent.absoluteRight)
                    }, type = spaceStatus)

            SpaceTimings(modifier = Modifier
                .wrapContentSize()
                .constrainAs(timings) {
                    bottom.linkTo(hostedBy.top)
                    absoluteLeft.linkTo(parent.absoluteLeft)
                }
                .padding(horizontal = 20.dp, vertical = 8.dp), time = "08:00 PM, Jan 04th 2022")

            HostedBy(modifier = Modifier
                .wrapContentSize()
                .constrainAs(hostedBy) {
                    bottom.linkTo(footer.top)
                    absoluteLeft.linkTo(parent.absoluteLeft)
                }
                .padding(start = 20.dp, bottom = 12.dp), hostedBy = "Sivan")

            ParticipantCount(modifier = Modifier
                .constrainAs(participants) {
                    bottom.linkTo(footer.top)
                    absoluteRight.linkTo(parent.absoluteRight)

                }
                .padding(horizontal = 20.dp, vertical = 12.dp))

            Footer(modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .clickable {
                    // If type is Live -> Take me to space
                    // If scheduled -> set reminder
                }
                .constrainAs(footer) {
                    bottom.linkTo(parent.bottom)
                }
                .background(color = MaterialTheme.colorScheme.onSurfaceVariant))

        }
    }
}

@Composable
fun SpaceTimings(modifier: Modifier, time: String) {
    Row(modifier = modifier) {
        Text(
            text = "Starts at",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = time,
            style = MaterialTheme.typography.labelMedium.copy(
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        )
    }
}

@Composable
fun HostedBy(modifier: Modifier, hostedBy: String) {
    Row(modifier = modifier) {
        Text(
            text = "hosted by",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = hostedBy,
            style = MaterialTheme.typography.labelMedium.copy(
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        )
    }
}

@Composable
fun ParticipantCount(modifier: Modifier) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceEvenly) {
        Icon(imageVector = Icons.Rounded.Person, contentDescription = "Participant count")
        Text(
            text = "50",
            style = MaterialTheme.typography.labelMedium.copy(
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        )

    }
}

@Composable
fun Footer(modifier: Modifier) {
    Box(modifier = modifier) {
        Text(
            text = "REMIND ME",
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.surface
            )
        )
    }
}