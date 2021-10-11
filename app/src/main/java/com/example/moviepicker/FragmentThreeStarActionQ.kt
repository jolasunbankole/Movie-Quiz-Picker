package com.example.moviepicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.moviepicker.databinding.FragmentThreeStarActionQBinding


//Questions for action movies in the 90s with movies to pick from 0 to 10 star
class FragmentThreeStarActionQ : Fragment() {
    private var _binding: FragmentThreeStarActionQBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_three_star_action_q, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding
    }


}