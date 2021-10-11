package com.example.moviepicker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.moviepicker.data.QuestionActw
import com.example.moviepicker.databinding.FragmentActionQQBinding

//Action questions for 2001 plus
class ActionQQFragment : Fragment() {
    private lateinit var binding: FragmentActionQQBinding
    lateinit var accQuestions: QuestionActw
    private var questionIndex = 0
    private val maxNumberOfQuestions = 9
    lateinit var answers: ArrayList<String>
    private var score = 0


    private var questionActw = arrayListOf(
        QuestionActw(
            "In what year was the first fast and furious movie ?",
            arrayListOf("2001", "2005", "2006")
        ),
        QuestionActw(
            "How many lord of rings movie where there in the early 2000s ?",
            arrayListOf("2001", "2003", "2006")
        ),
        QuestionActw(
            "What did the rock like to hold in the movie walking tall ?",
            arrayListOf("Block of timber", "Metal bat", "Shield")
        ),
        QuestionActw(
            "In the 2009 movie crank what is the main character searching for ? ",
            arrayListOf("Heart", "A Girl", "Formula" )
        ),
        QuestionActw(
            "Where was the 300 troops that fought thousands of persian from ?",
            arrayListOf("Greece", "Spain", "Italy")
        ),
        QuestionActw(
            "  In the early 200s StarTrack movie where does it rank in as a release",
            arrayListOf("2002", "2005", "2008")
        ),
        QuestionActw(
            "How many black belts did IP man fight in the movie ?",
            arrayListOf("10", "20", "5")
        ),
        QuestionActw(
            "What torcher method did the punisher use on a goon in his apartment ?",
            arrayListOf("Ice pop", "2000 Degree flame", "Knives")
        ),
        QuestionActw(
            "Who played wolverine in the 2000 Xmen movie ?",
            arrayListOf("Hugh Jackmen", "Ryan Renold", "Tom holland")
        ),
        QuestionActw(
            "What year does MJ kiss spider man ?",
            arrayListOf("2002", "2009", "2021")
        ),


    )

    private fun setQuestion(){
        accQuestions = questionActw[questionIndex]
        answers = ArrayList(accQuestions.ActionAnswers2)
        answers.shuffle()
        Log.d("ANSWERGROUP", answers[0] + " " + answers[1] + " " + answers[2])
        Log.d("ANSWERREAL", accQuestions.ActionAnswers2[0])
    }

    private fun randomQuestion(){
        questionActw.random()
        questionActw.shuffle()
        setQuestion()
    }

    private fun checkTheAnswers(answers: String){
        if (answers == accQuestions.ActionAnswers2[0]){
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

    private fun getTheScore() = if (score >= 5){
        Navigation.findNavController(requireView()).navigate(R.id.action_actionQQFragment_to_fragmentFiveStarActionQQ)
    }else if (score > 3){
        Navigation.findNavController(requireView()).navigate(R.id.action_actionQQFragment_to_fragmentThreeStarActionQQ)
    }else{
        Navigation.findNavController(requireView()).navigate(R.id.action_actionQQFragment_to_fragmentZeroStarsActionQQ)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_action_q_q, container, false)
        randomQuestion()
        binding.ActionMM.text
        binding.generator2 = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.AnswerFour.setOnClickListener {
            checkTheAnswers(answers[0])
        }
        binding.AnswerFive.setOnClickListener {
            checkTheAnswers(answers[1])
        }
        binding.AnswerSix.setOnClickListener {
            checkTheAnswers(answers[2])
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding
    }


}


