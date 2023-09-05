package com.adden00.rooms_screen.presentation

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
import com.adden00.rooms_screen.databinding.FragmentRoomsBinding
import com.adden00.rooms_screen.di.RoomsComponentProvider
import com.adden00.rooms_screen.presentation.adapters.RoomsAdapter
import com.adden00.rooms_screen.presentation.mvi.RoomsEffect
import com.adden00.rooms_screen.presentation.mvi.RoomsEvent
import com.adden00.rooms_screen.presentation.mvi.RoomsState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


class RoomsFragment : Fragment() {
    private var _binding: FragmentRoomsBinding? = null
    private val binding: FragmentRoomsBinding get() = _binding!!
    private val roomsAdapter by lazy {
        RoomsAdapter {
            findNavController().navigate(R.id.action_roomsFragment_to_bookingFragment)
        }
    }

    @Inject
    lateinit var viewModelFactory: com.adden00.core.ViewModelFactory
    private val viewModel: RoomsViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().applicationContext as RoomsComponentProvider).provideRoomsComponent()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRoomsBinding.inflate(inflater, container, false)
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
        viewModel.roomsScreenState
            .flowWithLifecycle(lifecycle)
            .onEach(::render)
            .launchIn(lifecycleScope)

        viewModel.screenEffects
            .flowWithLifecycle(lifecycle)
            .onEach(::handleEffect)
            .launchIn(lifecycleScope)
    }

    private fun render(state: RoomsState) {
        binding.swipeRefresh.isRefreshing = false
        binding.pBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE
        roomsAdapter.submitList(state.rooms)
    }

    private fun handleEffect(effect: RoomsEffect) {
        when (effect) {
            is RoomsEffect.Init -> Unit
            is RoomsEffect.ShowError -> {
                Toast.makeText(
                    requireContext(),
                    requireContext().getString(R.string.loading_error),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun setUi() {
        binding.rcRooms.adapter = roomsAdapter
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.newEvent(RoomsEvent.LoadRooms)
        }
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}