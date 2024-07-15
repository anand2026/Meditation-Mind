package com.invictus.meditationmind.features.profile.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.invictus.meditationmind.R
import com.invictus.meditationmind.features.filterCategory.component.CommonSecondaryBgComp
import com.invictus.meditationmind.features.homePage.component.ButtonWithImage
import com.invictus.meditationmind.utils.composeUtils.theme.FF13574C
import com.invictus.meditationmind.utils.composeUtils.theme.FFC2D2CF
import com.invictus.meditationmind.utils.composeUtils.theme.allCorner15
import com.invictus.meditationmind.utils.composeUtils.theme.textColor
import com.invictus.meditationmind.utils.composeUtils.theme.typo16Normal
import com.invictus.meditationmind.utils.composeUtils.theme.typo18Bold
import com.invictus.meditationmind.utils.composeUtils.theme.typo18Normal
import com.invictus.meditationmind.utils.composeUtils.theme.typo24Bold
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP

@Composable
fun ProfileComp(name:String,email:String) {
    CommonSecondaryBgComp{
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ProfileImageComp()

            Spacer(Modifier.width(16.DP))

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.typo24Bold,
                    color = MaterialTheme.colors.textColor
                )

                Spacer(Modifier.height(12.DP))

                Text(
                    text = email,
                    style = MaterialTheme.typography.typo18Normal,
                    color = FFC2D2CF
                )

            }

        }
    }
}

@Composable
fun ProfileImageComp() {
    Box(
        modifier = Modifier
            .background(
                FF13574C,
                MaterialTheme.shapes.allCorner15
            )
            .size(90.DP)
    ) {
        Image(
            painter = painterResource(id = R.drawable.boy_image),
            contentDescription = null,
            modifier = Modifier
                .size(80.DP)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun DailyProgressComp(title:String,desc:String,image:Int) {
    Box(
        modifier = Modifier
    ) {
        CommonSecondaryBgComp(
            modifier = Modifier
                .width(156.DP)
                .height(96.DP)
        ){
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
                    .align(Alignment.Center)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.typo18Bold,
                    color = MaterialTheme.colors.textColor
                )

                Spacer(Modifier.height(8.DP))

                Text(
                    text = desc,
                    style = MaterialTheme.typography.typo16Normal,
                    color = FFC2D2CF
                )
            }
        }

        ButtonWithImage(
            icon = image,
            boxPadding = 8.DP,
            color = FF13574C,
            modifier = Modifier
                .padding(8.DP)
                .align(Alignment.TopEnd)
        ) {}

    }
}