package com.invictus.meditationmind.features.listening.data

import androidx.annotation.Keep
import com.invictus.meditationmind.R

@Keep
data class AudioMusicData(
    val image:Int = R.drawable.test_image1,
    val title:String ="",
    val subTitle:String="",
    val uri:String = "",
    val uniqueId : String = title.trim().replace(" ","").lowercase()
)
