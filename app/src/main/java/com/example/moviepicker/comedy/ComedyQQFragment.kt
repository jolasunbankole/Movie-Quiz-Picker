package com.example.moviepicker.comedy

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.moviepicker.R
import com.example.moviepicker.data.QuestionsCQQ
import com.example.moviepicker.databinding.FragmentComedyQQBinding


class ComedyQQFragment : Fragment() {
    private lateinit var binding: FragmentComedyQQBinding
    lateinit var comedyquestiontwo: QuestionsCQQ
    private var questionIndex = 0
    private val maxNumberOfQuestions = 9
    lateinit var answers: ArrayList<String>
    private var score = 0

    private var questions = arrayListOf(
        QuestionsCQQ(
            "What color did the lawyer from Legally Blonde always wear ?",
            arrayListOf("Pink", "Brown", "Yellow")
        ),

        QuestionsCQQ(
            "Who is Jackie Chan's partner in Rush Hour ?",
            arrayListOf("James Carter", "Damien Wayne", "Agent J")
        ),

        QuestionsCQQ(
            "What famous 90s rapper is in the movie how high ?",
            arrayListOf("Method Man", "P Diddy", "Biggie Smalls")
        ),

        QuestionsCQQ(
            "What movie copied the English movie Mean Machines ?",
            arrayListOf("Longest Yard", "Coach carter", "Shaolin Soccer")
        ),

        QuestionsCQQ(
            "How many movies does the Zoolander have now ?",
            arrayListOf("2", "3", "1")
        ),

        QuestionsCQQ(
            "What super Hero did will smith play in the big screen ?",
            arrayListOf("Hancock", "Secret Agent", "Space explorer")
        ),

        QuestionsCQQ(
            "What gender was the head master in St Trinians ?",
            arrayListOf("Female", "Male", "Trans")
        ),

        QuestionsCQQ(
            "Who won the last game in coach carter ?",
            arrayListOf("The other team", "Staring Team", "Ended in a draw")
        ),

        QuestionsCQQ(
            "What famous 90s female rapper, was in the hit movie Taxi ?",
            arrayListOf("Queen Latifah", "Cardi B", "Eve")
        ),

        QuestionsCQQ(
            "Where is the movie Snatch based in ?",
            arrayListOf("England", "Ireland", "Russia")
        ),
    )

    private fun setQuestions(){
        comedyquestiontwo = questions[questionIndex]
        answers = ArrayList(comedyquestiontwo.ComedyAnswers2)
        answers.shuffle()
        Log.d("ANSWERGROUP", answers[0] + " " + answers[1] + " " + answers[2])
        Log.d("ANSWERREAL", comedyquestiontwo.ComedyAnswers2[0])
    }

    private fun randomQuestion(){
        questions.shuffle()
        questions.random()
        setQuestions()
    }

    private fun checkTheAnswer(answer:String){
        if (answer == comedyquestiontwo.ComedyAnswers2[0]){
            score += 1
        }
        questionIndex++
        if (questionIndex<maxNumberOfQuestions){
            setQuestions()
        binding.invalidateAll()
    }else{
        getTheScore()

        }
    }

    private fun getTheScore() = if (score >= 6){
        Navigation.findNavController(requireView()).navigate(R.id.action_comedyQQFragment_to_fragmentFiveStarComedyQQ)
    }else if (score > 3){
        Navigation.findNavController(requireView()).navigate(R.id.action_comedyQQFragment_to_fragmentThreeStarComedyQQ)
    }else{
        Navigation.findNavController(requireView()).navigate(R.id.action_comedyQQFragment_to_fragmentZeroStarComedyQQ)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate(inflater, R.layout.fragment_comedy_q_q, container, false)
        randomQuestion()
        binding.comedy2 = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ComedyAnswerfour.setOnClickListener {
            checkTheAnswer(answers[0])
        }

        binding.ComedyAnswefive.setOnClickListener {
            checkTheAnswer(answers[1])
        }

        binding.ComedyAnswersix.setOnClickListener {
            checkTheAnswer(answers[2])
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }


}