package com.invictus.meditationmind.utils.composeUtils.commonUi

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.invictus.meditationmind.R
import com.invictus.meditationmind.utils.composeUtils.theme.HomeFloatingButtonColor
import com.invictus.meditationmind.utils.composeUtils.theme.TimerProgressColor
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.SP

@Composable
fun MeditationMindTextInput(
    hintText: String,
    enteredText: MutableState<TextFieldValue>,
    keyboardType: KeyboardType = KeyboardType.Text,
    fontSize: TextUnit = 18.SP,
    textAlign: TextAlign = TextAlign.Center,
    maxChar: Int = 0,
    isMoreSpace : Boolean = false,
    boxRoundRadius : Dp = 5.DP,
    borderColor : Color = colorResource(id = R.color.inner_page_status_bar),
    backgroundColor : Color = colorResource(id = R.color.white)
) {

    runCatching {

        val modifierBox = if(isMoreSpace){
            Modifier.heightIn(min = 150.DP)
        }else{
            Modifier.wrapContentHeight()
        }

        val contAlignment = if(isMoreSpace) Alignment.TopStart else Alignment.CenterStart

        Box(
            contentAlignment = contAlignment,
            modifier = modifierBox
                .fillMaxWidth()
                .background(backgroundColor, shape = RoundedCornerShape(boxRoundRadius))
                .border(width = 2.DP, color = borderColor, RoundedCornerShape(boxRoundRadius))
                .padding(8.DP, 0.DP)


        ) {

            TextField(
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
                value = enteredText.value,
                placeholder = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = textAlign,
                        text = hintText,
                        fontSize = fontSize,
                        color = TimerProgressColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                onValueChange = { newText ->
                    if (maxChar == 0) {
                        enteredText.value = newText
                    } else {
                        if (newText.text.length <= maxChar) enteredText.value = newText
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = HomeFloatingButtonColor,
                    backgroundColor = backgroundColor,
                    cursorColor = HomeFloatingButtonColor,
                    focusedIndicatorColor = backgroundColor,
                    unfocusedIndicatorColor = backgroundColor,
                    disabledIndicatorColor = backgroundColor
                )
            )
        }
    }


}