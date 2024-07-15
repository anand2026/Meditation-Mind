package com.invictus.meditationmind.features.homePage

import androidx.compose.ui.graphics.Color
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext

class HomePageViewModel(
    initialState: HomePageState,
    val repo: HomePageRepository,
) : MavericksViewModel<HomePageState>(initialState) {

    init {
    }


    companion object : MavericksViewModelFactory<HomePageViewModel, HomePageState> {
        override fun create(viewModelContext: ViewModelContext, state: HomePageState): HomePageViewModel {
            val repository = HomePageRepository()
            return HomePageViewModel(state, repository)
        }
    }

}

data class HomePageState(
    val moodEmojiData: List<Pair<String, Pair<Int, Color>>> = emptyList(),
) : MavericksState
