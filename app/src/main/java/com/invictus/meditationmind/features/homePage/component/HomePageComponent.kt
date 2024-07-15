package com.invictus.meditationmind.features.homePage.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.navigation.NavHostController
import com.invictus.meditationmind.R
import com.invictus.meditationmind.features.listening.utils.ListeningUtils
import com.invictus.meditationmind.features.mainActivityPage.Routes
import com.invictus.meditationmind.features.onBoardingFlow.component.ButtonMain
import com.invictus.meditationmind.utils.composeUtils.calender.clickable
import com.invictus.meditationmind.utils.composeUtils.theme.FF0B483E
import com.invictus.meditationmind.utils.composeUtils.theme.FF0D473D
import com.invictus.meditationmind.utils.composeUtils.theme.FF219653
import com.invictus.meditationmind.utils.composeUtils.theme.FFC2D2CF
import com.invictus.meditationmind.utils.composeUtils.theme.FFFEC265
import com.invictus.meditationmind.utils.composeUtils.theme.allCorner10
import com.invictus.meditationmind.utils.composeUtils.theme.allCorner15
import com.invictus.meditationmind.utils.composeUtils.theme.allCorner30
import com.invictus.meditationmind.utils.composeUtils.theme.allCorner50
import com.invictus.meditationmind.utils.composeUtils.theme.ptSerifTypography
import com.invictus.meditationmind.utils.composeUtils.theme.textColor
import com.invictus.meditationmind.utils.composeUtils.theme.typo12Normal
import com.invictus.meditationmind.utils.composeUtils.theme.typo16Bold
import com.invictus.meditationmind.utils.composeUtils.theme.typo18Bold
import com.invictus.meditationmind.utils.composeUtils.theme.typo20Bold
import com.invictus.meditationmind.utils.composeUtils.theme.typo24Bold
import com.invictus.meditationmind.utils.composeUtils.theme.typo36Bold
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.SP

@Composable
fun ButtonWithIcon(icon: Int = R.drawable.search, color: Color = FF219653, callback: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable { callback() }
            .background(
                color,
                MaterialTheme.shapes.allCorner15
            )
            .padding(14.DP),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = colorResource(id = R.color.white),
            modifier = Modifier
                .size(24.DP)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun ButtonWithImage(
    modifier:Modifier = Modifier,
    icon: Int = R.drawable.category,
    color: Color = FF219653,
    boxPadding: Dp = 14.DP,
    imageSize: Dp = 24.DP,
    callback: () -> Unit
) {
    Box(
        modifier = Modifier
            .then(modifier)
            .clickable { callback() }
            .background(
                color,
                MaterialTheme.shapes.allCorner15
            )
            .padding(boxPadding),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .size(imageSize)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun ButtonWithIconAndText(
    text: String,
    icon: Int = R.drawable.play_button,
    color: Color = Color.White,
    bgColor: Color = FF219653,
    callback: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(bgColor, MaterialTheme.shapes.allCorner10)
            .clickable { callback() }
            .padding(horizontal = 16.DP, vertical = 6.DP)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = color,
            modifier = Modifier.size(16.DP)
        )

        Spacer(Modifier.width(6.DP))

        Text(
            text = text,
            style = MaterialTheme.typography.typo12Normal.copy(lineHeight = 24.SP),
            color = color
        )

    }
}


@Composable
fun HomePageTopAppBar(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(Modifier.height(35.DP))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            FF0B483E,
                            MaterialTheme.shapes.allCorner15
                        )
                        .size(50.DP)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.avatar_boy),
                        contentDescription = null,
                        modifier = Modifier
                            .size(45.DP)
                            .align(Alignment.Center)
                    )
                }

                Spacer(Modifier.height(20.DP))

                Text(
                    text = "Hi Buddy!",
                    style = MaterialTheme.typography.typo36Bold.copy(fontFamily = ptSerifTypography),
                    color = MaterialTheme.colors.textColor
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .border(1.DP, FF0D473D, MaterialTheme.shapes.allCorner15)
                    .padding(4.DP)
            ) {
                ButtonWithImage( icon = R.drawable.settings,color = FF219653) {
                    navController.navigate(Routes.SettingPage.route)
                }

//                Spacer(Modifier.height(4.DP))
//
//                ButtonWithIcon(R.drawable.search, FF219653) {}

            }

        }

    }
}

