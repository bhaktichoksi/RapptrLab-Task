package com.datechnologies.androidtest.api

/**
 * A data model that represents a chat log message fetched from the D & A Technologies Web Server.
 */
data class ChatLogMessageModel(
    val user_id: Int?,
    val avatar_url: String?,
    val name: String?,
    val message: String?
)

