package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.text.style.BackgroundColorSpan
import android.util.Log
import android.widget.Button
import android.widget.EditText
import java.lang.StringBuilder
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    lateinit var button1: android.widget.Button
    lateinit var button2: android.widget.Button
    lateinit var button3: android.widget.Button
    lateinit var button4: android.widget.Button
    lateinit var button5: android.widget.Button
    lateinit var button6: android.widget.Button
    lateinit var button7: android.widget.Button
    lateinit var button8: android.widget.Button
    lateinit var button9: android.widget.Button
    lateinit var button0: android.widget.Button
    lateinit var button00: android.widget.Button
    lateinit var buttonperrcent: android.widget.Button
    lateinit var buttonclear: android.widget.Button
    lateinit var buttondot: android.widget.Button
    lateinit var buttonequal: android.widget.Button
    lateinit var buttonadd: android.widget.Button
    lateinit var buttonsub: android.widget.Button
    lateinit var buttonmul: android.widget.Button
    lateinit var buttondivide: android.widget.Button
    lateinit var buttonbackspace: android.widget.Button
    lateinit var inputtex: EditText
    lateinit var resulttex: EditText
    var check = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button00 = findViewById(R.id.button00);
        buttonperrcent = findViewById(R.id.buttonPercent);
        buttonclear = findViewById(R.id.clear);
        buttondot = findViewById(R.id.buttondot);
        buttonequal = findViewById(R.id.buttonequal);
        buttonadd = findViewById(R.id.buttonadd);
        buttonsub = findViewById(R.id.buttonminus);
        buttonmul = findViewById(R.id.buttonmultiply);
        buttondivide = findViewById(R.id.buttondivide);
        buttonbackspace = findViewById(R.id.buttonbackspace);
        resulttex = findViewById(R.id.result);
        inputtex = findViewById(R.id.inputnumber);
        inputtex.movementMethod = ScrollingMovementMethod()
        inputtex.isActivated
        inputtex.isPressed

        var text: String

        button1.setOnClickListener {
            text = inputtex.text.toString() + "1"
            inputtex.setText(text)
            result(text)
        }
        button2.setOnClickListener {
            text = inputtex.text.toString() + "2"
            inputtex.setText(text)
            result(text)
        }
        button3.setOnClickListener {
            text = inputtex.text.toString() + "3"
            inputtex.setText(text)
            result(text)
        }
        button4.setOnClickListener {
            text = inputtex.text.toString() + "4"
            inputtex.setText(text)
            result(text)
        }
        button5.setOnClickListener {
            text = inputtex.text.toString() + "5"
            inputtex.setText(text)
            result(text)
        }
        button6.setOnClickListener {
            text = inputtex.text.toString() + "6"
            inputtex.setText(text)
            result(text)
        }
        button7.setOnClickListener {
            text = inputtex.text.toString() + "7"
            inputtex.setText(text)
            result(text)
        }
        button8.setOnClickListener {
            text = inputtex.text.toString() + "8"
            inputtex.setText(text)
            result(text)
        }
        button9.setOnClickListener {
            text = inputtex.text.toString() + "9"
            inputtex.setText(text)
            result(text)
        }
        button0.setOnClickListener {
            text = inputtex.text.toString() + "0"
            inputtex.setText(text)
            result(text)
        }
        button00.setOnClickListener {
            text = inputtex.text.toString() + "00"
            inputtex.setText(text)
            result(text)
        }
        buttondot.setOnClickListener {
            text = inputtex.text.toString() + "."
            inputtex.setText(text)
            result(text)
        }
        buttonadd.setOnClickListener {
            text = inputtex.text.toString() + "+"
            inputtex.setText(text)
            check = check + 1
        }
        buttonsub.setOnClickListener {
            text = inputtex.text.toString() + "-"
            inputtex.setText(text)
            check = check + 1
        }
        buttonmul.setOnClickListener {
            text = inputtex.text.toString() + "*"
            inputtex.setText(text)
            check = check + 1
        }
        buttondivide.setOnClickListener {
            text = inputtex.text.toString() + "/"
            inputtex.setText(text)
            check = check + 1
        }
        buttonperrcent.setOnClickListener {
            text = inputtex.text.toString() + "%"
            inputtex.setText(text)
            check = check + 1
        }

        buttonequal.setOnClickListener {
            text=resulttex.text.toString()
            inputtex.setText(text)
            resulttex.setText(null)
        }
        buttonclear.setOnClickListener {
            inputtex.setText(null)
            resulttex.setText(null)
        }
        buttonbackspace.setOnClickListener {
            var BackSpace:String?=null
            if (inputtex.text.length>0){
                val stringBuilder:StringBuilder= StringBuilder(inputtex.text)
                val find=inputtex.text.toString()
                val find2=find.last()

                if (find2.equals('+')||find2.equals('-')||find2.equals('*')||find2.equals('/')||find2.equals('%'))
                {
                    check=check-1
                }
                stringBuilder.deleteCharAt(inputtex.text.length-1)
                BackSpace=stringBuilder.toString()
                inputtex.setText(BackSpace)
                result(BackSpace)
            }
        }
    }


    private fun result(text: String) {
        val engine:ScriptEngine=ScriptEngineManager().getEngineByName("rhino")
        try {
            val result:Any=engine.eval(text)
            var mainr=result.toString()
            if (check==0)
            {
                resulttex.setText(null)
            }
            else
            {
                resulttex.setText(mainr)
            }
        }
        catch (e:ScriptException)
        {
            Log.d("TAG","ERROR")
        }

    }
}



