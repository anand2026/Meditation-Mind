package com.invictus.meditationmind.data.database.periodTrack

import com.invictus.meditationmind.data.database.MeditationMindDatabase
import com.invictus.meditationmind.utils.TimeConversionUtils.toLocalDate
import com.invictus.meditationmind.utils.alaramManager.ScheduleAlarm


object PeriodTrackerValues{

    fun getAllPeriodHistory() = MeditationMindDatabase.getInstance().periodTrackerDao().getPeriodList()
    private fun getPeriodListNormal() = MeditationMindDatabase.getInstance().periodTrackerDao().getPeriodListNormal()

    suspend fun insertPeriodItem(item: PeriodTrackModel) {
        MeditationMindDatabase.getInstance().periodTrackerDao().insertPeriodItem(item)
        getPeriodListNormal().lastOrNull()?.let { track-> ScheduleAlarm.setAlarmForNotification(track.startDate.toLocalDate().atStartOfDay().toLocalDate(),track.endDate.toLocalDate().atStartOfDay().toLocalDate()) }
//        CalendarUtils.calculatePeriodDays(getPeriodListNormal())
    }

    suspend fun deleteAllPeriodHistory() {
        MeditationMindDatabase.getInstance().periodTrackerDao().deleteAll()
    }

}
