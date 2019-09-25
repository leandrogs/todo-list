package com.talkdesk.todo.com.demo.controllers

import com.talkdesk.todo.com.demo.Main
import com.talkdesk.todo.com.demo.models.Task
import com.talkdesk.todo.com.demo.models.todoUpdateDTO
import com.talkdesk.todo.com.demo.repositories.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
class APIController {

    @Autowired
    lateinit var repository: TaskRepository

    @GetMapping("/todos")
    fun all(): MutableIterable<Task> {
        return repository.findAll()
    }

    @PostMapping("/todos")
    fun todos(@RequestBody task: Task): Task {
        repository.save(task)
        return task
    }

    @DeleteMapping("/todos/{id}")
    fun todos(@PathVariable id: String) {
        repository.deleteById(id)
    }

    @PutMapping("/todos/{id}")
    fun todos(@PathVariable id: String, @RequestBody todoUpdate: todoUpdateDTO): ResponseEntity<Task> {
        val task = repository.findById(id).map {
            val name = todoUpdate.name ?: it.name
            val status = todoUpdate.status ?: it.status

            it.copy(name=name, status=status)
        }

        return if ( task.isPresent ) {
            val updated = repository.save(task.get())

            ResponseEntity.ok().body(updated)
        } else {
            ResponseEntity(HttpStatus.NOT_ACCEPTABLE)
        }

    }

}