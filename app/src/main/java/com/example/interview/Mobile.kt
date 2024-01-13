package com.example.interview

import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

interface Mobile {
    fun getCamera()
}


@Singleton
class Vivo @Inject constructor():Mobile{
    override fun getCamera() {
        Util.showMassage("Vivo Mobile")
    }

}

class Redmi @Inject constructor() :Mobile{
    override fun getCamera() {
        Util.showMassage("Redmi Mobile")
    }
}

class Motorola: Mobile{
    override fun getCamera() {
        Util.showMassage("Motorola Mobile")
    }
}