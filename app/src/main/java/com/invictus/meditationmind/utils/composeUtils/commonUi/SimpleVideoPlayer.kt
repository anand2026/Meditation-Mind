package com.invictus.meditationmind.utils.composeUtils.commonUi

import android.content.Context
import android.net.Uri
import androidx.annotation.OptIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultDataSourceFactory
import androidx.media3.exoplayer.SimpleExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView

@OptIn(UnstableApi::class) @Composable
fun SimpleVideoPlayer(context: Context, url: String) {
    val simpleVideoPlayer = remember {
        SimpleExoPlayer.Builder(context)
            .build()
            .apply {
                val mediaSource = ProgressiveMediaSource
                    .Factory(
                        DefaultDataSourceFactory(context, "MeditationMind")
                    )
                    .createMediaSource(MediaItem.fromUri(Uri.parse("asset:///${url}")))

                this.setMediaSource(mediaSource, true)
                this.prepare()
            }
    }
    simpleVideoPlayer.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
    simpleVideoPlayer.repeatMode = Player.REPEAT_MODE_ONE
    AndroidView({
        PlayerView(it).apply {
            useController = false
            player = simpleVideoPlayer
            resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
        }
    })

    simpleVideoPlayer.playWhenReady = true

    DisposableEffect(key1 = url) {
        onDispose {
            simpleVideoPlayer.release()
        }
    }
}