package com.invictus.meditationmind.features.setting.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.invictus.meditationmind.R
import com.invictus.meditationmind.features.filterCategory.component.CommonSecondaryBgComp
import com.invictus.meditationmind.features.filterCategory.component.TopAppBarWithTwoActionButton
import com.invictus.meditationmind.features.setting.data.SettingIdentifier
import com.invictus.meditationmind.features.setting.data.SettingItems
import com.invictus.meditationmind.utils.CommonUtils
import com.invictus.meditationmind.utils.PrivacyPolicyUrls
import com.invictus.meditationmind.utils.composeUtils.theme.FF219653
import com.invictus.meditationmind.utils.composeUtils.theme.appBackgroundColor
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP
import splitties.resources.appStr

@Composable
fun SettingPage(navController: NavHostController) {

    val settingItems = remember { listOf(
//        SettingItems(R.drawable.settings, appStr(R.string.account_information),SettingIdentifier.ACCOUNT_IDENTIFIER),
//        SettingItems(R.drawable.settings, appStr(R.string.notification),SettingIdentifier.NOTIFICATIONS),
//        SettingItems(R.drawable.settings, appStr(R.string.daily_reminders),SettingIdentifier.DAILY_REMINDERS),
        SettingItems(R.drawable.privacy_policy, appStr(R.string.privacy_policy),SettingIdentifier.PRIVACY_POLICY),
        SettingItems(R.drawable.terms_of_usage, appStr(R.string.terms_of_Use),SettingIdentifier.TERMS_OF_USAGE),
    ) }

    val context = LocalContext.current

    Surface(
        color = MaterialTheme.colors.appBackgroundColor,
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            backgroundColor = Color.Transparent,
            topBar = {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    TopAppBarWithTwoActionButton(
                        iconEnd = R.drawable.search,
                        color = FF219653,
                        textPair= Pair("Manage your","\nSetting"),
                        startCallback = {
                            navController.popBackStack()
                        }) {

                    }
                }
            },
            bottomBar = {},
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 35.DP)
                .padding(20.DP, 0.DP)
        ) { pad ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(pad)
            ) {

                Spacer(Modifier.height(30.DP))

                CommonSecondaryBgComp(
                    horizontalPadding = 32.DP,
                    verticalPadding = 20.DP
                ) {

                    LazyColumn(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        settingItems.forEach {
                            item {
                                SettingItem(it){
                                    when(it.identifier){
                                        SettingIdentifier.PRIVACY_POLICY -> {
                                            CommonUtils.openWebPage(PrivacyPolicyUrls.POLICY.value,context)
                                        }
                                        SettingIdentifier.TERMS_OF_USAGE -> {
                                            CommonUtils.openWebPage(PrivacyPolicyUrls.TERMS.value,context)
                                        }
                                        else -> {}
                                    }
                                }

                                Spacer(Modifier.height(30.DP))
                            }
                        }

                    }

                }

            }
        }
    }
}