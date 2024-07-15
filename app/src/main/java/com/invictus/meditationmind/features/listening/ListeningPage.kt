package com.invictus.meditationmind.features.listening

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.navigation.NavHostController
import com.invictus.meditationmind.R
import com.invictus.meditationmind.features.filterCategory.component.CommonSecondaryBgComp
import com.invictus.meditationmind.features.filterCategory.component.TopAppBarWithTwoActionButton
import com.invictus.meditationmind.features.listening.player.MoviesPager
import com.invictus.meditationmind.features.listening.utils.ListeningUtils
import com.invictus.meditationmind.utils.composeUtils.theme.FF0B483E
import com.invictus.meditationmind.utils.composeUtils.theme.FF219653
import com.invictus.meditationmind.utils.composeUtils.theme.FFC2D2CF
import com.invictus.meditationmind.utils.composeUtils.theme.FFFEC265
import com.invictus.meditationmind.utils.composeUtils.theme.allCorner100
import com.invictus.meditationmind.utils.composeUtils.theme.appBackgroundColor
import com.invictus.meditationmind.utils.composeUtils.theme.extensions.noRippleClickable
import com.invictus.meditationmind.utils.composeUtils.theme.textColor
import com.invictus.meditationmind.utils.composeUtils.theme.typo16Normal
import com.invictus.meditationmind.utils.composeUtils.theme.typo24Bold
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP

@Composable
fun ListeningPage(navController: NavHostController, id: String?) {

    val context = LocalContext.current

    val musicList = remember { ListeningUtils.getAudioList().filter {
        if(id?.isEmpty()==true) true else id?.contains(it.uniqueId) == true } }
    val selectedIndex = remember { mutableIntStateOf(0) }

    val player = remember {ExoPlayer.Builder(context).build()}
    val isPlayerPlaying = remember { mutableStateOf(false) }


    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> {
                    player.play()
                    isPlayerPlaying.value = true
                }

                Lifecycle.Event.ON_PAUSE -> {
                    player.pause()
                    isPlayerPlaying.value = false
                }

                else -> Unit
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            player.release()
        }
    }

    LaunchedEffect(key1 = musicList){
        if(musicList.isNotEmpty() && player.playbackState != Player.STATE_READY) {
            musicList.forEach{
                val audioUri = Uri.parse(it.uri);
                val mediaItem = MediaItem.fromUri(audioUri)
                player.addMediaItem(mediaItem)
            }
//            player.setMediaItem(MediaItem.fromUri(Uri.parse(musicList[0].uri)))
            player.prepare()
            player.play()
            isPlayerPlaying.value = true
        }
    }



    Surface(
        color = MaterialTheme.colors.appBackgroundColor,
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            backgroundColor = Color.Transparent,
            topBar = {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.DP)
                ) {
                    Spacer(Modifier.height(35.DP))

                    TopAppBarWithTwoActionButton(
                        iconEnd = R.drawable.search,
                    color = FF219653,
                    textPair= Pair("", stringResource(R.string.listening)),
                    image = R.drawable.audiobook,
                        startCallback = {
                            navController.popBackStack()
                        }) {

                    }
                }

            },
            bottomBar = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.DP)
                ) {

                    Spacer(Modifier.height(20.DP))

                    Text(
                        text = musicList[selectedIndex.intValue].title,
                        style = MaterialTheme.typography.typo24Bold,
                        color = MaterialTheme.colors.textColor
                    )

                    Spacer(Modifier.height(13.DP))

                    Text(
                        text = musicList[selectedIndex.intValue].subTitle,
                        style = MaterialTheme.typography.typo16Normal,
                        color = FFC2D2CF
                    )

                    Spacer(Modifier.height(30.DP))


                    Spacer(Modifier.height(30.DP))

                    CommonSecondaryBgComp {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.playback),
                                contentDescription = null,
                                tint = Color.Transparent,//colorResource(id = R.color.white),
                                modifier = Modifier
                                    .size(24.DP)
                                    .noRippleClickable {
//                                        player.stop()
//                                        musicList = musicList.shuffled()
                                    }
                            )

                            Icon(
                                painter = painterResource(id = R.drawable.backward),
                                contentDescription = null,
                                tint = Color.Transparent,//colorResource(id = R.color.white),
                                modifier = Modifier
                                    .size(24.DP)
                                    .noRippleClickable {
//                                        selectedIndex.value = if(selectedIndex.value > 0 ) selectedIndex.value-1 else selectedIndex.value
//                                        if(player.hasPreviousMediaItem()){
//                                            player.seekToPrevious()
//                                        }
                                    }
                            )

                            Box(
                                modifier = Modifier
                                    .background(
                                        FFFEC265,
                                        MaterialTheme.shapes.allCorner100
                                    )
                                    .noRippleClickable {
                                        if (player.isPlaying) {
                                            player.pause()
                                            isPlayerPlaying.value = false
                                        } else {
                                            player.play()
                                            isPlayerPlaying.value = true
                                        }
                                    }
                                    .padding(12.DP)
                            ) {
                                Icon(
                                    painter = painterResource(id = if(isPlayerPlaying.value) R.drawable.pause else  R.drawable.play_button),
                                    contentDescription = null,
                                    tint = FF0B483E,
                                    modifier = Modifier
                                        .size(24.DP)
                                        .align(Alignment.Center)
                                )
                            }


                            Icon(
                                painter = painterResource(id = R.drawable.forward),
                                contentDescription = null,
                                tint = Color.Transparent,//colorResource(id = R.color.white),
                                modifier = Modifier
                                    .size(24.DP)
                                    .noRippleClickable {
//                                    selectedIndex.value = if(selectedIndex.value < musicList.size-1 ) selectedIndex.value+1 else selectedIndex.value
//                                    if(player.hasNextMediaItem()){
//                                        player.seekToNext()
//                                    }
                                    }
                            )

                            Icon(
                                painter = painterResource(id = R.drawable.refresh),
                                contentDescription = null,
                                tint = colorResource(id = R.color.white),
                                modifier = Modifier
                                    .size(24.DP)
                                    .noRippleClickable {
                                        player.seekToDefaultPosition(0)
                                    }
                            )

                        }
                    }

                }
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(0.DP, 0.DP),
        ) { pad ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(pad)
                    .padding(0.DP, 0.DP),
                verticalArrangement = Arrangement.Center
            ) {

                Spacer(Modifier.height(10.DP))

                MoviesPager(musicList,selectedIndex){
                    selectedIndex.intValue = it

                    if(it == 0){
                     player.seekToDefaultPosition(0)
                    }else if(it == musicList.size-1){
                        player.seekToDefaultPosition(musicList.size-1)
                    }else if(it > player.currentMediaItemIndex){
                        player.seekToNext()
                    }else{
                        player.seekToPrevious()
                    }
                }


            }
        }
    }

}