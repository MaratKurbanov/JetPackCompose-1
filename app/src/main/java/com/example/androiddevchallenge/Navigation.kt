package com.example.androiddevchallenge

enum class ScreenName { HOME, DETAIL }

sealed class Screen(val id: ScreenName) {
    object Home : Screen(ScreenName.HOME)
    object Details : Screen(ScreenName.DETAIL)
}

val items = listOf(
    Screen.Home,
    Screen.Details,
)