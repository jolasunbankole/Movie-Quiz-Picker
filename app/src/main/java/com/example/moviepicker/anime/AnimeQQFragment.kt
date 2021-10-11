package com.example.moviepicker.anime

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.moviepicker.R
import com.example.moviepicker.data.QuestionAQQ
import com.example.moviepicker.databinding.FragmentAnimeQQBinding


class AnimeQQFragment : Fragment() {
    private lateinit var binding: FragmentAnimeQQBinding
    lateinit var aqqQuestions: QuestionAQQ
    private var questionIndex = 0
    private val maxNumberOfQuestions = 9
    lateinit var answers: ArrayList<String>
    private var score = 0


    private var questionsaqq = arrayListOf(
        QuestionAQQ(
            "How many naruto movies where there before 2010 ?",
            arrayListOf("6", "7", "5")
        ),

        QuestionAQQ(
            "What type of fish was ponyo ?",
            arrayListOf("Gold fish", "mermaid", "Shark")
        ),

        QuestionAQQ(
            "What other anime has a similar style to metropolis ?",
            arrayListOf("Astro boy", "Guran Laggan", "Kill la Kill")
        ),

        QuestionAQQ(
            "in howls moving castle, what is howl ?",
            arrayListOf("A wizard", "A killer", "A knight")
        ),

        QuestionAQQ(
            "Was Paprika real ?",
            arrayListOf("Maybe", "Yes", "No")
        ),

        QuestionAQQ(
            "What is the movie RedLine about ?",
            arrayListOf("Car racing", "Drugs", "Crime")
        ),

        QuestionAQQ(
            "Who played the ghost in the shell main character",
            arrayListOf("Scarlet Johansan", "Britney spear", "Cardi B")
        ),

        QuestionAQQ(
            "How many yu-gi-uh films are there ?",
            arrayListOf("3", "5", "2")
        ),

        QuestionAQQ(
            "What is evangelon about ?",
            arrayListOf("Robots and monsters", "Robots and humans", "Robots and demons")
        ),

        QuestionAQQ(
            "Was dragon ball turned into a live action film ?",
            arrayListOf("Yes", "maybe", "no")
        ),
    )

    private fun setQuestion(){
        aqqQuestions = questionsaqq[questionIndex]
        answers = ArrayList(aqqQuestions.AnimeAnswers2)
        answers.shuffle()
        Log.d("ANSWERGROUP", answers[0] + " " + answers[1] + " " + answers[2])
        Log.d("ANSWERREAL", aqqQuestions.AnimeAnswers2[0])
    }

    private fun randomQuestion(){
        questionsaqq.shuffle()
        questionsaqq.random()
        setQuestion()
    }

    private fun checkTheAnswer(answers: String){
        if (answers == aqqQuestions.AnimeAnswers2[0]){
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
        Navigation.findNavController(requireView()).navigate(R.id.action_animeQQFragment_to_fragmentFiveStarAnimeQQ)
    }else if (score > 4){
        Navigation.findNavController(requireView()).navigate(R.id.action_animeQQFragment_to_fragmentThreeStarAnimeQQ)
    }else{
        Navigation.findNavController(requireView()).navigate(R.id.action_animeQQFragment_to_fragmentZeroStarAnimeQQ)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_anime_q_q, container, false)
        binding.animeGen2 = this
        randomQuestion()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.AnimeFour.setOnClickListener {
            checkTheAnswer(answers[0])
        }

        binding.AnimeFive.setOnClickListener {
            checkTheAnswer(answers[1])
        }

        binding.AnimeSix.setOnClickListener {
            checkTheAnswer(answers[2])
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }


}


