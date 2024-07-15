package com.invictus.meditationmind.features.graphCalendar.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.invictus.meditationmind.R
import com.invictus.meditationmind.data.sharedPrefs.MeditationMindSharedPrefs
import com.invictus.meditationmind.features.graphCalendar.CalendarState
import com.invictus.meditationmind.features.graphCalendar.CalendarViewModel
import com.invictus.meditationmind.features.graphCalendar.component.common.CalendarOfDateLoggingPage
import com.invictus.meditationmind.features.graphCalendar.utils.CalendarUtils
import com.invictus.meditationmind.features.mainActivityPage.MainActivityPageViewModel
import com.invictus.meditationmind.features.mainActivityPage.data.BottomNavItemsIdentifiers
import com.invictus.meditationmind.utils.TimeConversionUtils.isBeforeOrEqual
import com.invictus.meditationmind.utils.TimeConversionUtils.toLocalDate
import com.invictus.meditationmind.utils.composeUtils.theme.appBackgroundColor
import com.invictus.meditationmind.utils.displayUnitConverter.UnitConverter.DP
import splitties.resources.appStr
import splitties.toast.UnreliableToastApi
import splitties.toast.toast
import java.time.LocalDate

@OptIn(UnreliableToastApi::class)
@Composable
fun CalenderDateSelector(mainActivityPageViewModel: MainActivityPageViewModel) {

    val viewModel: CalendarViewModel = mavericksViewModel()
    val calendarViewModel: CalendarViewModel = mavericksViewModel()
    val periodItemList by calendarViewModel.collectAsState(CalendarState::periodItemList)
    val dayWiseColor = remember { mutableStateListOf<Pair<LocalDate, LocalDate>>() }
    LaunchedEffect(key1 = periodItemList) {
        dayWiseColor.clear()
        periodItemList.forEach {
            dayWiseColor.add(Pair(it.startDate.toLocalDate(), it.endDate.toLocalDate()))
        }
    }
    val isNeedToAskPeriodStart = CalendarUtils.isNeedToAskPeriodStart(dayWiseColor.lastOrNull()?.first?.plusDays(MeditationMindSharedPrefs.CYCLE_LENGTH.toLong()), dayWiseColor.lastOrNull()?.second?.plusDays(
        MeditationMindSharedPrefs.CYCLE_LENGTH.toLong()),LocalDate.now().atStartOfDay().toLocalDate())


    Surface(
        color = MaterialTheme.colors.appBackgroundColor,
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            bottomBar = {},
            topBar = {},
            backgroundColor = Color.Transparent,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.DP)
        ) { pad ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(pad)
            ) {
                CalendarOfDateLoggingPage(isNeedToAskPeriodStart,{
                    mainActivityPageViewModel.setSelectedGlobalNavItem(BottomNavItemsIdentifiers.NONE)
                }) { startDate, endDate ->
                    val isStartDateBefore = startDate.isBeforeOrEqual(LocalDate.now().atStartOfDay().toLocalDate())

                    if(isStartDateBefore) {
                        viewModel.insertPeriodLoggingData(startDate.atStartOfDay().toLocalDate(), endDate.atStartOfDay().toLocalDate())
                        mainActivityPageViewModel.setSelectedGlobalNavItem(BottomNavItemsIdentifiers.NONE)
                    }else{
                        toast(appStr(R.string.start_date_should_be_today_of_before_today))
                    }
                }
            }
        }
    }
}