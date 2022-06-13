package com.example.presenter


import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

class PixRequest(
    val id : Long,
    val name: String,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val register: LocalDateTime,
    val salary : Double
) {
    companion object {
        fun create(id: Long, name: String, register: LocalDateTime,salary : Double): PixRequest {
            return PixRequest(id, name, register, salary )
        }
    }
}