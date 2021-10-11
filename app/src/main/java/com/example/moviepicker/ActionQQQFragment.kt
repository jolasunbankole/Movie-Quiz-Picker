package com.example.moviepicker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.moviepicker.data.QuestionActr
import com.example.moviepicker.databinding.FragmentActionQQQBinding

//action movie generator2 2010+
class ActionQQQFragment : Fragment() {
    private lateinit var binding: FragmentActionQQQBinding
    lateinit var acccQuestions: QuestionActr
    private var questionIndex = 0
    private val maxNumberOfQuestions = 7
    lateinit var answers: ArrayList<String>
    private var score = 0


    private var questions = arrayListOf(
        QuestionActr(
            "What video game movie was released in 2016 ?",
            arrayListOf("Assassins Creed", "Man of steel", "Ready player one")
        ),
        QuestionActr(
            "What famous anime robot was shown in the movie, ready player one ?",
            arrayListOf("Gundam", "Alita", "Franky")
        ),
        QuestionActr(
            "What avenger was in on of the Spider-men movies ?",
            arrayListOf("Iron Man", "Thor", "Venom")
        ),
        QuestionActr(
            "Why did John Wick go back into action in the first movie ?",
            arrayListOf("Dog died", "Mom died", "Wife died")
        ),
        QuestionActr(
            "How many G.I Joe movies are there now ?",
            arrayListOf("3", "2", "5")
        ),
        QuestionActr(
            "Who is Jackie Chan against in the Foreigner ?",
            arrayListOf("IRA", "NSA", "SSA")
        ),
        QuestionActr(
            "What universe is aquaman on ?",
            arrayListOf("DC uni", "Marvel uni", "Anime uni")
        ),
        QuestionActr(
            "What hero did Ryan Reynolds play first ?",
            arrayListOf("Green lantern", "Pickachu", "Dead pool")
        ),
        QuestionActr(
            "What is the greatest superhero movie of all time ?",
            arrayListOf("End Game", "Spider-Man 2", "Kick ass")
        ),
        QuestionActr(
            "How many Batman movies did Christopher Nolan do ?",
            arrayListOf("3", "5", "2")
        ),
    )

    private fun setQuestion() {
        acccQuestions = questions[questionIndex]
        answers = ArrayList(acccQuestions.ActionAnswers3)
        answers.shuffle()
        Log.d("ANSWERGROUP", answers[0] + " " + answers[1] + " " + answers[2])
        Log.d("ANSWERREAL", acccQuestions.ActionAnswers3[0])
    }

    private fun randomQuestion() {
        questions.shuffle()
        questions.random()
        setQuestion()
    }

    private fun checkTheAnswer(answers: String) {
        if (answers == acccQuestions.ActionAnswers3[0]) {
            score += 1
        }
        questionIndex++
        if (questionIndex < maxNumberOfQuestions){
            setQuestion()
            binding.invalidateAll()
        }else{
            getTheScore()
        }

    }

    private fun getTheScore() = if (score >= 5){
        Navigation.findNavController(requireView()).navigate(R.id.action_actionQQQFragment_to_fragmentFiverStarActionQQQ)
    }else if (score > 3){
        Navigation.findNavController(requireView()).navigate(R.id.action_actionQQQFragment_to_fragmentThreeStarActionQQQ)
    }else{
        Navigation.findNavController(requireView()).navigate(R.id.action_actionQQQFragment_to_fragmentZeroStarActionQQQ)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_action_q_q_q, container, false)
        randomQuestion()
        binding.ActionMMM.text
        binding.generator3 = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.AnswerSeven.setOnClickListener {
            checkTheAnswer(answers[0])
        }
        binding.AnswerEight.setOnClickListener {
            checkTheAnswer(answers[1])
        }
        binding.AnswerNine.setOnClickListener {
            checkTheAnswer(answers[2])
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding
    }




}