package com.electric.dragino.domain

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Network {
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    fun online(deviceId:String):DatabaseReference{
        return database.reference.child("devices").child(deviceId)
    }
}