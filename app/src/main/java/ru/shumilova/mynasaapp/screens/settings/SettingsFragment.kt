package ru.shumilova.mynasaapp.screens.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_settings.*
import ru.shumilova.mynasaapp.R
import ru.shumilova.mynasaapp.model.utils.ThemeHolder

class SettingsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sc_selected_theme.setOnClickListener {
            if (sc_selected_theme.isChecked) {
                ThemeHolder.id = R.style.Theme_MyNASAAppDark
            } else {
                ThemeHolder.id = R.style.Theme_MyNASAApp
            }

            activity?.recreate()
        }
    }
}