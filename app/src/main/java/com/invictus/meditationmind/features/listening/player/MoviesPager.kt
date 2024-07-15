package com.invictus.meditationmind.features.listening.player

import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.invictus.meditationmind.features.listening.data.AudioMusicData
import com.invictus.meditationmind.features.listening.player.pagerCarousal.Pager
import com.invictus.meditationmind.features.listening.player.pagerCarousal.PagerState
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP
import kotlin.math.abs

@Composable
fun MoviesPager(musicList: List<AudioMusicData>,selectedIndex:MutableState<Int>, callback: (Int) -> Unit) {

//    val movies = remember { listOf("Hello World","Hello World","Hello World","Hello World","Hello World",) }

    if (musicList.isNotEmpty()) {
        val pagerState = remember { PagerState(maxPage = musicList.size - 1) }

        LaunchedEffect(key1 = selectedIndex){
//            pagerState.currentPage = selectedIndex.value
            pagerState.snapToOffset(selectedIndex.value.toFloat())
        }


        LaunchedEffect(key1 = pagerState.currentPage ){
            callback(pagerState.currentPage)
        }

        Pager(state = pagerState, modifier = Modifier.height(370.DP)) {
//            val movie = musicList[commingPage]
//            imageId.value = imageIds[pagerState.currentPage]
            val isSelected = pagerState.currentPage == commingPage

            // Only one page before and one page after the selected page needs to receive non zero offset
            val filteredOffset = if (abs(pagerState.currentPage - commingPage) < 2) {
                currentPageOffset
            } else 0f

            MoviePagerItem(
                isSelected,
                filteredOffset,
                musicList,
                pagerState.currentPage,
                {}
            ) {

            }
        }
    }
}
