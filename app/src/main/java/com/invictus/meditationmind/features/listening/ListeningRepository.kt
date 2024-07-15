package com.invictus.meditationmind.features.listening

import com.invictus.meditationmind.R
import com.invictus.meditationmind.features.listening.data.AudioMusicData

class ListeningRepository {
    fun getAudioList(): List<AudioMusicData> {
        return listOf(
            AudioMusicData(
                image = R.drawable.test_image1,
                title = "My Music 1",
                subTitle = "My Music 1",
                uri = "asset:///meditation_music1.mp3"
            ),
            AudioMusicData(
                image = R.drawable.test_image1,
                title = "My Music 2",
                subTitle = "My Music 2",
                uri = "asset:///calm_of_the_cosmos.mp3"
            ),
            AudioMusicData(
                image = R.drawable.test_image1,
                title = "My Music 3",
                subTitle = "My Music 3",
                uri = "asset:///dreamlike_tranquility.mp3"
            ),
            AudioMusicData(
                image = R.drawable.test_image1,
                title = "My Music 4",
                subTitle = "My Music 4",
                uri = "asset:///see_you_again.mp3"
            ),
            AudioMusicData(
                image = R.drawable.test_image1,
                title = "My Music 5",
                subTitle = "My Music 5",
                uri = "asset:///sunrise_piano_ambient.mp3"
            ),
            )
    }
}