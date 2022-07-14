package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener{

    var tts: TextToSpeech? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tts= TextToSpeech(this, this)
        findViewById<Button>(R.id.btn_Play).setOnClickListener{speak()}

    }

    private fun speak(){
        var message: String = findViewById<EditText>(R.id.edt_play).text.toString()
        tts!!.speak(message, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            findViewById<TextView>( R.id.textView).text = "Sí se puede"
            tts!!.setLanguage(Locale.getDefault())
        }else{
            findViewById<TextView>( R.id.textView).text = "No se puede"
        }
    }
}