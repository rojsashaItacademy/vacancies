package ru.trinitydigital.vacancies.data.remote

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.trinitydigital.vacancies.data.model.ItemFavoritesModel
import ru.trinitydigital.vacancies.data.model.ItemVacanciesModel

@Database(entities = [ItemVacanciesModel::class, ItemFavoritesModel::class], version = 1)
abstract class VacanciesAppDataBase : RoomDatabase() {
    abstract fun getDao(): VacanciesDao

    companion object {
        fun getInstanceDB(context: Context): VacanciesAppDataBase {
            return Room.databaseBuilder(context, VacanciesAppDataBase::class.java, "myDb")
                .allowMainThreadQueries()
                .build()
        }
    }
}