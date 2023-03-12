package id.ac.ubaya.informatika.adv160420072week2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var txtNum1 = view.findViewById<TextView>(R.id.txtNum1)
        var txtNum2 = view.findViewById<TextView>(R.id.txtNum2)

        var rand1 = (0..20).random()
        var rand2 = (0..20).random()
        txtNum1.setText(rand1.toString())
        txtNum2.setText(rand2.toString())

        var add = rand1+rand2
        val txtNumAdd = view.findViewById<TextView>(R.id.txtNumAdd)
        var answer = txtNumAdd.text.toString()
        val btnSubmit = view.findViewById<Button>(R.id.btnSubmit)
        var score = 0
        btnSubmit.setOnClickListener {
            if(add == answer.toInt()){


                score+=1
                var rand1 = (0..100).random()
                var rand2 = (0..100).random()
                txtNum1.setText(rand1.toString())
                txtNum2.setText(rand2.toString())

                var add = rand1+rand2
                var txtNumAdd = view.findViewById<TextView>(R.id.txtNumAdd)
            }
            else{
                val action = GameFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
        if(arguments != null) {
            val txtTurn = view.findViewById<TextView>(R.id.txtTurn)
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }
    }

}