package com.example.moviepicker.anime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviepicker.R
import com.example.moviepicker.databinding.FragmentAnimeBinding

class AnimeFragment : Fragment() {
    private var _binding: FragmentAnimeBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_anime, container, false)

        binding.Year10.setOnClickListener {
            val action = AnimeFragmentDirections.actionAnimeFragmentToAnimeQFragment()
            findNavController().navigate(action)
        }
        binding.Year11.setOnClickListener {
            val action = AnimeFragmentDirections.actionAnimeFragmentToAnimeQQFragment()
            findNavController().navigate(action)
        }
        binding.Year12.setOnClickListener {
            val action = AnimeFragmentDirections.actionAnimeFragmentToAnimeQQQFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }


}