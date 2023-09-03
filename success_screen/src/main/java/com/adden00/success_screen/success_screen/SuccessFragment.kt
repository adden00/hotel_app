package com.adden00.success_screen.success_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.adden00.core.R
import com.adden00.success_screen.databinding.FragmentSuccessBinding

class SuccessFragment: Fragment() {

    private var _binding: FragmentSuccessBinding? = null
    private val binding: FragmentSuccessBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuccessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUi()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUi() {
        binding.btnSuper.setOnClickListener {
            findNavController().navigate(R.id.action_successFragment_to_hotelFragment)
        }
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}