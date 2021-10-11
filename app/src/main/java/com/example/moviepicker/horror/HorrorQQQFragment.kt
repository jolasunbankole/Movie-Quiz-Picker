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
import com.example.moviepicker.data.QuestionHQQQ
import com.example.moviepicker.databinding.FragmentHorrorQQQBinding

class HorrorQQQFragment : Fragment() {
    private lateinit var binding: FragmentHorrorQQQBinding
    lateinit var hqqqQuestions: QuestionHQQQ
    private var questionIndex = 0
    private val maxNumberOfQuestions = 9
    lateinit var answers: ArrayList<String>
    private var score = 0

    private var questionshqqq = arrayListOf(
        QuestionHQQQ(
            "Who did the mother in Ma, do to the kids at the party ?",
            arrayListOf("Trapped them", "Killed them", "Kidnapped them")
        ),

        QuestionHQQQ(
            "how many personality did the actore in split have ?",
            arrayListOf("24", "5", "30")
        ),

        QuestionHQQQ(
            "Who are the passengers in the train to Busan running from ?",
            arrayListOf("Zombies", "Ware wolves", "Vampires")
        ),

        QuestionHQQQ(
            "What famous real life game was made into a horror movie in 2019 ?",
            arrayListOf("Escape room", "Hide and seek", "Red light Green light")
        ),

        QuestionHQQQ(
            "What did the zombies in World War Z not attack ?",
            arrayListOf("The sick", "The Cripple", "The Blind")
        ),

        QuestionHQQQ(
            "What is ZombieLands sub genre ?",
            arrayListOf("Comedy", "Action", "Romance")
        ),

        QuestionHQQQ(
            "Did anyone in the 2019 Midsommar survive ?",
            arrayListOf("Yes", "No", "Don't know")
        ),

        QuestionHQQQ(
            "What was the evil called in the 2012 movie Sinister",
            arrayListOf("Boogie man", "Scare Crow", "Mandark")
        ),

        QuestionHQQQ(
            "What countries folk lore is the La LLorona from ?",
            arrayListOf("Spanish", "Austrian", "America")
        ),

        QuestionHQQQ(
            "What was the clown IT actually known to be ?",
            arrayListOf("Alien", "Vampire", "Spiders")
        ),

        )

    private fun setQuestion(){
        hqqqQuestions = questionshqqq[questionIndex]
        answers = ArrayList(hqqqQuestions.HorrorAnswers3)
        answers.shuffle()
        Log.d("ANSWERGROUP", answers[0] + " " + answers[1] + " " + answers[2])
        Log.d("ANSWERREAL", hqqqQuestions.HorrorAnswers3[0])
    }

    private fun randomQuestion(){
        questionshqqq.shuffle()
        questionshqqq.random()
        setQuestion()
    }

    private fun checkTheAnswer(answers: String){
        if (answers == hqqqQuestions.HorrorAnswers3[0]){
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
        Navigation.findNavController(requireView()).navigate(R.id.action_horrorQQQFragment_to_fragmentFiveStarHorrorQQQ)
    }else if (score > 4){
        Navigation.findNavController(requireView()).navigate(R.id.action_horrorQQQFragment_to_fragmentThreeStarHorrorQQQ)
    }else{
        Navigation.findNavController(requireView()).navigate(R.id.action_horrorQQQFragment_to_fragmentTZeroStarHorrorQQQ)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_horror_q_q_q, container, false)
        randomQuestion()
        binding.horrorGen3 = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.Horrorseven.setOnClickListener {
            checkTheAnswer(answers[0])
        }

        binding.Horroreight.setOnClickListener {
            checkTheAnswer(answers[1])
        }

        binding.horrornine.setOnClickListener {
            checkTheAnswer(answers[2])
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }


}
