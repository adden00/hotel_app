package com.adden00.booking_screen.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.adden00.booking_screen.databinding.BookingTouristItemBinding
import com.adden00.booking_screen.presentation.models.TouristCollapseType
import com.adden00.booking_screen.presentation.models.delegate_models.CustomerDataDelegateItem
import com.adden00.core.R
import com.adden00.core.delegate_utills.AdapterDelegate
import com.adden00.core.delegate_utills.DelegateItem


class CustomerDataAdapter(private val onTouristButtonClick: (TouristCollapseType) -> Unit) :
    AdapterDelegate {

    inner class ItemHolder(private val binding: BookingTouristItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun render(item: CustomerDataDelegateItem) {
            if (item.touristNum != -1)
                binding.tvTouristNumber.text =
                    item.touristNum.toString() + binding.root.context.getString(R.string.tourist)
            else
                binding.tvTouristNumber.text = binding.root.context.getString(R.string.add_tourist)

            binding.imageView.setOnClickListener {
                onTouristButtonClick(item.collapseType)
            }

            when (item.collapseType) {
                is TouristCollapseType.Collapsed -> {
                    binding.edName.visibility = View.GONE
                    binding.edBirthday.visibility = View.GONE
                    binding.edCitizen.visibility = View.GONE
                    binding.edSurname.visibility = View.GONE
                    binding.edPassportDate.visibility = View.GONE
                    binding.edPassportNumber.visibility = View.GONE
                    binding.imageView.setImageDrawable(
                        AppCompatResources.getDrawable(
                            binding.root.context,
                            R.drawable.ic_tourist_collapsed
                        )
                    )
                }

                is TouristCollapseType.Expanded -> {
                    binding.edName.visibility = View.VISIBLE
                    binding.edBirthday.visibility = View.VISIBLE
                    binding.edCitizen.visibility = View.VISIBLE
                    binding.edSurname.visibility = View.VISIBLE
                    binding.edPassportDate.visibility = View.VISIBLE
                    binding.edPassportNumber.visibility = View.VISIBLE

                    binding.imageView.setImageDrawable(
                        AppCompatResources.getDrawable(
                            binding.root.context,
                            R.drawable.ic_tousist_expaned
                        )
                    )
                }

                is TouristCollapseType.Add -> {
                    binding.edName.visibility = View.GONE
                    binding.edBirthday.visibility = View.GONE
                    binding.edCitizen.visibility = View.GONE
                    binding.edSurname.visibility = View.GONE
                    binding.edPassportDate.visibility = View.GONE
                    binding.edPassportNumber.visibility = View.GONE
                    binding.imageView.setImageDrawable(
                        AppCompatResources.getDrawable(
                            binding.root.context,
                            R.drawable.ic_tourist_add
                        )
                    )
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        ItemHolder(
            BookingTouristItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: DelegateItem) {
        (holder as ItemHolder).render(item as CustomerDataDelegateItem)
    }

    override fun isOfViewType(item: DelegateItem): Boolean =
        item is CustomerDataDelegateItem
}