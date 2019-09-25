package com.talkdesk.todo.com.demo.controllers

import com.talkdesk.todo.com.demo.models.Task
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class APIController {

    @GetMapping("/")
    fun all(): Task {
        val a = Task("123","New Task",false)
        return a
    }

}