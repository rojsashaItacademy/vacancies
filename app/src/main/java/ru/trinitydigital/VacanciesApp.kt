package ru.trinitydigital

import android.app.Application
import ru.trinitydigital.vacancies.di.DaggerMainComponent
import ru.trinitydigital.vacancies.di.MainComponent

class VacanciesApp : Application() {

    lateinit var mainComponent: MainComponent

    override fun onCreate() {
        super.onCreate()
        app = this
        mainComponent = DaggerMainComponent
            .builder()
            .build()
    }

    companion object {
        lateinit var app: VacanciesApp
    }
}