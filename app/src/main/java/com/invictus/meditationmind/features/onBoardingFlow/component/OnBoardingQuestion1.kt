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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.invictus.meditationmind.R
import com.invictus.meditationmind.utils.composeUtils.scrollablePicker.Picker
import com.invictus.meditationmind.utils.composeUtils.scrollablePicker.rememberPickerState
import com.invictus.meditationmind.utils.composeUtils.theme.FFD8E2E0
import com.invictus.meditationmind.utils.composeUtils.theme.FFFEC265
import com.invictus.meditationmind.utils.composeUtils.theme.appBackgroundColor
import com.invictus.meditationmind.utils.composeUtils.theme.ptSerifTypography
import com.invictus.meditationmind.utils.composeUtils.theme.textColor
import com.invictus.meditationmind.utils.composeUtils.theme.typo22Normal
import com.invictus.meditationmind.utils.composeUtils.theme.typo36Bold
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.SP
import splitties.resources.appStr

@Preview
@Composable
fun OnBoardingQuestion1Preview() {
    OnBoardingQuestion1()
}

@Composable
fun OnBoardingQuestion1(/*mainActivityPageViewModel: MainActivityPageViewModel*/) {

    val question = remember{ buildAnnotatedString {
        append(appStr(R.string.when_were_you))
        withStyle(SpanStyle(color = FFFEC265)){
            append(" ${appStr(R.string.born)}")
        }
        append("?")
    } }

    val values = remember { (1950..2023).map { it.toString() } }
    val valuesPickerState = rememberPickerState()

    Surface(
        color = MaterialTheme.colors.appBackgroundColor,
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            backgroundColor = Color.Transparent,
            bottomBar = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ButtonMainFullSize(stringResource(R.string.continue_tag)){
//                        mainActivityPageViewModel.setSelectedGlobalNavItem(BottomNavItemsIdentifiers.ONBOARDING_QUESTION2)
                    }

                    Spacer(Modifier.height(60.DP))
                }
            },
            topBar = {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(Modifier.height(40.DP))

                    BackButtonOnboarding{}

                    Spacer(Modifier.height(30.DP))

                    ProgressBarOnBoarding(1,3)

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
                    text = stringResource(R.string.we_need_this_info_to_ensure),
                    style = MaterialTheme.typography.typo22Normal.copy(lineHeight = 32.SP),
                    color = FFD8E2E0
                )

                Spacer(Modifier.height(40.DP))

                Picker(
                    state = valuesPickerState,
                    items = values,
                    visibleItemsCount = 5,
                    modifier = Modifier.weight(0.3f),
                    textModifier = Modifier.padding(8.dp),
                    textStyle = TextStyle(fontSize = 32.sp)
                )
                
            }
        }
    }

}