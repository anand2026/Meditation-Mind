package com.invictus.meditationmind.features.setting.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.invictus.meditationmind.features.homePage.component.ButtonWithIcon
import com.invictus.meditationmind.features.setting.data.SettingItems
import com.invictus.meditationmind.utils.composeUtils.theme.FF13574C
import com.invictus.meditationmind.utils.composeUtils.theme.extensions.noRippleClickable
import com.invictus.meditationmind.utils.composeUtils.theme.textColor
import com.invictus.meditationmind.utils.composeUtils.theme.typo20Bold
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP

@Composable
fun SettingItem(items: SettingItems, callback: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .noRippleClickable { callback() }
    ) {
        ButtonWithIcon(
            icon = items.icon,
            color = FF13574C
        ) {

        }


        Spacer(Modifier.width(16.DP))

        Text(
            text = items.title,
            style = MaterialTheme.typography.typo20Bold,
            color = MaterialTheme.colors.textColor
        )
    }
}