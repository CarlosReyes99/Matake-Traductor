package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech

import android.util.Log

import android.widget.TextView
import android.widget.Toast
import com.example.hellokotlin.databinding.ActivityMainBinding
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private lateinit var binding : ActivityMainBinding
    private lateinit var pruebasEdit: String
    private var tts: TextToSpeech? = null
    


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)


        tts = TextToSpeech(this, this)


        //button english
        binding.btnPlayEng.setOnClickListener {
            pruebasEdit = binding.edtPlayEsp.text.toString()

            Log.i("mensaje: ", pruebasEdit)

            val translationConfigs = TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.SPANISH)
                .setTargetLanguage(TranslateLanguage.ENGLISH)
                .build()

            val translator = Translation.getClient(translationConfigs)
            if (pruebasEdit.isNotEmpty()) {
                translator.downloadModelIfNeeded()
                    .addOnSuccessListener {
                        Toast.makeText(this, "Download Successful", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
            }
            translator.translate(pruebasEdit)
                .addOnSuccessListener {
                    tts!!.language = Locale.UK
                    speak(it)
                }
                .addOnFailureListener {
                    it.printStackTrace()
                }


        }




        //button chinese
        binding.btnPlayCh.setOnClickListener{

            pruebasEdit = binding.edtPlayEsp.text.toString()

            Log.i("mensaje: ", pruebasEdit)

            val translationConfigs = TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.SPANISH)
                .setTargetLanguage(TranslateLanguage.CHINESE)
                .build()

            val translator = Translation.getClient(translationConfigs)
            if (pruebasEdit.isNotEmpty()) {
                translator.downloadModelIfNeeded()
                    .addOnSuccessListener {
                        Toast.makeText(this, "Download Successful", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
            }
            translator.translate(pruebasEdit)
                .addOnSuccessListener {
                    tts!!.language = Locale.CHINESE
                    speak(it)
                }
                .addOnFailureListener {
                    it.printStackTrace()
                }


        }

        //button korean
        binding.btnPlayKor.setOnClickListener {
            pruebasEdit = binding.edtPlayEsp.text.toString()
            Log.i("mensaje: ", pruebasEdit)

            val translationConfigs = TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.SPANISH)
                .setTargetLanguage(TranslateLanguage.KOREAN)
                .build()

            val translator = Translation.getClient(translationConfigs)
            if (pruebasEdit.isNotEmpty()) {
                translator.downloadModelIfNeeded()
                    .addOnSuccessListener {
                        Toast.makeText(this, "Download Successful", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
            }
            translator.translate(pruebasEdit)
                .addOnSuccessListener {
                    tts!!.language = Locale.KOREAN
                    speak(it)
                }
                .addOnFailureListener {
                    it.printStackTrace()
                }


        }

        //button french
        binding.btnPlayFr.setOnClickListener {
            pruebasEdit = binding.edtPlayEsp.text.toString()
            Log.i("mensaje: ", pruebasEdit)

            val translationConfigs = TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.SPANISH)
                .setTargetLanguage(TranslateLanguage.FRENCH)
                .build()

            val translator = Translation.getClient(translationConfigs)
            if (pruebasEdit.isNotEmpty()) {
                translator.downloadModelIfNeeded()
                    .addOnSuccessListener {
                        Toast.makeText(this, "Download Successful", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
            }
            translator.translate(pruebasEdit)
                .addOnSuccessListener {
                    tts!!.language = Locale.FRENCH
                    speak(it)
                }
                .addOnFailureListener {
                    it.printStackTrace()
                }


        }

        //button italian
        binding.btnPlayIt.setOnClickListener {
            pruebasEdit = binding.edtPlayEsp.text.toString()
            Log.i("mensaje: ", pruebasEdit)

            val translationConfigs = TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.SPANISH)
                .setTargetLanguage(TranslateLanguage.ITALIAN)
                .build()

            val translator = Translation.getClient(translationConfigs)
            if (pruebasEdit.isNotEmpty()) {
                translator.downloadModelIfNeeded()
                    .addOnSuccessListener {
                        Toast.makeText(this, "Download Successful", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
            }
            translator.translate(pruebasEdit)
                .addOnSuccessListener {
                    tts!!.language = Locale.ITALIAN
                    speak(it)
                }
                .addOnFailureListener {
                    it.printStackTrace()
                }


        }

        //button japanese
        binding.btnPlayJap.setOnClickListener {
            pruebasEdit = binding.edtPlayEsp.text.toString()
            Log.i("mensaje: ", pruebasEdit)

            val translationConfigs = TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.SPANISH)
                .setTargetLanguage(TranslateLanguage.JAPANESE)
                .build()

            val translator = Translation.getClient(translationConfigs)
            if (pruebasEdit.isNotEmpty()) {
                translator.downloadModelIfNeeded()
                    .addOnSuccessListener {
                        Toast.makeText(this, "Download Successful", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
            }
            translator.translate(pruebasEdit)
                .addOnSuccessListener {
                    tts!!.language = Locale.JAPANESE
                    speak(it)
                }
                .addOnFailureListener {
                    it.printStackTrace()
                }


        }









    }



    private fun speak(message: String) {

        tts!!.speak(message, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            findViewById<TextView>(R.id.textView).text = getString(R.string.confirm_translate)


        }else{
            findViewById<TextView>(R.id.textView).text = getString(R.string.not_confirm_translate)
        }

    }
}

