package com.invictus.meditationmind.features.homePage.component

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.invictus.meditationmind.R
import com.invictus.meditationmind.features.listening.utils.ListeningUtils
import com.invictus.meditationmind.features.mainActivityPage.Routes
import com.invictus.meditationmind.utils.composeUtils.theme.FF13574C
import com.invictus.meditationmind.utils.composeUtils.theme.FF219653
import com.invictus.meditationmind.utils.composeUtils.theme.FFA7BDB9
import com.invictus.meditationmind.utils.composeUtils.theme.FFC2D2CF
import com.invictus.meditationmind.utils.composeUtils.theme.appBackgroundColor
import com.invictus.meditationmind.utils.composeUtils.theme.typo12Bold
import com.invictus.meditationmind.utils.composeUtils.theme.typo22Normal
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP
import splitties.resources.appStr

@Composable
fun HomePage(navController: NavHostController) {

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = MaterialTheme.colors.appBackgroundColor
    )

    val context = LocalContext.current
    BackHandler {
        (context as Activity).finish()
    }

    val selectedFeelings = remember { mutableStateListOf<Int>() }

    val feelingsList = remember{ mutableListOf(Pair(
        appStr(R.string.stress_relief),R.drawable.stress_relief),
        Pair(appStr(R.string.sleeping),R.drawable.sleeping),
        Pair(appStr(R.string.disappointed),R.drawable.disappointed),
        Pair(appStr(R.string.relieved),R.drawable.relieved),
    ) }

    Surface(
        color = MaterialTheme.colors.appBackgroundColor,
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            backgroundColor = Color.Transparent,
            topBar = {
                HomePageTopAppBar(navController)
            },
            bottomBar = {},
            modifier = Modifier
                .fillMaxSize()
                .padding(20.DP, 0.DP),
        ) { pad ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(pad)
                    .padding(0.DP, 0.DP)
            ) {
                item{
                    Spacer(Modifier.height(4.DP))

                    Text(
                        text = stringResource(R.string.how_are_you_feeling_today),
                        style = MaterialTheme.typography.typo22Normal,
                        color = FFC2D2CF
                    )

                    Spacer(Modifier.height(24.DP))
                }

                item{
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        feelingsList.forEachIndexed{index,it->
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {

                                ButtonWithImage(
                                    icon =it.second,
                                    boxPadding = 10.DP,
                                    imageSize = 40.DP,
                                    color = if(selectedFeelings.contains(index)) FF13574C else FF219653
                                ) {
                                    if(selectedFeelings.contains(index)){
                                        selectedFeelings.remove(index)
                                    }else{
                                        selectedFeelings.add(index)
                                    }
                                }

                                Spacer(Modifier.height(14.DP))

                                Text(
                                    text = it.first,
                                    style = MaterialTheme.typography.typo12Bold,
                                    color = FFA7BDB9
                                )

                            }
                        }
                    }
                }

                item{
                    Spacer(Modifier.height(24.DP))

                    TitleWithClickableSecondaryTextButton(stringResource(R.string.latest_update),""/*stringResource(R.string.see_all)*/){
                        navController.navigate(Routes.Listening.createRoute(ListeningUtils.getAudioList().joinToString { it.uniqueId }))
                    }
                }

                item{
                    Spacer(Modifier.height(26.DP))

                    LatestUpdateCard{
                        navController.navigate(Routes.Listening.createRoute(ListeningUtils.getAudioList().joinToString { it.uniqueId }))
                    }
                }

                item{
                    Spacer(Modifier.height(16.DP))

                    MostPopularSection(navController)

                    Spacer(Modifier.height(30.DP))
                }



            }
        }
    }

}

