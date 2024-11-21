package com.example.gita_1

data class StatsItem(
    val title: String,
    val number: String
)


val statsItems = listOf(
    StatsItem("Posts", "32"),
    StatsItem("Followers", "3.5k"),
    StatsItem("Following", "212")
)
