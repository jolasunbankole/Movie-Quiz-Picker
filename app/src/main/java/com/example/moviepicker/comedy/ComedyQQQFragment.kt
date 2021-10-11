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
import com.example.moviepicker.data.QuestionsCQQQ
import com.example.moviepicker.databinding.FragmentComedyQQQBinding


class ComedyQQQFragment : Fragment(){
private lateinit var binding: FragmentComedyQQQBinding
lateinit var comedyquestionthree: QuestionsCQQQ
private var questionIndex = 0
private val maxNumberOfQuestions = 9
lateinit var answers: ArrayList<String>
private var score = 0

    private var questions = arrayListOf(
        QuestionsCQQQ(
            "in 22 jump street, who dates the captains daughter ?",
            arrayListOf("Jonah Hill", "Channing Tatum", "Dave Franco")
        ),

        QuestionsCQQQ(
            "Was game night in the movie game night real or fake ?",
            arrayListOf("Real", "Fake", "Not sure")
        ),

        QuestionsCQQQ(
            "How many men in black films are there now ?",
            arrayListOf("4", "3", "2")
        ),

        QuestionsCQQQ(
            "What comic book franchise produce the action comedy Red ?",
            arrayListOf("DC", "Marvel", "Valiant")
        ),

        QuestionsCQQQ(
            "What famous comedy actor plays Johnny English ?",
            arrayListOf("Mr Bean", "Russle howard", "piers Morgan")
        ),

        QuestionsCQQQ(
            "Where is the Kingsman based in ?",
            arrayListOf("England", "America", "Scotland")
        ),

        QuestionsCQQQ(
            "What famous martial arts fighter played the green hornets driver in 2011 ?",
            arrayListOf("Jay Chou", "Jet Lee", "Dony Yeng")
        ),

        QuestionsCQQQ(
            "Who did the 2 host in the interview, interview in the movie ?",
            arrayListOf("Kim jong on", "Dondal Trump", "Binladen")
        ),

        QuestionsCQQQ(
            "What wrestinlg legend started in the Bay Watch Movie ? ",
            arrayListOf("The Rock", "John Cena", "Roman Rains")
        ),

        QuestionsCQQQ(
            "What famous actress, started in a action movie with Gerard Butler",
            arrayListOf("Jennifer Aniston", "Rachel Cox", "Michelle Ko")
        ),
    )

    private fun setQuestions(){
        comedyquestionthree = questions[questionIndex]
        answers = ArrayList(comedyquestionthree.ComedyAnswers3)
        answers.shuffle()
        Log.d("ANSWERGROUP", answers[0] + " " + answers[1] + " " + answers[2])
        Log.d("ANSWERREAL", comedyquestionthree.ComedyAnswers3[0])
    }

    private fun randomQuestion(){
        questions.shuffle()
        questions.random()
        setQuestions()
    }

    private fun checkTheAnswer(answers: String){
        if (answers == comedyquestionthree.ComedyAnswers3[0]) {
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

    private fun getTheScore() = if (score >= 8){
        Navigation.findNavController(requireView()).navigate(R.id.action_comedyQQQFragment_to_fragmentFiveStarQQQ)
    }else if (score > 3){
        Navigation.findNavController(requireView()).navigate(R.id.action_comedyQQQFragment_to_fragmentThreeStarComedyQQQ)
    }else{
        Navigation.findNavController(requireView()).navigate(R.id.action_comedyQQQFragment_to_fragmentZeroStarComedyQQQ)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_comedy_q_q_q, container, false)
        randomQuestion()
        binding.comedy3 = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ComedyAnswerseven.setOnClickListener {
            checkTheAnswer(answers[0])
        }

        binding.ComedyAnsweeight.setOnClickListener {
            checkTheAnswer(answers[1])

        }

        binding.ComedyAnswernine.setOnClickListener {
            checkTheAnswer(answers[2])
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }


}