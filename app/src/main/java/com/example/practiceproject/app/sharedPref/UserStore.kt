package com.example.practiceproject.app.sharedPref

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class UserStore @Inject constructor(@ApplicationContext context: Context) {

    companion object {

        const val KEY_ACCESS_TOKEN = "KEY_ACCESS_TOKEN"
    }

    private val file = context.getSharedPreferences("UserStore", Context.MODE_PRIVATE)

    var accessToken: String
        get() = file.getString(KEY_ACCESS_TOKEN, "") ?: ""
        set(value) = file.edit {
            this.putString(KEY_ACCESS_TOKEN, value).commit()
        }
}