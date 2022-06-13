package com.example.presenter

import java.time.LocalDateTime

class PixResponse(
    val id : Long,
    val name: String,
    val register: LocalDateTime,
    val salary : Double
) {
    companion object {
        fun create(id: Long, name: String, register: LocalDateTime,salary : Double): PixResponse {
            return PixResponse(id, name, register, salary )
        }
    }
}