package ru.shumilova.mynasaapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import coil.api.load
import kotlinx.android.synthetic.main.fragment_picture_of_the_day.*
import ru.shumilova.mynasaapp.model.repository.PictureOfTheDayData
import ru.shumilova.mynasaapp.R

class PictureOfTheDayFragment : Fragment() {

    private val viewModel: PictureOfTheDayViewModel by lazy {
        ViewModelProvider(this).get(PictureOfTheDayViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_picture_of_the_day, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner, { renderData(it) })
    }

    private fun renderData(data: PictureOfTheDayData) {
        when (data) {
            is PictureOfTheDayData.Success -> {
                val serverResponseData = data.serverResponseData
                val url = serverResponseData.url

                pb_loading.isVisible = false

                if (url.isNullOrEmpty()) {
                    showError("Link is empty!")
                } else {
                    image_view.load(url) {
                        lifecycle(viewLifecycleOwner)
                        error(R.drawable.ic_load_error_vector)
                        placeholder(R.drawable.ic_no_photo_vector)
                    }
                }
            }
            is PictureOfTheDayData.Loading -> {
                pb_loading.isVisible = true
            }
            is PictureOfTheDayData.Error -> {
                pb_loading.isVisible = false
                showError(data.error.message.orEmpty())
            }
        }
    }

    private fun showError(message: String) {
        PictureOfTheDayData.Error(Throwable(message))
    }

}