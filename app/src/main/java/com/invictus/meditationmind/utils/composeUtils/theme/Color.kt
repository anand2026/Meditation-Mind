package com.invictus.meditationmind.utils.composeUtils.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color


val primaryColor = Color(0xFF8B7FF5) //#8B7FF5
val secondaryColor = Color(0xFFFC91B6) //#FC91B6

private val darkBackground = Color(0xFF20314B) //#20314B
private val lightBackground =  Color(0xFFFFFFFF) //#FFFFFF
val FFF4F4FF = Color(0xFFF4F4FF) //#F4F4FF
val FFF5F1FF = Color(0xFFF5F1FF) //#F5F1FF
val FFF5D2DF = Color(0xFFF5D2DF) //#F5D2DF
val FFAFE9E5 = Color(0xFFAFE9E5) //#AFE9E5
val FFFFE2C7 = Color(0xFFFFE2C7) //#FFE2C7
val FFFFE299 = Color(0xFFFFE299) //#FFE299
val FF89969F = Color(0xFF89969F) //#89969F
val FF9B78F3 = Color(0xFF9B78F3) //#9B78F3
val FF434956 = Color(0xFF434956) //#434956
val FFEEE8FF = Color(0xFFEEE8FF) //#EEE8FF
val FF7583FF = Color(0xFF7583FF) //#7583FF
val FF968AFD = Color(0xFF968AFD) //#968AFD
val FFFFEFEF = Color(0xFFFFEFEF) //#FFEFEF
val FFF24187 = Color(0xFFF24187) //#F24187
val FFFFE2EC = Color(0xFFFFE2EC) //#FFE2EC
val FF152338 = Color(0xFF152338) //#152338
val FFFFF1E3 = Color(0xFFFFF1E3) //#FFF1E3
val FFDBD7FF = Color(0xFFDBD7FF) //#DBD7FF
val FFD5F0EF = Color(0xFFD5F0EF) //#D5F0EF
val FFF30B57 = Color(0xFFF30B57) //#F30B57
val FFB7225D = Color(0xFFB7225D) //#B7225D
val FFFFE3AD = Color(0xFFFFE3AD) //#FFE3AD
val FFAFCBF5 = Color(0xFFAFCBF5) //#AFCBF5
val FFE6C7FF = Color(0xFFE6C7FF) //#E6C7FF
val FFFFC7C7 = Color(0xFFFFC7C7) //#FFC7C7
val FF94D9C0 = Color(0xFF94D9C0) //#94D9C0
val FF849EFB = Color(0xFF849EFB) //#849EFB
val FFFFA4C1 = Color(0xFFFFA4C1) //#FFA4C1
val FF7E7E7E = Color(0xFF7E7E7E) //#7E7E7E
val FF153843 = Color(0xFF153843) //#153843
val FF7A7A7A = Color(0xFF7A7A7A) //#7A7A7A


val FF07362E = Color(0xFF07362E) //#07362E
val FFFEC265 = Color(0xFFFEC265) //#FEC265
val FF219653 = Color(0xFF219653) //#219653
val FF141333 = Color(0xFF141333) //#141333
val FFD8E2E0 = Color(0xFFD8E2E0) //#D8E2E0
val FF0B483E = Color(0xFF0B483E) //#0B483E
val FF0D473D = Color(0xFF0D473D) //#0D473D
val FFC2D2CF = Color(0xFFC2D2CF) //#C2D2CF
val FFA7BDB9 = Color(0xFFA7BDB9) //#A7BDB9
val FFC4C4C4 = Color(0xFFC4C4C4) //#C4C4C4
val FF13574C = Color(0xFF13574C) //#13574C
val FFEAEFEE = Color(0xFFEAEFEE) //#EAEFEE

/** --------------------------------- other Colors --------------------------------------------------- **/
val blue500 = Color(0xFF3F51B5)
val blue200 = Color(0xFF9FA8DA)


val teal200 = Color(0xff80deea)
val InAppBlockingFloatingGradientUpperColor = Color(0xFF4F2EB6)
val InAppBlockingFloatingGradientLowerColor = Color(0xFF7013A9)

val AppNameColor = Color(0xFF031B44)
val AccessibilityButtonColor = Color(0xFF53D3AF)
val HomeFloatingButtonColor = Color(0xFF7393DD)
val DialogCancelColor = Color(0xFF666666)
val TimerProgressColor = Color(0xFFafafaf)

/** ---------------------------------------------------------------------------------------------------- **/

val darkRedGradient = arrayListOf(FFF30B57,FFB7225D)
val lightPinkGradient = arrayListOf(FFFFA4C1,FFF24187)

val String.color
    get() = Color(android.graphics.Color.parseColor(this))


val Colors.appBackgroundColor
    get() = if(isLight)FF07362E  else FF07362E
val Colors.splashScreenColor
    get() = if(isLight) FFF4F4FF else darkBackground
val Colors.textColor
    get() = if(isLight) Color.White else Color.White
val Colors.notificationItemBackground
    get() = if(isLight) Color.White else FF434956
val Colors.homeHeartAreaBackground
    get() = if(isLight) FFFFEFEF else darkBackground
val Colors.homePageBottomColor
    get() = if(isLight) Color.White else Color.Black
val Colors.itemShowColor
    get() = if(isLight) Color.White else FF152338
val Colors.calendarTopBarColor
    get() = if(isLight) FFFFF1E3 else FF152338