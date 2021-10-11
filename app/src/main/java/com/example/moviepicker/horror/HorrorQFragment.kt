package com.example.moviepicker.horror

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.moviepicker.R
import com.example.moviepicker.data.QuestionHQ
import com.example.moviepicker.databinding.FragmentHorrorQBinding


class HorrorQFragment : Fragment() {
    private lateinit var binding: FragmentHorrorQBinding
    lateinit var hqQuestions: QuestionHQ
    private var questionIndex = 0
    private val maxNumberOfQuestions = 9
    lateinit var answers: ArrayList<String>
    private var score = 0

    private var questionshq = arrayListOf(
        QuestionHQ(
            "What was the candymans calling card ?",
            arrayListOf("Bees", "Wasps", "Flys")
        ),

        QuestionHQ(
            "Did Buffy the vampire slayer, get her own film ?",
            arrayListOf("Yes", "No", "Maybe")
        ),

        QuestionHQ(
            "How many candyman films are there now ?",
            arrayListOf("4", "3", "1")
        ),

        QuestionHQ(
            "What was the kids power in the sixth sense ?",
            arrayListOf("Sees dead people", "Can fly", "Heat vision")
        ),

        QuestionHQ(
            "Where was the Ring movie first created ?",
            arrayListOf("Japan", "America", "India")
        ),

        QuestionHQ(
            "What Friends actress was in the 1990s horror movie flop leprechaun ?",
            arrayListOf("Jennifer Aniston", "Courteney Cox", "Lisa Kudrow")
        ),

        QuestionHQ(
            "What objects does the hellraiser have in his face ?",
            arrayListOf("Nails", "Branches", "plastic")
        ),

        QuestionHQ(
            "What comic book franchise is Spawn from ?",
            arrayListOf("Dc", "Marvel", "Manga")
        ),

        QuestionHQ(
            "What does the DarkMan have surrounding his body ?",
            arrayListOf("Bandages", "Metal armor", "Latex")
        ),

        QuestionHQ(
            "What evil is placed in the Dusk to Dawn movie ?",
            arrayListOf("Vampires", "Demons", "Hell Spawn")
        ),

    )

    private fun setQuestion(){
        hqQuestions = questionshq[questionIndex]
        answers = ArrayList(hqQuestions.HorrorAnswers)
        answers.shuffle()
        Log.d("ANSWERGROUP", answers[0] + " " + answers[1] + " " + answers[2])
        Log.d("ANSWERREAL", hqQuestions.HorrorAnswers[0])
    }

    private fun randomQuestion(){
        questionshq.shuffle()
        questionshq.random()
        setQuestion()
    }

    private fun checkTheAnswer(answers: String){
        if (answers == hqQuestions.HorrorAnswers[0]){
            score += 1
        }
        questionIndex++
        if(questionIndex < maxNumberOfQuestions){
            setQuestion()
            binding.invalidateAll()
        }else{
            getTheScore()
        }
    }

    private fun getTheScore() = if (score >= 8){
        Navigation.findNavController(requireView()).navigate(R.id.action_horrorQFragment_to_fragmentFiveStarHorrorQ)
    }else if (score > 4){
        Navigation.findNavController(requireView()).navigate(R.id.action_horrorQFragment_to_fragmentThreeStarHorrorQ)
    }else{
        Navigation.findNavController(requireView()).navigate(R.id.action_horrorQFragment_to_fragmentZeroStarHorrorQ)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_horror_q, container, false)
        randomQuestion()
        binding.horrorGen = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.Horrorone.setOnClickListener {
            checkTheAnswer(answers[0])
        }

        binding.Horrortwo.setOnClickListener {
            checkTheAnswer(answers[1])
        }

        binding.horrorthree.setOnClickListener {
            checkTheAnswer(answers[2])
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }



}