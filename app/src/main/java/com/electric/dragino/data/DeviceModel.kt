package com.electric.dragino.data

data class DeviceModel(
    val BatV: Double? = 0.0,
    val Bat_Status: Int? = 0,
    val Ext_Sensor: String? = "",
    val Hum_SHT: Double? = 0.0,
    val TempC_DS: Int? = 0,
    val TempC_SHT: Double? = 0.0,
    val time: String? = ""
)