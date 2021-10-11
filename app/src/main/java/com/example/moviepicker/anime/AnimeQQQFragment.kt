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
import com.example.moviepicker.data.QuestionAQQQ
import com.example.moviepicker.databinding.FragmentAnimeQQQBinding


class AnimeQQQFragment : Fragment() {
    private lateinit var binding: FragmentAnimeQQQBinding
    lateinit var aqqqQuestions: QuestionAQQQ
    private var questionIndex = 0
    private val maxNumberOfQuestions = 9
    lateinit var answers: ArrayList<String>
    private var score = 0


    private var questionsaqqq = arrayListOf(
        QuestionAQQQ(
            "How much did demon slayer movie make",
            arrayListOf("503m", "100m", "608m")
        ),

        QuestionAQQQ(
            "Who Dies in the movie your name ?",
            arrayListOf("The Girl", "The Boy", "Both")
        ),

        QuestionAQQQ(
            "What Japanese charcter was a battle robot and put onto the big screen ?",
            arrayListOf("Alita", "Astro Boy", "Batman")
        ),

        QuestionAQQQ(
            "In naruto movie the last, what did hinata give naruto as a bday present ?",
            arrayListOf("Scarf", "Head Band", "Her heart")
        ),

        QuestionAQQQ(
            "How many my hero movies have been seen by the public ?",
            arrayListOf("2", "3", "1")
        ),

        QuestionAQQQ(
            "What was Arrietty size compared to in her movie ?",
            arrayListOf("Ant", "Bird", "Dust")
        ),

        QuestionAQQQ(
            "In Blue Exorcist, who is the main characters father ?",
            arrayListOf("The Devil", "God", "Fallen Angel")
        ),

        QuestionAQQQ(
            "From the final fantasy video game franchise, how many movies was created ?",
            arrayListOf("9", "6", "7")
        ),

        QuestionAQQQ(
            "What happens to Natsu in the fairy tail movie",
            arrayListOf("Turns in a dragon", "Dies", "Becomes evil")
        ),

        QuestionAQQQ(
            "How many kids does naruto have by the end of his journey ?",
            arrayListOf("2", "3", "1")
        ),
    )

    private fun setQuestion(){
        aqqqQuestions = questionsaqqq[questionIndex]
        answers = ArrayList(aqqqQuestions.AnimeAnswers3)
        answers.shuffle()
        Log.d("ANSWERGROUP", answers[0] + " " + answers[1] + " " + answers[2])
        Log.d("ANSWERREAL", aqqqQuestions.AnimeAnswers3[0])
    }

    private fun randomQuestion(){
        questionsaqqq.shuffle()
        questionsaqqq.random()
        setQuestion()
    }

    private fun checkTheAnswer(answers: String){
        if (answers == aqqqQuestions.AnimeAnswers3[0]){
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
        Navigation.findNavController(requireView()).navigate(R.id.action_animeQQQFragment_to_fragmentFiveStarAnimeQQQ)

    }else if (score > 4){
        Navigation.findNavController(requireView()).navigate(R.id.action_animeQQQFragment_to_fragmentThreeStarAnimeQQQ)
    }else{
        Navigation.findNavController(requireView()).navigate(R.id.action_animeQQQFragment_to_fragmentZeroStarAnimeQQQ)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_anime_q_q_q, container, false)
        randomQuestion()
        binding.animeGen3 = this
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.AnimeSeven.setOnClickListener {
            checkTheAnswer(answers[0])
        }

        binding.AnimeEight.setOnClickListener {
            checkTheAnswer(answers[1])
        }

        binding.AnimeNine.setOnClickListener {
            checkTheAnswer(answers[2])
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }


}


