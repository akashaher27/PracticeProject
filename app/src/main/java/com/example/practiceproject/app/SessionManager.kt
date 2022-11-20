package com.example.practiceproject.app

import com.example.practiceproject.app.sharedPref.SessionStore

class SessionManager(private val sessionStore: SessionStore) {

    var accessToken: String
        get() = sessionStore.accessToken
        set(value) {
            value.also { sessionStore.accessToken = it }
        }

    fun logout() {
        clearSession()
    }

    private fun clearSession() {
        sessionStore.clear()
    }
}