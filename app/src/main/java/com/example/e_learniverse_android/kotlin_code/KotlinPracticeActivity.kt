package com.example.e_learniverse_android.kotlin_code

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.e_learniverse_android.R
import kotlinx.android.synthetic.main.activity_kotlin_practice.addButton
import kotlinx.android.synthetic.main.activity_kotlin_practice.btnKotlinRecyclerView
import kotlinx.android.synthetic.main.activity_kotlin_practice.deleteButton
import kotlinx.android.synthetic.main.activity_kotlin_practice.deleteTextView
import kotlinx.android.synthetic.main.activity_kotlin_practice.editText1
import kotlinx.android.synthetic.main.activity_kotlin_practice.editText2
import kotlinx.android.synthetic.main.activity_kotlin_practice.sumTextView

class KotlinPracticeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_practice)

        // "onClick" method's "View" is Now Referenced by "p" with "p->"... by default it is referenced with "it" in Kotlin
        btnKotlinRecyclerView.setOnClickListener {p->
            // "Intent Passing" in Kotlin
            startActivity(Intent(this@KotlinPracticeActivity, KotlinRecyclerViewActivity::class.java))
        }

        addButton.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                if(editText1.text.toString()!="" && editText2.text.toString()!=""){
                    // Get Text in "Kotlin"
                    val no1 = editText1.text.toString().toInt()
                    val no2 = editText2.text.toString().toInt()

                    val sum = no1 + no2

                    Toast.makeText(
                        this@KotlinPracticeActivity,
                        "the Sum is: ${sum}",
                        Toast.LENGTH_LONG
                    ).show()

                    // Set Text in "Kotlin"
                    sumTextView.text = "${no1} + ${no2} = $sum"
                }
            }
        })

        deleteButton.setOnClickListener {
            if (editText1.text.toString() != "" && editText2.text.toString() != "") {
                // Get Text in "Kotlin"
                val no1 = editText1.text.toString().toInt()
                val no2 = editText2.text.toString().toInt()

                val minus = no1 - no2

                Toast.makeText(
                    this@KotlinPracticeActivity,
                    "the Minus is: ${minus}",
                    Toast.LENGTH_LONG
                ).show()

                // Set Text in "Kotlin"
                deleteTextView.text = "${no1} - ${no2} = $minus"
            }
        }
    }
}