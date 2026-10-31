package com.routebarber.model

data class Cita(
    val id: Int,
    val barbero: Barbero,
    val servicio: Servicio,
    val fecha: String,
    val hora: String,
    val estado: String
)