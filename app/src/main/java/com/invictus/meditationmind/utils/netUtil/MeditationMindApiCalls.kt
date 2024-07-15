package com.invictus.meditationmind.utils.netUtil


import com.invictus.meditationmind.utils.DeleteUserParams
import com.invictus.meditationmind.utils.SetStreakParams
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

class MeditationMindApiCalls {
    fun callSetStreak(noOfDrinks: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                ApiController.mApiInterface.setStreak(setStreakParams = SetStreakParams(noOfDrinks = noOfDrinks))
                ApiController.mApiInterface.drinkHistory(drinkHistoryParams = DeleteUserParams())
            } catch (e: Exception) {
                Timber.d(e)
            }
        }
    }
}
