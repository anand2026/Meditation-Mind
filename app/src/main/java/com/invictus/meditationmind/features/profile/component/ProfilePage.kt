package com.invictus.meditationmind.features.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.invictus.meditationmind.R
import com.invictus.meditationmind.features.filterCategory.component.TitleDualColor
import com.invictus.meditationmind.features.filterCategory.component.TopAppBarWithTwoActionButton
import com.invictus.meditationmind.utils.composeUtils.theme.FF219653
import com.invictus.meditationmind.utils.composeUtils.theme.FFEAEFEE
import com.invictus.meditationmind.utils.composeUtils.theme.appBackgroundColor
import com.invictus.meditationmind.utils.composeUtils.theme.typo16Normal
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP

@Preview(device = "spec:width=1080px,height=1920px,dpi=160")
@Composable
fun ProfilePage() {

    val insightDateRange = remember { Pair("This Week:", "05may- 11 may") }

    Surface(
        color = MaterialTheme.colors.appBackgroundColor,
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            backgroundColor = Color.Transparent,
            topBar = {
                TopAppBarWithTwoActionButton(
                    iconEnd = R.drawable.settings,
                    color = FF219653,
                    textPair = Pair("", "My Profile"),
                    startCallback = { }) {
                }
            },
            bottomBar = {},
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 35.DP)
                .padding(20.DP, 0.DP),
        ) { pad ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(pad),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                item {
                    Spacer(Modifier.height(36.DP))

                    ProfileComp("Ajay Singh", "ajaysingham0@gmail.com")
                }

                item {
                    Spacer(Modifier.height(36.DP))

                    TitleDualColor(textPair = Pair(stringResource(R.string.daily), stringResource(R.string.progress)), TextAlign.Start)
                }

                item {
                    Spacer(Modifier.height(24.DP))

                    LazyHorizontalGrid(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(24.DP),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        rows = GridCells.Fixed(2)
                    ) {
                        item { DailyProgressComp("135h", "Total meditation", R.drawable.category) }
                        item { DailyProgressComp("135h", "Total meditation", R.drawable.category) }
                        item { DailyProgressComp("135h", "Total meditation", R.drawable.category) }
                        item { DailyProgressComp("135h", "Total meditation", R.drawable.category) }
                    }
                }

                item {
                    Spacer(Modifier.height(36.DP))

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            TitleDualColor(textPair = Pair(stringResource(R.string.your), stringResource(R.string.insights)), TextAlign.Start)

                            Spacer(Modifier.height(4.DP))

                            Text(
                                text = buildAnnotatedString {
                                    append(insightDateRange.first)
                                    withStyle(SpanStyle(fontWeight = FontWeight.SemiBold, color = Color.White)) {
                                        append(" ${insightDateRange.second}")
                                    }
                                },
                                style = MaterialTheme.typography.typo16Normal,
                                color = FFEAEFEE,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start
                            )
                        }
                    }
                }

            }
        }
    }
}