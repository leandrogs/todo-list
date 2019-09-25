package com.talkdesk.todo.com.demo.repositories

import com.talkdesk.todo.com.demo.models.Task
import org.springframework.data.repository.CrudRepository

interface TaskRepository: CrudRepository<Task, String> {
}