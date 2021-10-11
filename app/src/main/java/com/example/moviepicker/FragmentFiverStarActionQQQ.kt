package com.example.moviepicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.moviepicker.databinding.FragmentFiverStarActionQQQBinding


class FragmentFiverStarActionQQQ : Fragment() {
    private var _binding: FragmentFiverStarActionQQQBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_fiver_star_action_q_q_q, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding
    }


}