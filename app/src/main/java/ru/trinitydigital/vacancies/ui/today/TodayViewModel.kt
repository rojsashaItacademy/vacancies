package ru.trinitydigital.vacancies.ui.today

import androidx.lifecycle.ViewModel
import ru.trinitydigital.vacancies.data.model.ItemVacanciesModel
import ru.trinitydigital.vacancies.di.inject

class TodayViewModel : ViewModel() {

    private val db by inject { db }

    init {
        generateData()
    }

    fun getAllList() = db.getDao().getAllVacancies()

    fun update(item: ItemVacanciesModel) {
        db.getDao().update(item)
    }

    private fun generateData() {
        val list = arrayListOf<ItemVacanciesModel>()

        for (i in 0..100) {
            list.add(
                ItemVacanciesModel(
                    id = i,
                    title = "Job position $i",
                    date = "22.11.2201",
                    jodDesc = "Job desc $i",
                    salary = (i * 1000).toString(),
                    isChecked = false
                )
            )
        }

        db.getDao().insert(list)
    }
}