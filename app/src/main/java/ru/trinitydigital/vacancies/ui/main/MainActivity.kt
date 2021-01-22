package ru.trinitydigital.vacancies.ui.main

import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import ru.trinitydigital.vacancies.data.model.ViewPagerModel
import ru.trinitydigital.vacancies.databinding.ActivityMainBinding
import ru.trinitydigital.vacancies.ui.common.BaseActivity
import ru.trinitydigital.vacancies.ui.similar.SimilarFragment
import ru.trinitydigital.vacancies.ui.today.TodayFragment
import ru.trinitydigital.vacancies.utils.viewBinding

class MainActivity : BaseActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val adapter by lazy { PagerAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBar)
        createDrawer(binding.toolBar)
        binding.viewPager.adapter = adapter
        adapter.update(getDataForPager())
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            tab.text = adapter.getCurrentItem(pos).title
        }.attach()
    }

    private fun getDataForPager(): ArrayList<ViewPagerModel> {
        val list = arrayListOf<ViewPagerModel>()
        list.add(ViewPagerModel(TodayFragment(), "Вакансии за сутки"))
        list.add(ViewPagerModel(SimilarFragment(), "Подходящие"))

        return list
    }
}