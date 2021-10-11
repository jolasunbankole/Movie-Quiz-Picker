package com.example.moviepicker.comedy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviepicker.R
import com.example.moviepicker.databinding.FragmentComedyBinding


class ComedyFragment : Fragment() {
    private var _binding: FragmentComedyBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_comedy, container, false)
        binding.title5.text
        binding.title6.text
        binding.Year4.setOnClickListener {
            val action = ComedyFragmentDirections.actionComedyFragmentToComedyQFragment()
            findNavController().navigate(action)
        }
        binding.Year5.setOnClickListener {
            val action = ComedyFragmentDirections.actionComedyFragmentToComedyQQFragment()
            findNavController().navigate(action)
        }
        binding.Year6.setOnClickListener {
            val action = ComedyFragmentDirections.actionComedyFragmentToComedyQQQFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding
    }


}