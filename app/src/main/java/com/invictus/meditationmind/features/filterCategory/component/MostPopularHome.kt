package com.invictus.meditationmind.features.filterCategory.component

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.invictus.meditationmind.R
import com.invictus.meditationmind.features.homePage.component.MeditationItemComponent
import com.invictus.meditationmind.features.listening.utils.ListeningUtils
import com.invictus.meditationmind.features.mainActivityPage.Routes
import com.invictus.meditationmind.utils.composeUtils.theme.appBackgroundColor
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP

@Composable
fun MostPopularHome(navController: NavHostController) {
//
//    val viewModel : FilterCategoryViewModel = mavericksViewModel()
//    val listOfPlayingItems by viewModel.collectAsState(FilterCategoryState::listOfPlayingItems)

    val listItem = remember { ListeningUtils.getAudioList() }

    Surface(
        color = MaterialTheme.colors.appBackgroundColor,
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            backgroundColor = Color.Transparent,
            topBar = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Spacer(Modifier.height(35.DP))

                    TopAppBarWithTwoActionButton(
                        iconStart = R.drawable.arrow_back,
                        iconEnd = R.drawable.search,
                        textPair = Pair(stringResource(R.string.most), stringResource(R.string.popular)),
                        startCallback = {
                            navController.popBackStack()
                        },
                        endCallback = {}
                    )
                }
            },
            bottomBar = {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//
//                    ButtonMainFullSize(text = stringResource(R.string.load_more)) {
//
//                    }
//
//                    Spacer(Modifier.height(15.DP))
//                }
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(20.DP, 0.DP),
        ) { pad ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(pad)
                ,
                horizontalArrangement = Arrangement.spacedBy(24.DP),
                verticalArrangement = Arrangement.spacedBy(24.DP)
            ) {

                item{
                    Spacer(Modifier.height(40.DP))
                }
                item{
                    Spacer(Modifier.height(40.DP))
                }

                listItem.forEach {
                    item{
                        MeditationItemComponent(text = it.title, image = it.image) {
                            navController.navigate(Routes.Listening.createRoute(it.uniqueId))
                        }
                    }
                }

                item{
                    Spacer(Modifier.height(40.DP))
                }
                item{
                    Spacer(Modifier.height(40.DP))
                }

            }
        }
    }

}