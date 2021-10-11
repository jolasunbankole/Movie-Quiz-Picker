package com.example.moviepicker.comedy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.moviepicker.R
import com.example.moviepicker.databinding.FragmentFiveStarComedyQQQBinding

class FragmentFiveStarComedyQQQ : Fragment() {
    private var _binding: FragmentFiveStarComedyQQQBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_five_star_comedy_q_q_q, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding
    }


}