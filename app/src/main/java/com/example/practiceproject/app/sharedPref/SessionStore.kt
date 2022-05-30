package com.example.practiceproject.app.sharedPref

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SessionStore @Inject constructor(@ApplicationContext context: Context) {
    companion object {
        const val FILE_NAME = "SessionStore"
        const val KEY_ACCESS_TOKEN = "KEY_ACCESS_TOKEN"
        const val KEY_REFRESH_TOKEN = "KEY_REFRESH_TOKEN"
    }

    private val file = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    var accessToken: String
        get() = file.getString(KEY_ACCESS_TOKEN, "") ?: ""
        set(value) = file.edit { putString(KEY_ACCESS_TOKEN, value).commit() }

    var refreshToken: String
        get() = file.getString(KEY_REFRESH_TOKEN, "") ?: ""
        set(value) = file.edit { putString(KEY_REFRESH_TOKEN, value).commit() }

    fun clear() {
        file.edit().clear().commit()
    }
}