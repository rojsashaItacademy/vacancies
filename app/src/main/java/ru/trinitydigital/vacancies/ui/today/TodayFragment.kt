package ru.trinitydigital.vacancies.ui.today

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import ru.trinitydigital.vacancies.R
import ru.trinitydigital.vacancies.databinding.FragmentTodayBinding
import ru.trinitydigital.vacancies.utils.viewBinding
import ru.trinitydigital.vacancies.utils.viewModel

class TodayFragment : Fragment(R.layout.fragment_today) {

    private val viewModel by viewModel(TodayViewModel::class)
    private val adapter by lazy { TodayAdapter(viewModel) }
    private val binding by viewBinding(FragmentTodayBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.getAllList().observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
    }
}