@Composable
fun LatestUpdateCard(callback: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { callback() }
            .background(
                FF0D473D,
                MaterialTheme.shapes.allCorner30
            )
            .padding(start = 24.DP, top = 27.DP, bottom = 27.DP, end = 13.DP)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Column(
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = stringResource(R.string.focus_and_mindfulness),
                    style = MaterialTheme.typography.typo20Bold.copy(fontFamily = ptSerifTypography, lineHeight = 30.SP),
                    color = MaterialTheme.colors.textColor
                )

                Spacer(Modifier.height(5.DP))

                Text(
                    text = stringResource(R.string.involve_focusing_on_something),
                    style = MaterialTheme.typography.typo12Normal,
                    color = FFC2D2CF
                )

                Spacer(Modifier.height(16.DP))

                ButtonWithIconAndText(stringResource(R.string.listen_now), R.drawable.play_button) {
                    callback()
                }
            }

            Image(
                painter = painterResource(id = R.drawable.focus_mindfulness),
                contentDescription = null,
                modifier = Modifier
                    .height(150.DP)
                    .width(110.DP)
            )

        }
    }
}

@Composable
fun MostPopularSection(navController: NavHostController) {

    val meditationList = remember{ ListeningUtils.getAudioList().subList(0,2) }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = buildAnnotatedString {
                    append("${stringResource(R.string.most)}\n")
                    withStyle(SpanStyle(color = FFFEC265)) {
                        append(stringResource(R.string.popular))
                    }
                },
                style = MaterialTheme.typography.typo24Bold.copy(fontFamily = ptSerifTypography, lineHeight = 35.SP),
                color = MaterialTheme.colors.textColor
            )

            Spacer(Modifier.height(26.DP))



            MeditationItemComponent(meditationList[0].title,meditationList[0].image){
                navController.navigate(Routes.Listening.createRoute(meditationList[0].uniqueId))
            }
        }

        Column(
            horizontalAlignment = Alignment.End,
        ) {
            MeditationItemComponent(meditationList[1].title,meditationList[1].image){
                navController.navigate(Routes.Listening.createRoute(meditationList[1].uniqueId))
            }

            Spacer(Modifier.height(18.DP))

            ButtonMain(text = stringResource(R.string.explore_more), modifier = Modifier.padding(32.DP,22.DP)) {
                navController.navigate(Routes.MostPopular.route)
            }

        }
    }
}

@Composable
fun MeditationItemComponent(text: String, image: Int, callback: () -> Unit) {

    
    Box(
        modifier = Modifier
            .width(155.DP)
            .height(180.DP)
            .clickable { callback() }
            .background(
                Color.Transparent,
                MaterialTheme.shapes.allCorner30
            )
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(155.DP)
                .height(180.DP)
                .clip(MaterialTheme.shapes.allCorner30)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 20.DP, horizontal = 20.DP)
        ) {


            Box(
                modifier = Modifier
                    .background(
                        Color.White.copy(alpha = 0.64f),
                        MaterialTheme.shapes.allCorner50
                    )
                    .padding(8.DP)
                    .align(Alignment.TopStart)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.play_button),
                    contentDescription = null,
                    tint = FF219653,
                    modifier = Modifier.size(18.DP)
                )
            }

            Text(
                text = text,
                style = MaterialTheme.typography.typo18Bold.copy(fontFamily = ptSerifTypography, lineHeight = 26.SP),
                color = MaterialTheme.colors.textColor,
                modifier = Modifier.align(Alignment.BottomStart)
            )
            
        }

    }
}

@Composable
fun TitleWithClickableSecondaryTextButton(
    title: String,
    seeAllText: String,
    fontSize:TextUnit = 24.SP,
    callback: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.typo24Bold.copy(fontFamily = ptSerifTypography, fontSize = fontSize),
            color = MaterialTheme.colors.textColor
        )

        Text(
            text = seeAllText,
            style = MaterialTheme.typography.typo16Bold,
            color = FF219653,
            modifier = Modifier.clickable { callback() }
        )

    }
}