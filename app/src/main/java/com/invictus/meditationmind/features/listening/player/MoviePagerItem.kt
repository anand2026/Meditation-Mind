package com.invictus.meditationmind.features.listening.player

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LibraryAdd
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.invictus.meditationmind.features.listening.data.AudioMusicData
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP
import kotlin.math.abs
import kotlin.math.min

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MoviePagerItem(
    isSelected: Boolean,
    offset: Float,
    musicList: List<AudioMusicData>,
    selectedIndex: Int,
    addToWatchList: () -> Unit,
    openMovieDetail: () -> Unit
) {
    val animateHeight = getOffsetBasedValue(
        selectedValue = 370,
        nonSelectedValue = 280,
        isSelected = isSelected,
        offset = offset
    ).DP
    val animateWidth = getOffsetBasedValue(
        selectedValue = 310,
        nonSelectedValue = 270,
        isSelected = isSelected,
        offset = offset
    ).DP
    val animateElevation = getOffsetBasedValue(
        selectedValue = 12,
        nonSelectedValue = 2,
        isSelected = isSelected,
        offset = offset
    ).DP

//    val posterFullPath = "https://image.tmdb.org/t/p/w500/${movie.poster_path}"


    Card(
        elevation = animateDpAsState(animateElevation, label = "").value,
        modifier = Modifier
            .width(animateWidth)
            .height(animateHeight)
            .padding(24.dp),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = MaterialTheme.colors.onBackground,
        contentColor = MaterialTheme.colors.background,
        onClick = { openMovieDetail.invoke() },
    ) {
        Column {
            Image(
                painter = painterResource(id = musicList[selectedIndex].image),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(360.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                val clicked = remember { mutableStateOf(false) }
                Text(
                    text = "movie.title",
                    modifier = Modifier.padding(8.dp),
                    style = typography.h6
                )
                IconButton(onClick = {
                    addToWatchList.invoke()
                    clicked.value = !clicked.value
                }) {
                    Icon(
                        imageVector = Icons.Default.LibraryAdd,
                        tint = MaterialTheme.colors.primary,
                        contentDescription = null,
                        modifier = Modifier
                            .graphicsLayer(
                                rotationY = animateFloatAsState(
                                    if (clicked.value) 720f else 0f, tween(400), label = ""
                                ).value
                            )
                    )
                }
            }

//            Text(
//                text = "Release: ${movie.release_date}",
//                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
//                style = typography.h6.copy(fontSize = 12.sp)
//            )
//            Text(
//                text = "PG13  •  ${movie.vote_average}/10",
//                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
//                style = typography.h6.copy(fontSize = 12.sp, fontWeight = FontWeight.Medium)
//            )
//            Text(
//                text = movie.overview,
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis,
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//                    .padding(8.dp)
//                    .weight(1f),
//                style = typography.subtitle2
//            )
//            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
//                Text(text = "Get Tickets", modifier = Modifier.padding(8.dp))
//            }
        }
    }
}

private fun getOffsetBasedValue(
    selectedValue: Int,
    nonSelectedValue: Int,
    isSelected: Boolean,
    offset: Float,
): Float {
    val actualOffset = if (isSelected) 1 - abs(offset) else abs(offset)
    val delta = abs(selectedValue - nonSelectedValue)
    val offsetBasedDelta = delta * actualOffset

    return min(selectedValue, nonSelectedValue) + offsetBasedDelta
}
