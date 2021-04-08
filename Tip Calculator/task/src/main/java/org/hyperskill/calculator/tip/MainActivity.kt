package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.slider.Slider
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<EditText>(R.id.edit_text).doAfterTextChanged { _ -> updateView() }
        findViewById<Slider>(R.id.slider).addOnChangeListener { _, _, _ -> updateView() }
    }

    private fun updateView() {
        val bill =  findViewById<EditText>(R.id.edit_text).text
        if (bill.toString() == "") {
            findViewById<TextView>(R.id.text_view).text = ""
        } else {
            val billD = bill.toString().toDouble()
            println(billD)
            val tipP = findViewById<Slider>(R.id.slider).value.toInt()
            val tip: Double = billD*tipP/100
            val df = DecimalFormat("0.00")
            val s = "Tip amount: ${df.format(tip)}"
            findViewById<TextView>(R.id.text_view).text = s
        }


    }
}