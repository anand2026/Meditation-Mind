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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.invictus.meditationmind.R
import com.invictus.meditationmind.features.mainActivityPage.MainActivityPageViewModel
import com.invictus.meditationmind.features.mainActivityPage.data.BottomNavItemsIdentifiers
import com.invictus.meditationmind.utils.composeUtils.theme.FF219653
import com.invictus.meditationmind.utils.composeUtils.theme.FFD8E2E0
import com.invictus.meditationmind.utils.composeUtils.theme.FFFEC265
import com.invictus.meditationmind.utils.composeUtils.theme.appBackgroundColor
import com.invictus.meditationmind.utils.composeUtils.theme.ptSerifTypography
import com.invictus.meditationmind.utils.composeUtils.theme.textColor
import com.invictus.meditationmind.utils.composeUtils.theme.typo22Normal
import com.invictus.meditationmind.utils.composeUtils.theme.typo24Bold
import com.invictus.meditationmind.utils.composeUtils.theme.typo36Bold
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.SP
import splitties.resources.appStr

@Composable
fun OnBoardingQuestion2(mainActivityPageViewModel: MainActivityPageViewModel) {

    val question = remember{ buildAnnotatedString {
        append(appStr(R.string.what_brought_you_here))
        withStyle(SpanStyle(color = FFFEC265)){
            append(" ${appStr(R.string.today)}")
        }
        append("?")
    } }

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
                        mainActivityPageViewModel.setSelectedGlobalNavItem(BottomNavItemsIdentifiers.ONBOARDING_QUESTION1)
                    }

                    Spacer(Modifier.height(30.DP))

                    ProgressBarOnBoarding(2,3)

                }
            },
            bottomBar = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ButtonMainFullSize(stringResource(R.string.continue_tag)){
                        mainActivityPageViewModel.setSelectedGlobalNavItem(BottomNavItemsIdentifiers.ONBOARDING_QUESTION3)
                    }

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
                    text = question,
                    style = MaterialTheme.typography.typo36Bold.copy(fontFamily = ptSerifTypography, lineHeight = 50.SP),
                    color = MaterialTheme.colors.textColor
                )

                Spacer(Modifier.height(24.DP))

                Text(
                    text = stringResource(R.string.select_atleast_one_to_continue),
                    style = MaterialTheme.typography.typo22Normal.copy(lineHeight = 32.SP),
                    color = FFD8E2E0
                )

                Spacer(Modifier.height(40.DP))

                Text(
                    text = stringResource(R.string.wellbeing),
                    style = MaterialTheme.typography.typo24Bold,
                    color = FF219653
                )

                Spacer(Modifier.height(24.DP))


                
            }
        }
    }

}