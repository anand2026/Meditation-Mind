package com.invictus.meditationmind.utils.composeUtils.commonUi

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.invictus.meditationmind.R
import com.invictus.meditationmind.utils.composeUtils.theme.extensions.noRippleClickable
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP

@Composable
fun BlockerXCloseIcon(size: Dp = 60.DP, color: Color = Color.White, modifier: Modifier, onClick: () -> Unit) {
    Icon(
        painter = painterResource(R.drawable.ic_baseline_close_24),
        tint = color,
        modifier = modifier
            .size(size)
            .noRippleClickable {
                onClick.invoke()
            },
        contentDescription = null
    )
}