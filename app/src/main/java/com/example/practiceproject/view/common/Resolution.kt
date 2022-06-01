package com.example.practiceproject.view.common

import com.example.practiceproject.app.common.ServerException

interface Resolution : HttpResolution

interface HttpResolution {
    fun onHttpException(httpException: ServerException)
}