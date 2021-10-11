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
import com.example.moviepicker.data.QuestionHQQ
import com.example.moviepicker.databinding.FragmentHorrorQQBinding

class HorrorQQFragment : Fragment() {
    private lateinit var binding: FragmentHorrorQQBinding
    lateinit var hqqQuestions: QuestionHQQ
    private var questionIndex = 0
    private val maxNumberOfQuestions = 8
    lateinit var answers: ArrayList<String>
    private var score = 0

    private var questionshqq = arrayListOf(

        QuestionHQQ(
            "Who is the lead role in the movie World War Z ?",
            arrayListOf("Brad Pit", "Tom Cruise", "George Clooney")
        ),

        QuestionHQQ(
            "What game are they playing in the movie Ready or Not ?",
            arrayListOf("Hide and seek", "Tip the Can", "Eye Spy")
        ),

        QuestionHQQ(
            "is shaun of the dead a comedy or serious movie ?",
            arrayListOf("Comedy", "Don't know", "Serious")
        ),

        QuestionHQQ(
            "What comic book is constantine from ?",
            arrayListOf("Dc", "Marvel", "Manga")
        ),

        QuestionHQQ(
            "What famous wrestler is in the video game movie Doom ?",
            arrayListOf("The Rock", "John Cena", "Under Taker")
        ),

        QuestionHQQ(
            "Who is the main villian in the resident evil movie ?",
            arrayListOf("Umbrella", "Zombies", "Monsters")
        ),

        QuestionHQQ(
            "How many blade movies are there ?",
            arrayListOf("3", "2", "4")
        ),

        QuestionHQQ(
            "Who is the actress in Jennifers Body ?",
            arrayListOf("Megan Fox", "Scarlet Johansen", "Reese Witherspoon")
        ),

        QuestionHQQ(
            "What monster does Van Helsing turn into in the movie ?",
            arrayListOf("Ware wolf", "Vampire", "Monster")
        ),

        QuestionHQQ(
            "finish this horror movie Black .....",
            arrayListOf("Sheep", "Door", "Hole")
        ),


        )

    private fun setQuestion(){
        hqqQuestions = questionshqq[questionIndex]
        answers = ArrayList(hqqQuestions.HorrorAnswers2)
        answers.shuffle()
        Log.d("ANSWERGROUP", answers[0] + " " + answers[1] + " " + answers[2])
        Log.d("ANSWERREAL", hqqQuestions.HorrorAnswers2[0])
    }

    private fun randomQuestion(){
        questionshqq.shuffle()
        questionshqq.random()
        setQuestion()
    }

    private fun checkTheAnswer(answers: String){
        if (answers == hqqQuestions.HorrorAnswers2[0]){
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
        Navigation.findNavController(requireView()).navigate(R.id.action_horrorQQFragment_to_fragmentFiveStarHorrorQQ)
    }else if (score > 4){
        Navigation.findNavController(requireView()).navigate(R.id.action_horrorQQFragment_to_fragmentThreeStarHorrorQQ)
    }else{
        Navigation.findNavController(requireView()).navigate(R.id.action_horrorQQFragment_to_fragmentZeroStarHorrorQQ)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_horror_q_q, container, false)
        randomQuestion()
        binding.horrorGen2 = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.Horrorfour.setOnClickListener {
            checkTheAnswer(answers[0])
        }

        binding.Horrorfive.setOnClickListener {
            checkTheAnswer(answers[1])
        }

        binding.horrorsix.setOnClickListener {
            checkTheAnswer(answers[2])
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }



}