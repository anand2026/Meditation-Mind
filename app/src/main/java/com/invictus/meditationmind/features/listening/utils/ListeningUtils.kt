package com.invictus.meditationmind.features.listening.utils

import com.invictus.meditationmind.R
import com.invictus.meditationmind.features.listening.data.AudioMusicData

object ListeningUtils {

    fun getAudioList(): List<AudioMusicData> {
        return listOf(
            AudioMusicData(
                image = R.drawable.meditation_image1,
                title = "Vibrant Vistas",
                subTitle = "Soundscapes of Stillness",
                uri = "asset:///meditation_music1.mp3"
            ),
            AudioMusicData(
                image = R.drawable.meditation_image2,
                title = "Serenade Sanctuary",
                subTitle = "Melodies of Serene Retreat",
                uri = "asset:///calm_of_the_cosmos.mp3"
            ),
            AudioMusicData(
                image = R.drawable.meditation_image3,
                title = "Solace Symphony",
                subTitle = "Harmonic Haven Lullaby",
                uri = "asset:///dreamlike_tranquility.mp3"
            ),
            AudioMusicData(
                image = R.drawable.meditation_image4,
                title = "Oasis Oracles",
                subTitle = "Whispers of Inner Oasis",
                uri = "asset:///see_you_again.mp3"
            ),
            AudioMusicData(
                image = R.drawable.meditation_image5,
                title = "Elysian Echo",
                subTitle = "Whispers of Blissful Stillness",
                uri = "asset:///sunrise_piano_ambient.mp3"
            ),
        )
    }

}