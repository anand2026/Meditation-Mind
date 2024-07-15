package com.invictus.meditationmind.features.onBoardingFlow.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import com.invictus.meditationmind.R
import com.invictus.meditationmind.utils.composeUtils.calender.clickable
import com.invictus.meditationmind.utils.composeUtils.theme.FF141333
import com.invictus.meditationmind.utils.composeUtils.theme.FF219653
import com.invictus.meditationmind.utils.composeUtils.theme.FFFEC265
import com.invictus.meditationmind.utils.composeUtils.theme.allCorner15
import com.invictus.meditationmind.utils.composeUtils.theme.secondaryColor
import com.invictus.meditationmind.utils.composeUtils.theme.typo16Bold
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.SP


@Composable
fun ButtonMainFullSize(
    text:String,
    callback: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { callback() }
            .background(
                FFFEC265,
                MaterialTheme.shapes.allCorner15
            )
            .padding(vertical = 20.DP, horizontal = 0.DP),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.typo16Bold,
            color = FF141333
        )
    }
}

@Composable
fun ButtonMain(
    text:String,
    modifier: Modifier = Modifier,
    callback: () -> Unit
) {
    Box(
        modifier = Modifier
            .clickable { callback() }
            .background(
                FFFEC265,
                MaterialTheme.shapes.allCorner15
            ).then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.typo16Bold,
            color = FF141333
        )
    }
}

@Composable
fun BackButtonOnboarding(callback: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable { callback() }
            .background(
                FF219653,
                MaterialTheme.shapes.allCorner15
            )
            .padding(14.DP),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = null,
            tint = colorResource(id = R.color.white),
            modifier = Modifier
                .size(24.DP)
                .align(Alignment.Center)
        )
    }
}


@Composable
fun ProgressBarOnBoarding(progress:Int,total:Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(arrayListOf(Color.White.copy(alpha = 0.3f), Color.Transparent)),
                MaterialTheme.shapes.allCorner15
            )
            .height(10.DP)
            .padding(vertical = 0.DP, horizontal = 0.DP)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(
                    progress
                        .toFloat()
                        .div(total)
                )
                .background(
                    FF219653,
                    MaterialTheme.shapes.allCorner15
                ).fillMaxHeight()
        )
    }
}


@Composable
fun ClickableTextBetweenSentences(
    fullSentence: String,
    clickableTexts: List<String>,
    fullTextColor: Color = colorResource(id = R.color.approve_terms_message),
    clickableTextColor: Color = secondaryColor,
    fontSize: TextUnit = 12.SP,
    fontWeight: FontWeight = FontWeight.Normal,
    lineHeight: TextUnit = 14.SP,
    onClick: (String) -> Unit
) {

    val annotatedString = buildAnnotatedString {
        append(fullSentence)

        clickableTexts.forEach {
            addStyle(
                style = SpanStyle(
                    color = clickableTextColor,
                    fontSize = fontSize,
                    textDecoration = TextDecoration.Underline,
                ),
                start = fullSentence.indexOf(it),
                end = fullSentence.indexOf(it) + it.length,
            )

            addStringAnnotation(tag = "URL", annotation = it, start = fullSentence.indexOf(it), end = fullSentence.indexOf(it) + it.length)
        }
    }

    ClickableText(
        text = annotatedString,
        style = MaterialTheme.typography.body1.copy(
            color = fullTextColor,
            fontSize = fontSize,
            textAlign = TextAlign.Center,
            lineHeight = lineHeight,
            fontWeight = fontWeight
        ),
        onClick = { offset ->
            annotatedString.getStringAnnotations("URL", start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    onClick.invoke(annotation.item)
                }
        }
    )
}