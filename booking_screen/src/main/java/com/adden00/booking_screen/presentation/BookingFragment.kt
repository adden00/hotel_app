package com.adden00.booking_screen.presentation

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
import androidx.navigation.fragment.findNavController
import com.adden00.booking_screen.databinding.FragmentBookingBinding
import com.adden00.booking_screen.di.BookingComponentProvider
import com.adden00.booking_screen.presentation.adapters.BookingPriceAdapter
import com.adden00.booking_screen.presentation.adapters.CustomerContactsAdapter
import com.adden00.booking_screen.presentation.adapters.CustomerDataAdapter
import com.adden00.booking_screen.presentation.adapters.HotelAddressAdapter
import com.adden00.booking_screen.presentation.adapters.HotelDetailsAdapter
import com.adden00.booking_screen.presentation.models.TouristCollapseType
import com.adden00.booking_screen.presentation.models.createDelegateList
import com.adden00.booking_screen.presentation.mvi.BookingEffect
import com.adden00.booking_screen.presentation.mvi.BookingEvent
import com.adden00.booking_screen.presentation.mvi.BookingState
import com.adden00.core.R
import com.adden00.core.ViewModelFactory
import com.adden00.core.delegate_utills.BaseAdapter
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
        BaseAdapter().apply {
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as BookingComponentProvider).provideBookingComponent()
            .inject(this)
//        DaggerBookingComponent.factory().create().inject(this)
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
        binding.pBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE

        state.bookingInfo?.let {
            adapter.submitList(it.createDelegateList())
        }
    }

    private fun launchEffect(effect: BookingEffect) {
        when (effect) {
            is BookingEffect.Init -> Unit
            is BookingEffect.ShowError -> {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.loading_error),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun setUi() {
        binding.rcAllList.adapter = adapter
        binding.btnPay.setOnClickListener {
            if (checkFields())
                findNavController().navigate(R.id.action_bookingFragment_to_successFragment)
            else
                Toast.makeText(requireContext(), "Заполните все поля!", Toast.LENGTH_SHORT).show()
        }
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun checkFields(): Boolean {
        adapter.getAdapters().forEach {
            if (it is CustomerContactsAdapter && !it.fieldsAreFilled())
                return false
            if (it is CustomerDataAdapter && !it.fieldsAreFilled())
                return false
        }
        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}