package com.example.plugins

import com.example.application.PixApplication
import com.example.presenter.PixRequest
import com.example.presenter.PixResponse
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import java.time.LocalDateTime

fun Application.configureRouting() {

    routing {
        get("/") {
            val req = PixRequest(1,"Maria", LocalDateTime.now(), 1.20 )
            PixApplication().sendMessage(req)
            val r = PixResponse(1,"Maria", LocalDateTime.now(), 1.20 )
            call.respond(r)
        }
    }
}
