package com.example.moviepicker.horror

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviepicker.R
import com.example.moviepicker.databinding.FragmentHorrorBinding


class HorrorFragment : Fragment() {
    private var _binding: FragmentHorrorBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_horror, container, false)
        binding.Horror1.text
        binding.Horror2.text
        binding.Year7.setOnClickListener {
            val action = HorrorFragmentDirections.actionHorrorFragmentToHorrorQFragment()
            findNavController().navigate(action)
        }
        binding.Year8.setOnClickListener {
            val action = HorrorFragmentDirections.actionHorrorFragmentToHorrorQQFragment()
            findNavController().navigate(action)
        }
        binding.Year9.setOnClickListener {
            val action = HorrorFragmentDirections.actionHorrorFragmentToHorrorQQQFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }



}