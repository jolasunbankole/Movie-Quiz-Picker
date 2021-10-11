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
import com.example.moviepicker.data.QuestionAQ
import com.example.moviepicker.databinding.FragmentAnimeQBinding


class AnimeQFragment : Fragment() {
    private lateinit var binding: FragmentAnimeQBinding
    lateinit var aqQuestions: QuestionAQ
    private var questionIndex = 0
    private val maxNumberOfQuestions = 9
    lateinit var answers: ArrayList<String>
    private var score = 0

    private var questionsaq = arrayListOf(
        QuestionAQ(
            "What was the live action animation movie was Brad Pitt in ?",
            arrayListOf("Cool World", "Looney Toons", "Space Jam")
        ),

        QuestionAQ(
            "Who was Mononoke raised by ?",
            arrayListOf("Wolves", "Bears", "Tigers")
        ),

        QuestionAQ(
            "What where the racoons ability in the 90s movie Pom Poko ?",
            arrayListOf("ShapeShift", "Fly", "Talking")
        ),

        QuestionAQ(
            "What color hair does Swan princess have ?",
            arrayListOf("Blonde", "Brown", "Ginger")
        ),

        QuestionAQ(
            "Who was the surprise actor in space jame 1990s ?",
            arrayListOf("Bill Murry", "Robin Williams", "Drake Bell")
        ),

        QuestionAQ(
            "How many animated Aladdin films are there ?",
            arrayListOf("3", "5", "2")
        ),

        QuestionAQ(
            "Does goofy have a son ?",
            arrayListOf("Yes", "maybe", "No")
        ),

        QuestionAQ(
            "How many friends does the hunchback have before he leaves to the outside world ?",
            arrayListOf("3", "0", "6")
        ),

        QuestionAQ(
            "Who was tarzan raised by ?",
            arrayListOf("Monkeys", "Humans", "Elephants")
        ),

        QuestionAQ(
            "Finish this sentence, Fantasia ____",
            arrayListOf("2000", "1999", "2111")
        ),
    )

    private fun setQuestion(){
        aqQuestions = questionsaq[questionIndex]
        answers = ArrayList(aqQuestions.AnimeAnswers)
        answers.shuffle()
        Log.d("ANSWERGROUP", answers[0] + " " + answers[1] + " " + answers[2])
        Log.d("ANSWERREAL", aqQuestions.AnimeAnswers[0])
    }

    private fun randomQuestion(){
        questionsaq.shuffle()
        questionsaq.random()
        setQuestion()
    }

    private fun checkTheAnswer(answers: String){
        if (answers == aqQuestions.AnimeAnswers[0]){
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
        Navigation.findNavController(requireView()).navigate(R.id.action_animeQFragment_to_fragmentFiveStarAnimeQ)
    }else if (score > 4){
        Navigation.findNavController(requireView()).navigate(R.id.action_animeQFragment_to_fragmentThreeStarAnimeQ)
    }else{
        Navigation.findNavController(requireView()).navigate(R.id.action_animeQFragment_to_fragmentZeroStarAnimeQ)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_anime_q, container, false)
        randomQuestion()
        binding.animeGen = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.Animeone.setOnClickListener {
            checkTheAnswer(answers[0])
        }

        binding.Animetwo.setOnClickListener {
            checkTheAnswer(answers[1])
        }

        binding.Animethree.setOnClickListener {
            checkTheAnswer(answers[2])
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }


}