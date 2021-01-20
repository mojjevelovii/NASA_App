package ru.shumilova.mynasaapp.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.shumilova.mynasaapp.R
import ru.shumilova.mynasaapp.model.utils.ThemeHolder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(ThemeHolder.id)
        setContentView(R.layout.activity_main)
    }
}