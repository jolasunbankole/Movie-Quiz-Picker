package com.example.moviepicker.horror

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.moviepicker.R

import com.example.moviepicker.databinding.FragmentZeroStarHorrorQBinding

class FragmentZeroStarHorrorQ : Fragment() {
    private var _binding: FragmentZeroStarHorrorQBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_zero_star_horror_q, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding
    }
}