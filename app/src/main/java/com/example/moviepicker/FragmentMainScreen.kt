package com.example.moviepicker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.moviepicker.databinding.FragmentMainScreenBinding

class FragmentMainScreen : Fragment() {
    private var _binding: FragmentMainScreenBinding? = null
    private  val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_screen, container, false)
        binding.ActionBtn.setOnClickListener {
            val action = FragmentMainScreenDirections.actionFragmentMainScreen2ToActionMovieFragment()
            findNavController().navigate(action)
        }
        binding.ComedyBtn.setOnClickListener {
            val action = FragmentMainScreenDirections.actionFragmentMainScreen2ToComedyFragment()
            findNavController().navigate(action)
        }
        binding.HorrorBtn.setOnClickListener {
            val action = FragmentMainScreenDirections.actionFragmentMainScreen2ToHorrorFragment()
            findNavController().navigate(action)
        }
        binding.AnimeBtn.setOnClickListener {
            val action = FragmentMainScreenDirections.actionFragmentMainScreen2ToAnimeFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding
    }


}