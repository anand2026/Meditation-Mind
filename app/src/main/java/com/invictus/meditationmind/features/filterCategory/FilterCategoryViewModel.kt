package com.invictus.meditationmind.features.filterCategory

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.invictus.meditationmind.features.filterCategory.data.MeditationItemData

class FilterCategoryViewModel(
    initialState: FilterCategoryState,
    private val repo: FilterCategoryRepository,
) : MavericksViewModel<FilterCategoryState>(initialState) {

    init {
        initData()
    }

    private fun initData() = setState { copy(listOfPlayingItems = repo.listOfPlayingItems()) }

    companion object : MavericksViewModelFactory<FilterCategoryViewModel, FilterCategoryState> {
        override fun create(viewModelContext: ViewModelContext, state: FilterCategoryState): FilterCategoryViewModel {
            return FilterCategoryViewModel(state, FilterCategoryRepository())
        }
    }

}

data class FilterCategoryState(
    val temp: String = "",
    val listOfPlayingItems: List<MeditationItemData> = emptyList(),
) : MavericksState
