package com.adden00.testtaskeffectivemobile.features.booking_screen.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.adden00.testtaskeffectivemobile.app.di.ui.DaggerBookingComponent
import com.adden00.testtaskeffectivemobile.app.getAppComponent
import com.adden00.testtaskeffectivemobile.core.ViewModelFactory
import com.adden00.testtaskeffectivemobile.core.delegate_utills.BaseAdapter
import com.adden00.testtaskeffectivemobile.databinding.FragmentBookingBinding
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.adapters.BookingPriceAdapter
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.adapters.CustomerContactsAdapter
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.adapters.CustomerDataAdapter
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.adapters.HotelAddressAdapter
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.adapters.HotelDetailsAdapter
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.models.TouristCollapseType
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.models.createDelegateList
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.mvi.BookingEffect
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.mvi.BookingEvent
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.mvi.BookingState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


class BookingFragment : Fragment() {

    private var _binding: FragmentBookingBinding? = null
    private val binding: FragmentBookingBinding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: BookingViewModel by viewModels { viewModelFactory }

    private val adapter by lazy {
        BaseAdapter()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerBookingComponent.factory().create(requireContext().getAppComponent()).inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUi()
        subscribeOnState()
    }

    private fun subscribeOnState() {
        viewModel.bookingScreenState
            .flowWithLifecycle(lifecycle)
            .onEach(::render)
            .launchIn(lifecycleScope)

        viewModel.screenEffects
            .flowWithLifecycle(lifecycle)
            .onEach(::launchEffect)
            .launchIn(lifecycleScope)
    }

    private fun render(state: BookingState) {
        state.bookingInfo?.let {
            adapter.submitList(it.createDelegateList())
        }
    }

    private fun launchEffect(effect: BookingEffect) {
        when (effect) {
            is BookingEffect.Init -> Unit
            is BookingEffect.ShowError -> {
                Toast.makeText(requireContext(), "Error while loading!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setUi() {
        binding.rcAllList.adapter = adapter.apply {
            addDelegate(HotelAddressAdapter())
            addDelegate(HotelDetailsAdapter())
            addDelegate(CustomerContactsAdapter())
            addDelegate(CustomerDataAdapter {
                when (it) {
                    is TouristCollapseType.Collapsed -> viewModel.newEvent(
                        BookingEvent.ExpandTourist(
                            it.touristNumber
                        )
                    )

                    is TouristCollapseType.Expanded -> viewModel.newEvent(
                        BookingEvent.CollapseTourist(
                            it.touristNumber
                        )
                    )

                    is TouristCollapseType.Add -> viewModel.newEvent(BookingEvent.AddTourist)
                }
            })
            addDelegate(BookingPriceAdapter())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}