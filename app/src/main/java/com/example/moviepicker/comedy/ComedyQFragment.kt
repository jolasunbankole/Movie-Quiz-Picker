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
import com.example.moviepicker.data.QuestionsCQ
import com.example.moviepicker.databinding.FragmentComedyQBinding

class ComedyQFragment : Fragment() {
    private lateinit var binding: FragmentComedyQBinding
    lateinit var comedyquestionone: QuestionsCQ
    private var questionIndex = 0
    private val maxNumberOfQuestions = 9
    lateinit var answers: ArrayList<String>
    private var score = 0


    private var questions = arrayListOf(
        QuestionsCQ(
            "How many are there in the little rascals gang ?",
            arrayListOf("10", "12", "11")
        ),

        QuestionsCQ(
            "WWhat actor started on the spoof ranbow movie in the 1990s",
            arrayListOf("Charlie Sheen", "Lloyed Bridges", "Wayne Bro's")
        ),

        QuestionsCQ(
            "What sport did Adam Sandler pick up in the movie Happy Gilmore ?",
            arrayListOf("Golf", "Cricket", "Soft Ball")
        ),

        QuestionsCQ(
            "Who is the mani charcter in the 90s hit basket ball movie Space Jam",
            arrayListOf("Micheal Jordan", "Lebron James", "Stephan Curry")
        ),

        QuestionsCQ(
            "What colour was the mask in the movie the Mask ?",
            arrayListOf("Green", "Brown", "Blue")
        ),

        QuestionsCQ(
            "Finish this sentence, White men can't .... ",
            arrayListOf("Jump", "Work", "Climb")
        ),

        QuestionsCQ(
            "What is Ace Vnetura's power in the movie and cartoons ?",
            arrayListOf("Talk to animals", "Heat vison", "Detective")
        ),

        QuestionsCQ(
            "What animal befriended stuart little ?",
            arrayListOf("The Cat", "A Dog", "A Parrot")
        ),

        QuestionsCQ(
            "What twin teen sensation started in the movie, The Parent Trap ?",
            arrayListOf("Lindsay Lohan", "Olsan twins", "Jed ward")
        ),

        QuestionsCQ(
            "Around what holiday did the 90s movie Hocus Pocus release at ?",
            arrayListOf("October", "December", "April")
        ),

        )

        private fun setQuestion() {
            comedyquestionone = questions[questionIndex]
            answers = ArrayList(comedyquestionone.ComedyAnswers)
            answers.shuffle()
            Log.d("ANSWERGROUP", answers[0] + " " + answers[1] + " " + answers[2])
            Log.d("ANSWERREAL", comedyquestionone.ComedyAnswers[0])
        }

        private fun randomQuestion() {
        questions.shuffle()
        questions.random()
        setQuestion()
    }

        private fun checkTheAnswers(answers:String){
            if (answers == comedyquestionone.ComedyAnswers[0]){
                score += 1
            }
            questionIndex++
            if(questionIndex<maxNumberOfQuestions){
                setQuestion()
                binding.invalidateAll()
            }else{
                getTheScore()
            }
        }

        private fun getTheScore() = if (score >= 7){
            Navigation.findNavController(requireView()).navigate(R.id.action_comedyQFragment_to_fragmentFiveStarComedyQ)
        }else if (score > 3){
            Navigation.findNavController(requireView()).navigate(R.id.action_comedyQFragment_to_fragmentThreeStarComedyQ)
        }else{
            Navigation.findNavController(requireView()).navigate(R.id.action_comedyQFragment_to_fragmentZeroStarComedyQ)
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_comedy_q, container, false)
        randomQuestion()
        binding.ComedyTitle.text
        binding.comedyQ1.text
        binding.comedy = this
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ComedyAnswerone.setOnClickListener {
            checkTheAnswers(answers[0])
        }

        binding.ComedyAnswertwo.setOnClickListener {
            checkTheAnswers(answers[1])
        }

        binding.ComedyAnswerthree.setOnClickListener {
            checkTheAnswers(answers[2])
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }
}