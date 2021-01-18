package ru.shumilova.mynasaapp.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.shumilova.mynasaapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, PictureOfTheDayFragment()).commit()
    }
}