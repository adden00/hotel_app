package com.adden00.booking_screen.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adden00.booking_screen.databinding.BookingCustomerInfoItemBinding
import com.adden00.booking_screen.presentation.models.delegate_models.CustomerContactsDelegateItem
import com.adden00.core.delegate_utills.AdapterDelegate
import com.adden00.core.delegate_utills.DelegateItem
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.slots.PredefinedSlots
import ru.tinkoff.decoro.watchers.MaskFormatWatcher

class CustomerContactsAdapter(
//    private val resultProvider: (ContactsResultModel) -> Unit
) :
    AdapterDelegate {

    inner class ItemHolder(private val binding: BookingCustomerInfoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun render() {
            val phoneMask = MaskImpl.createTerminated(PredefinedSlots.RUS_PHONE_NUMBER)
            binding.edPhone.addTextChangedListener(MaskFormatWatcher(phoneMask))

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