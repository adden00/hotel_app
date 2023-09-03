package com.adden00.booking_screen.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View.OnFocusChangeListener
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.adden00.booking_screen.databinding.BookingCustomerInfoItemBinding
import com.adden00.booking_screen.presentation.models.delegate_models.CustomerContactsDelegateItem
import com.adden00.core.R
import com.adden00.core.delegate_utills.AdapterDelegate
import com.adden00.core.delegate_utills.DelegateItem

class CustomerContactsAdapter(
//    private val resultProvider: (ContactsResultModel) -> Unit
) :
    AdapterDelegate {

    inner class ItemHolder(private val binding: BookingCustomerInfoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun render() {
            binding.edMail.onFocusChangeListener =
                OnFocusChangeListener { _, isFocused ->
                    if ((!isFocused) and (binding.edMail.text.toString() == "")) {
                        binding.edMail.background = AppCompatResources.getDrawable(
                            binding.root.context,
                            R.drawable.edit_text_bg_red
                        )
                    } else {

//                        if (!binding.edPhone.text.isNullOrEmpty()) {
//                            resultProvider(
//                                ContactsResultModel(
//                                    binding.edMail.text.toString(),
//                                    binding.edPhone.text.toString()
//                                )
//                            )
//                        }

                        binding.edMail.background = AppCompatResources.getDrawable(
                            binding.root.context,
                            R.drawable.edit_text_bg
                        )
                    }
                }
            binding.edPhone.onFocusChangeListener =
                OnFocusChangeListener { _, isFocused ->
                    if ((!isFocused) and (binding.edMail.text.toString() == "")) {

                        binding.edPhone.background = AppCompatResources.getDrawable(
                            binding.root.context,
                            R.drawable.edit_text_bg_red
                        )
                    } else {
//                        if (!binding.edMail.text.isNullOrEmpty()) {
//                            resultProvider(
//                                ContactsResultModel(
//                                    binding.edMail.text.toString(),
//                                    binding.edPhone.text.toString()
//                                )
//                            )
//                        }
                        binding.edPhone.background = AppCompatResources.getDrawable(
                            binding.root.context,
                            R.drawable.edit_text_bg
                        )
                    }
                }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        ItemHolder(
            BookingCustomerInfoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: DelegateItem) {
        (holder as ItemHolder).render()
    }

    override fun isOfViewType(item: DelegateItem): Boolean =
        item is CustomerContactsDelegateItem
}