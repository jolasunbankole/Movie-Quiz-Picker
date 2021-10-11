package com.example.moviepicker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.moviepicker.data.QuestionAc
import com.example.moviepicker.databinding.FragmentActionQBinding

//Action movies questions and answers from 1990s button

class ActionQFragment : Fragment() {
    private lateinit var binding: FragmentActionQBinding
    lateinit var acQuestions: QuestionAc
    private var questionIndex = 0
    private val maxNumberOfQuestions = 10
    lateinit var answers: ArrayList<String>
    private var score = 0

    private var questionsAc = arrayListOf(
        QuestionAc(
            "From these actors, who was the most popular ?",
            arrayListOf("Arnold", "Will", "Bruce")
        ),
        QuestionAc(
            "Which Pierce Brosnan bond film was the best ?",
            arrayListOf("Golden eye", "tomorrow never dies", "The world is not enough")
        ),
        QuestionAc(
            "Which actor was a master of hand to hand combat ?",
            arrayListOf("Jackie chan", "Steven Seagal", "Van Damme")
        ),
        QuestionAc(
            "What actor played batman in Batman forever ?",
            arrayListOf("Val Kilmer", "George Clooney", "Michael Keaton")
        ),
        QuestionAc(
            "Who was the highest payed actor of the 90s ?",
            arrayListOf("Samuel Jackson", "Tom Hanks", "Bruce Willis")
        ),
        QuestionAc(
            "Who was the sexiest actor of 1990 ?",
            arrayListOf("Tom Cruise", "Patrick Swayze", "Nick Nolte")
        ),
        QuestionAc(
            "In the summer of 1990 what film grossed higher ?",
            arrayListOf("Total recall", "Back to the future 3", "Die hard 2")
        ),
        QuestionAc(
            "What pill did neo pick in the Matrix ?",
            arrayListOf("Red pill", "Black pill", "Blue pill")
        ),
        QuestionAc(
            "Who played the Riddler in Batman forever",
            arrayListOf("Jim Carrey", "Paul Dano", "Bruce Timm")
        ),
        QuestionAc(
            "How many hours was water world in the cinema ?",
            arrayListOf("2:56", "1:56", "2:30")
        ),
        QuestionAc(
            "What year was rush hour released ?",
            arrayListOf("1998", "1996", "1995")
        ),
        QuestionAc(
            "Independence day is a story about what ?",
            arrayListOf("Aliens", "Monsters", "Magic")
        ),
        QuestionAc(
            "Where in New York is Leon the professional from ?",
            arrayListOf("Little Italy", "Little china", "Little Mexico")
        ),
        QuestionAc(
            "What was the fifth element in the movie ?",
            arrayListOf("Girl", "fire", "earth")
        ),
        QuestionAc(
            "What gender was the main creature in the 1995 movie Species ?",
            arrayListOf("Female", "male", "none")
        ),

    )

    private fun setQuestions(){
        acQuestions = questionsAc[questionIndex]
        answers = ArrayList(acQuestions.ActionAnswers)
        answers.shuffle()
        Log.d("ANSWERQ", answers[0] + " " + answers[1] + " " + answers[2])
        Log.d("ANSWERA", acQuestions.ActionAnswers[0])

    }

    private fun randomQuestion(){
        questionsAc.shuffle()
        questionsAc.random()
        setQuestions()
    }

    private fun checkMyAnswer(answers:String){
        if (answers == acQuestions.ActionAnswers[0]) {
            score += 1
        }
        questionIndex++
        if  (questionIndex < maxNumberOfQuestions){
            setQuestions()
            binding.invalidateAll()
        }else{
            getTheScore()
        }
    }

    private fun getTheScore() = if (score >= 5){
        Navigation.findNavController(requireView()).navigate(R.id.action_actionQFragment_to_fragmentFiveStarActionQ)
    }else if (score > 3){
        Navigation.findNavController(requireView()).navigate(R.id.action_actionQFragment_to_action90FragmentQ)
    }else{
        Navigation.findNavController(requireView()).navigate(R.id.action_actionQFragment_to_fragmentZeroStarActionQ)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_action_q, container, false)
        randomQuestion()
        binding.ActionM.text
        binding.generator = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.Answerone.setOnClickListener {
            checkMyAnswer(answers[0])
        }
        binding.Answertwo.setOnClickListener {
            checkMyAnswer(answers[1])
        }
        binding.Answerthree.setOnClickListener {
            checkMyAnswer(answers[2])
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding
    }


}