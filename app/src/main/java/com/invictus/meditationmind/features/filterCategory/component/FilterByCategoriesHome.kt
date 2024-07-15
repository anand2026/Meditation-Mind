package com.invictus.meditationmind.features.filterCategory.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import com.invictus.meditationmind.R
import com.invictus.meditationmind.features.homePage.component.ButtonWithIcon
import com.invictus.meditationmind.features.homePage.component.ButtonWithImage
import com.invictus.meditationmind.features.onBoardingFlow.component.ButtonMainFullSize
import com.invictus.meditationmind.utils.composeUtils.theme.FF0D473D
import com.invictus.meditationmind.utils.composeUtils.theme.FF219653
import com.invictus.meditationmind.utils.composeUtils.theme.FFC2D2CF
import com.invictus.meditationmind.utils.composeUtils.theme.appBackgroundColor
import com.invictus.meditationmind.utils.composeUtils.theme.typo12Bold
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP
import splitties.resources.appStr

@Composable
fun FilterByCategoriesHome() {

    val categoryList = remember {
        mutableListOf(
            Pair(R.drawable.relieved,"Stress Relief"),
            Pair(R.drawable.relieved,"Stress Relief"),
            Pair(R.drawable.relieved,"Stress Relief"),
            Pair(R.drawable.relieved,"Stress Relief"),
            Pair(R.drawable.relieved,"Stress Relief"),
            Pair(R.drawable.relieved,"Stress Relief"),
            Pair(R.drawable.relieved,"Stress Relief"),
            Pair(R.drawable.relieved,"Stress Relief"),
            Pair(R.drawable.relieved,"Stress Relief"),
            Pair(R.drawable.relieved,"Stress Relief"),
            Pair(R.drawable.relieved,"Stress Relief"),
            Pair(R.drawable.relieved,"Stress Relief"),
        )
    }

    Surface(
        color = MaterialTheme.colors.appBackgroundColor,
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            backgroundColor = Color.Transparent,
            topBar = {},
            bottomBar = {
                        ButtonMainFullSize(text = stringResource(R.string.view_all)) {
                            
                        }
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(20.DP, 0.DP),
        ) { pad ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(pad)
            ) {
                Spacer(Modifier.height(35.DP))

                CommonSecondaryBgComp(
                    verticalPadding = 0.DP
                ){

                    Box(
                        modifier = Modifier.align(Alignment.TopEnd)
                    ) {
                        ButtonWithIcon(
                            color = FF0D473D,
                            icon = R.drawable.category
                        ) {

                        }
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Spacer(Modifier.height(32.DP))

                        TitleDualColor(textPair = Pair(appStr(R.string.filter_by), "\n${appStr(R.string.categories)}"))

                        Spacer(Modifier.height(38.DP))

                        LazyVerticalGrid(
                            columns = GridCells.Fixed(3),
                            horizontalArrangement = Arrangement.spacedBy(42.DP),
                            verticalArrangement = Arrangement.spacedBy(31.DP)
                        ){

                            categoryList.forEach {
                                item{
                                    FilterByCategoryItem(it){}
                                }
                            }

                        }

                    }
                }
            }
        }
    }
}

@Composable
fun FilterByCategoryItem(pair: Pair<Int, String>, callback: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ButtonWithImage(
            icon = pair.first,
            color = FF219653,
            imageSize = 40.DP,
            boxPadding = 10.DP,
            callback = callback
        )

        Spacer(Modifier.height(14.DP))

        Text(
            text = pair.second,
            style = MaterialTheme.typography.typo12Bold,
            color = FFC2D2CF
        )

    }
}