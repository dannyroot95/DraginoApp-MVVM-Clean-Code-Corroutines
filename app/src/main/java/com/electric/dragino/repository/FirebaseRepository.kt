package com.electric.dragino.repository

import com.electric.dragino.data.DeviceModel
import com.electric.dragino.domain.Network
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FirebaseRepository {
    fun getDeviceData(deviceId: String, callback: (DeviceModel?) -> Unit) {
        Network().online(deviceId).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val device = snapshot.getValue(DeviceModel::class.java)
                callback(device)
            }
            override fun onCancelled(error: DatabaseError) {
                callback(null)
            }
        })
    }
}