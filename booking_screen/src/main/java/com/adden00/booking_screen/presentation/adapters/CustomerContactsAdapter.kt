package com.adden00.booking_screen.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.adden00.booking_screen.databinding.BookingCustomerInfoItemBinding
import com.adden00.booking_screen.presentation.models.delegate_models.CustomerContactsDelegateItem
import com.adden00.booking_screen.presentation.models.result_models.ContactsResultModel
import com.adden00.core.R
import com.adden00.core.delegate_utills.AdapterDelegate
import com.adden00.core.delegate_utills.DelegateItem
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.slots.PredefinedSlots
import ru.tinkoff.decoro.watchers.MaskFormatWatcher

class CustomerContactsAdapter :
    AdapterDelegate {
    private var currentTextFields = ContactsResultModel()
    fun fieldsAreFilled(): Boolean =
        currentTextFields.email != null && currentTextFields.phone != null

    inner class ItemHolder(private val binding: BookingCustomerInfoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        @SuppressLint("SetTextI18n")
        fun render() {
            val phoneMask = MaskImpl.createTerminated(PredefinedSlots.RUS_PHONE_NUMBER)
            binding.edPhone.addTextChangedListener(MaskFormatWatcher(phoneMask))
            binding.edPhone.addTextChangedListener {
                binding.edPhone.background =
                    if (it?.toString()?.length == 18) AppCompatResources.getDrawable(
                        binding.root.context, R.drawable.edit_text_bg
                    )
                    else AppCompatResources.getDrawable(
                        binding.root.context, R.drawable.edit_text_bg_red
                    )
                currentTextFields = currentTextFields.copy(phone = it?.toString())

            }
            binding.edMail.addTextChangedListener {
                binding.edMail.background = if (it?.toString()
                        ?.matches(
                            Regex(
                                "^[A-Z0-9._%+-]+@[A-Z0-9-]+.+.[A-Z]{2,4}\$",
                                RegexOption.IGNORE_CASE
                            )
                        ) == true
                ) AppCompatResources.getDrawable(
                    binding.root.context,
                    R.drawable.edit_text_bg
                ) else AppCompatResources.getDrawable(
                    binding.root.context,
                    R.drawable.edit_text_bg_red
                )
                currentTextFields = currentTextFields.copy(email = it?.toString())
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