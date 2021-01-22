package ru.trinitydigital.vacancies.di.module

import dagger.Module
import dagger.Provides
import ru.trinitydigital.VacanciesApp
import ru.trinitydigital.vacancies.data.remote.VacanciesAppDataBase
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideRoom(): VacanciesAppDataBase {
        return VacanciesAppDataBase.getInstanceDB(VacanciesApp.app.applicationContext)
    }
}