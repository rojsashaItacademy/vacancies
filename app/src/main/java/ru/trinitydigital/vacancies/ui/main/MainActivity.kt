package ru.trinitydigital.vacancies.ui.main

import android.os.Bundle
import ru.trinitydigital.vacancies.databinding.ActivityMainBinding
import ru.trinitydigital.vacancies.ui.common.BaseActivity
import ru.trinitydigital.vacancies.utils.viewBinding

class MainActivity : BaseActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBar)
        createDrawer(binding.toolBar)
    }
}