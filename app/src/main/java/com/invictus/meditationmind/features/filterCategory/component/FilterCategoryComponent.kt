package com.invictus.meditationmind.features.filterCategory.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import com.invictus.meditationmind.R
import com.invictus.meditationmind.features.homePage.component.ButtonWithIcon
import com.invictus.meditationmind.utils.composeUtils.theme.FF0D473D
import com.invictus.meditationmind.utils.composeUtils.theme.FF219653
import com.invictus.meditationmind.utils.composeUtils.theme.FFFEC265
import com.invictus.meditationmind.utils.composeUtils.theme.allCorner25
import com.invictus.meditationmind.utils.composeUtils.theme.textColor
import com.invictus.meditationmind.utils.composeUtils.theme.typo24Bold
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP

@Composable
fun TopAppBarWithTwoActionButton(
    iconStart: Int = R.drawable.arrow_back,
    iconEnd: Int = R.drawable.arrow_back,
    color: Color = FF219653,
    textPair: Pair<String, String> = Pair("", ""),
    image: Int? = null,
    startCallback: () -> Unit,
    endCallback: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ButtonWithIcon(
            icon = iconStart,
            color = color,
            callback = startCallback
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (image != null) {

                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.DP)
                )

                Spacer(Modifier.width(8.DP))
            }

            TitleDualColor(textPair)
        }


//        ButtonWithIcon(
//            icon = iconEnd,
//            color = color,
//            callback = endCallback
//        )
        Spacer(Modifier.width(50.DP))
    }
}

@Composable
fun TitleDualColor(textPair: Pair<String, String>,textAlign: TextAlign = TextAlign.Center) {
    Text(
        text = buildAnnotatedString {
            append("${textPair.first} ")
            withStyle(SpanStyle(color = FFFEC265)) {
                append(textPair.second)
            }
        },
        style = MaterialTheme.typography.typo24Bold,
        color = MaterialTheme.colors.textColor,
        textAlign = textAlign,
    )
}

@Composable
fun CommonSecondaryBgComp(
    modifier: Modifier = Modifier,
    horizontalPadding : Dp = 16.DP,
    verticalPadding : Dp = 20.DP,
    cornerShape : RoundedCornerShape = MaterialTheme.shapes.allCorner25,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .background(
                color = FF0D473D,
                cornerShape
            )
            .then(modifier)
            .padding(vertical = verticalPadding, horizontal = horizontalPadding)
    ) {
        content()
    }
}