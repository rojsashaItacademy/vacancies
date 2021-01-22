package ru.trinitydigital.vacancies.ui.today

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.trinitydigital.vacancies.data.model.ItemVacanciesModel
import ru.trinitydigital.vacancies.databinding.ItemVacaniciesBinding

class TodayAdapter(private val viewModel: TodayViewModel) :
    RecyclerView.Adapter<TodayViewHolder>() {

    private var data: ArrayList<ItemVacanciesModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayViewHolder {
        val binding =
            ItemVacaniciesBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TodayViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: TodayViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun update(data: List<ItemVacanciesModel>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size
}


class TodayViewHolder(
    private val binding: ItemVacaniciesBinding,
    private val viewModel: TodayViewModel
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ItemVacanciesModel) {
        binding.tvDate.text = item.date
        binding.tvJob.text = item.title
        binding.tvSalary.text = item.salary
        binding.tvTitleCardView.text = item.jodDesc

        binding.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
            item.isChecked = isChecked
            viewModel.update(item)
        }
        binding.checkbox.isChecked = item.isChecked


    }
}