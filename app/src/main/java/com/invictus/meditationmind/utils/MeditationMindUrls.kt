package com.invictus.meditationmind.utils

import splitties.init.appCtx

enum class PrivacyPolicyUrls(val value : String) {
    FEEDBACK("https://forms.gle/ve9eJyQFLd7Av1MM7"),
    TERMS("https://meditation-mind-mission-invictus.blogspot.com/p/terms-and-conditions.html"),
    POLICY("https://meditation-mind-mission-invictus.blogspot.com/p/privacy-policy.html"),
}

enum class SettingPageUrls(val value : String) {
    MEDITATION_MIND_ONE_LINK("https://meditationmind.onelink.me/20vl/meditationmindref"),
    MEDITATION_MIND_PLAY_STORE("https://play.google.com/store/apps/details?id=${appCtx.packageName}"),
}