package ru.trinitydigital.vacancies.di

import ru.trinitydigital.VacanciesApp
import ru.trinitydigital.vacancies.data.remote.VacanciesAppDataBase
import javax.inject.Inject

inline fun <T> inject(crossinline block: Injector.() -> T): Lazy<T> = lazy { Injector().block() }

class Injector {

    @Inject
    lateinit var db: VacanciesAppDataBase

    init {
        VacanciesApp.app.mainComponent.inject(this)
    }
}