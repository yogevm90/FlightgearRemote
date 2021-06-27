package com.example.flightgear

import androidx.appcompat.app.AppCompatActivity
import com.example.flightgear.viewmodels.IJoystickViewModel
import android.os.Bundle
import android.view.View
import com.example.flightgear.models.JoystickModel
import com.example.flightgear.viewmodels.JoystickViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val model: JoystickModel = JoystickModel()
    private val vm: IJoystickViewModel = JoystickViewModel(model)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onConnect(view: View) {
        val ip: String = address_input.text.toString()
        val port: Int = port_input.text.toString().toInt()
        vm.onConnect(ip, port)
        if (vm.isConnected) {
            setContentView(R.layout.joystick)
        }
    }
}