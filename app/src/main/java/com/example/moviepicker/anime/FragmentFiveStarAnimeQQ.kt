package com.example.moviepicker.anime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.moviepicker.R
import com.example.moviepicker.databinding.FragmentFiveStarAnimeQQBinding


class FragmentFiveStarAnimeQQ : Fragment() {
    private var _binding: FragmentFiveStarAnimeQQBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_five_star_anime_q_q, container, false)
        return binding.root
    }


    override fun onDestroy(){
        super.onDestroy()
        _binding
    }


}


