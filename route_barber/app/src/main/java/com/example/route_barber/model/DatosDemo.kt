package com.routebarber.model

object DatosDemo {
    val barberos = listOf(
        Barbero(1, "Gael García", "Fade & Barba", 4.9),
        Barbero(2, "Brandon Gutiérrez", "Cortes Clásicos", 4.7),
        Barbero(3, "Luis Ángel Díaz", "Diseños y Color", 4.8)
    )

    val servicios = listOf(
        Servicio(1, "Corte Clásico", 150.0, 30),
        Servicio(2, "Fade + Barba", 250.0, 45),
        Servicio(3, "Tinte / Colorimetría", 400.0, 60)
    )

    val citas = listOf(
        Cita(1, barberos[0], servicios[1], "2026-10-28", "16:00", "Confirmada"),
        Cita(2, barberos[1], servicios[0], "2026-11-15", "11:30", "Pendiente")
    )
}