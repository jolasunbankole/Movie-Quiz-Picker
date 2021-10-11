package com.example.moviepicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviepicker.databinding.FragmentActionMovieBinding


class ActionMovieFragment : Fragment() {
    private var _binding: FragmentActionMovieBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_action_movie, container, false)
        binding.title3.text
        binding.title4.text
        binding.Year1.setOnClickListener {
            val action = ActionMovieFragmentDirections.actionActionMovieFragmentToActionQFragment()
            findNavController().navigate(action)
        }
        binding.Year2.setOnClickListener {
            val action = ActionMovieFragmentDirections.actionActionMovieFragmentToActionQQFragment()
            findNavController().navigate(action)
        }
        binding.Year3.setOnClickListener {
            val action = ActionMovieFragmentDirections.actionActionMovieFragmentToActionQQQFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }


}