package com.invictus.meditationmind.features.onBoardingFlow.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.invictus.meditationmind.R
import com.invictus.meditationmind.features.mainActivityPage.MainActivityPageViewModel
import com.invictus.meditationmind.features.mainActivityPage.data.BottomNavItemsIdentifiers
import com.invictus.meditationmind.utils.composeUtils.theme.FF219653
import com.invictus.meditationmind.utils.composeUtils.theme.appBackgroundColor
import com.invictus.meditationmind.utils.composeUtils.theme.typo24Bold
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP

@Composable
fun OnBoardingQuestion3(mainActivityPageViewModel: MainActivityPageViewModel) {

    Surface(
        color = MaterialTheme.colors.appBackgroundColor,
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            backgroundColor = Color.Transparent,
            topBar = {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(Modifier.height(40.DP))

                    BackButtonOnboarding{
                        mainActivityPageViewModel.setSelectedGlobalNavItem(BottomNavItemsIdentifiers.ONBOARDING_QUESTION2)
                    }

                    Spacer(Modifier.height(30.DP))

                    ProgressBarOnBoarding(3,3)

                }
            },
            bottomBar = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ButtonMainFullSize(stringResource(R.string.continue_tag)){}

                    Spacer(Modifier.height(60.DP))
                }
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.DP)
        ) { pad ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(pad)
            ) {

                Spacer(Modifier.height(40.DP))

                Text(
                    text = stringResource(R.string.mental_health),
                    style = MaterialTheme.typography.typo24Bold,
                    color = FF219653
                )

                Spacer(Modifier.height(24.DP))


                
            }
        }
    }

}