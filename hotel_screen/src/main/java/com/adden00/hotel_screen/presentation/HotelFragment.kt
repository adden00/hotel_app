package com.adden00.hotel_screen.presentation

import android.annotation.SuppressLint
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
import com.adden00.core.R
import com.adden00.core.ViewModelFactory
import com.adden00.core.common_adapters.FlexboxAdapter
import com.adden00.core.common_adapters.SliderPhotoAdapter
import com.adden00.hotel_screen.databinding.FragmentHotelBinding
import com.adden00.hotel_screen.di.HotelComponentProvider
import com.adden00.hotel_screen.presentation.mvi.HotelEvent
import com.adden00.hotel_screen.presentation.mvi.HotelState
import com.google.android.flexbox.FlexboxLayoutManager
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class HotelFragment : Fragment() {
    private var _binding: FragmentHotelBinding? = null
    private val binding: FragmentHotelBinding get() = _binding!!

    private val sliderAdapter by lazy {
        SliderPhotoAdapter()
    }

    private val facilitiesAdapter by lazy {
        FlexboxAdapter()
    }


    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: HotelViewModel by viewModels { viewModelFactory }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as HotelComponentProvider).provideHotelComponent()
            .inject(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHotelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUi()
        subscribeOnState()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun subscribeOnState() {
        viewModel.hotelScreenState
            .flowWithLifecycle(lifecycle)
            .onEach(::render)
            .launchIn(lifecycleScope)
    }

    @SuppressLint("SetTextI18n")
    private fun render(state: HotelState) {
        when (state) {
            is HotelState.Error -> {
                binding.swipeRefresh.isRefreshing = false
                binding.includedHotelInfoLayout.visibility = View.GONE
                binding.pBar.visibility = View.GONE
                Toast.makeText(
                    requireContext(),
                    requireContext().getString(R.string.loading_error),
                    Toast.LENGTH_SHORT
                ).show()
            }

            is HotelState.Init -> {
                binding.swipeRefresh.isRefreshing = false
                binding.includedHotelInfoLayout.visibility = View.GONE
                binding.pBar.visibility = View.GONE
            }

            is HotelState.Loaded -> {
                binding.swipeRefresh.isRefreshing = false
                binding.includedHotelInfoLayout.visibility = View.VISIBLE
                binding.pBar.visibility = View.GONE
                binding.includedHotelInfo.tvName.text = state.hotelInfo.name
                binding.includedHotelInfo.tvAddress.text = state.hotelInfo.address
                binding.includedHotelInfo.tvPrice.text = "от ${state.hotelInfo.minimalPrice} ₽"
                binding.includedHotelInfo.tvPriceType.text = state.hotelInfo.priceType
                binding.includedHotelInfo.tvFacilities.text =
                    state.hotelInfo.hotelDetailsDescription
                binding.includedHotelInfo.tvRating.text =
                    "${state.hotelInfo.rating} ${state.hotelInfo.ratingName}"
                sliderAdapter.submitList(state.hotelInfo.imageUrls)
                facilitiesAdapter.submitList(state.hotelInfo.hotelDetailsPeculiarities)
            }

            is HotelState.Loading -> {
                binding.includedHotelInfoLayout.visibility = View.GONE
                binding.swipeRefresh.isRefreshing = false
                binding.pBar.visibility = View.VISIBLE
            }
        }
    }

    private fun setUi() {
        binding.includedHotelInfo.slider.adapter = sliderAdapter
        binding.includedHotelInfo.rcFacilities.adapter = facilitiesAdapter
        binding.includedHotelInfo.rcFacilities.layoutManager =
            FlexboxLayoutManager(requireContext())
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.newEvent(HotelEvent.LoadHotelInfo)
        }
        binding.includedHotelInfo.btnSelectRoom.setOnClickListener {
            findNavController().navigate(R.id.action_hotelFragment_to_roomsFragment)
        }
    }
}