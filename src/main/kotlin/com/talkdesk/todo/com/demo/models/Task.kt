package com.talkdesk.todo.com.demo.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Task (
        @Id
        val id: String = UUID.randomUUID().toString(),
        val name: String,
        val status: Boolean
)