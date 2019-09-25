package com.talkdesk.todo.com.demo.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class APIController {

    @GetMapping("/")
    fun all(): String {
        return "Hello"
    }

}