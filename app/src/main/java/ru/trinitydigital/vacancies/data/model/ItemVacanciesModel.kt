package ru.trinitydigital.vacancies.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemVacanciesModel(
    @PrimaryKey
    val id: Int,
    val title: String,
    val firstName: String = "Sasha",
    val lastName: String = "Rojkov",
    val date: String,
    val jodDesc: String,
    val salary: String?,
    var isChecked: Boolean
) {
    fun getFullName() = "$firstName $lastName"
}