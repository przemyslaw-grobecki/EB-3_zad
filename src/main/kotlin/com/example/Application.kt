package com.example

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.client.plugins.contentnegotiation.*
import kotlinx.serialization.Serializable
import io.ktor.serialization.kotlinx.json.*

@Serializable
data class Message(val content: String)

suspend fun main() {
    val channelId = "1047551051454234787" // Replace with your Discord channel ID
    val token = "MTA5Nzg4MzkzOTg2OTI5ODgxOA.GW-yzq.LgNoThtikMkta0jAnGPR6WMzXJg9XrZ2vsNn60" // Replace with your bot token
    val httpClient = HttpClient(CIO)
    {
        install(ContentNegotiation)
        {
            json()
        }
    }
    httpClient.request("https://discord.com/api/v10/channels/$channelId/messages")
    {
        method = HttpMethod.Post
        header("Authorization", "Bot $token")
        contentType(ContentType.Application.Json)
        setBody(Message("Hello world!"))
    }
}