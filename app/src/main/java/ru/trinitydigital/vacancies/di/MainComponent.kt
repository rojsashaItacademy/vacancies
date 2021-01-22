package ru.trinitydigital.vacancies.di

import dagger.Component
import ru.trinitydigital.vacancies.di.module.RoomModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RoomModule::class]
)
interface MainComponent {
    fun inject(injector: Injector)
}