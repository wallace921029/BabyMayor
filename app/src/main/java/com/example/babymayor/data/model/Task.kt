package com.example.babymayor.data.model

data class Task(
    val id: Int,                    // Unique identifier for the task
    val taskTitle: String,          // Title of the task
    val taskNote: String,           // Note associated with the task
    val taskPriority: Int,          // Priority level of the task
    val taskExpiredDatetime: String // Expiration datetime of the task
)
