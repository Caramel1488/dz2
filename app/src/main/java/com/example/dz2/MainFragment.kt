package com.example.dz2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dz2.databinding.MainFragmentLayoutBinding
import com.example.dz2.networking.Network
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class MainFragment:Fragment(R.layout.main_fragment_layout) {

    private val binding: MainFragmentLayoutBinding by viewBinding(MainFragmentLayoutBinding::bind)

    private val errorHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.e("Try", "error from CoroutineExceptionHandler", throwable)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch(errorHandler) {
            val res = Network.gifApi.getGifs("star")
            Log.d("Try", res.toString())
        }
    }
}