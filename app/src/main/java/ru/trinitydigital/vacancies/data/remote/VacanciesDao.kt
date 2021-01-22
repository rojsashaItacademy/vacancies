package ru.trinitydigital.vacancies.data.remote

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.trinitydigital.vacancies.data.model.ItemVacanciesModel

@Dao
interface VacanciesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(data: List<ItemVacanciesModel>)

    @Query("SELECT * FROM itemvacanciesmodel")
    fun getAllVacancies(): LiveData<List<ItemVacanciesModel>>

    @Update
    fun update(item: ItemVacanciesModel)

    @Query("SELECT * FROM itemvacanciesmodel WHERE isChecked")
    fun getFavourite(): LiveData<List<ItemVacanciesModel>>
}