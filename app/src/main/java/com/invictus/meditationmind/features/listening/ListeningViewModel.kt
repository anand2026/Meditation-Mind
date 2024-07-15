package com.invictus.meditationmind.features.listening

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.invictus.meditationmind.features.listening.data.AudioMusicData

class ListeningViewModel(
    initialState: ListeningState,
    val repo: ListeningRepository,
) : MavericksViewModel<ListeningState>(initialState) {

    init {

    }

    fun audioList() = setState { copy(audioList = repo.getAudioList()) }

    companion object : MavericksViewModelFactory<ListeningViewModel, ListeningState> {
        override fun create(viewModelContext: ViewModelContext, state: ListeningState): ListeningViewModel {
            return ListeningViewModel(state, ListeningRepository())
        }
    }

}

data class ListeningState(
    val audioList: List<AudioMusicData> = emptyList()
) : MavericksState
