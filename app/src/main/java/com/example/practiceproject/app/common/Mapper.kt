package com.example.practiceproject.app.common

interface Mapper<out V, in D> {
    fun map(model: D): V
}