package com.example.moviepicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.moviepicker.databinding.FragmentZeroStarActionQQQBinding


class FragmentZeroStarActionQQQ : Fragment() {
    private var _binding: FragmentZeroStarActionQQQBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_zero_star_action_q_q_q, container, false)
        return binding.root
    }


}