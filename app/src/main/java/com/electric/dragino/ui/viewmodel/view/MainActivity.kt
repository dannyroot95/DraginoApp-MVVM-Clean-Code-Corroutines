package com.electric.dragino.ui.viewmodel.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.electric.dragino.repository.FirebaseRepository
import com.electric.dragino.databinding.ActivityMainBinding
import com.electric.dragino.ui.viewmodel.DeviceViewModel
import com.electric.dragino.ui.viewmodel.DeviceViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: DeviceViewModel
    private val firebaseRepository = FirebaseRepository()
    private val deviceId = "dragino1"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, DeviceViewModelFactory(firebaseRepository))
            .get(DeviceViewModel::class.java)

        viewModel.getDeviceData(deviceId)

        viewModel.deviceData.observe(this) { deviceData ->
            binding.pg.visibility = View.GONE
            binding.txt.visibility = View.VISIBLE
            binding.txt.text = "Temperature: ${deviceData.TempC_SHT}C°"
            // ...
        }
    }
}