package com.example.practiceproject.app.common

data class ErrorResolution(val resolutionType: ResolutionType, val errorMessage: String)

enum class ResolutionType {
    TEST, TEST1, TEST2
}
