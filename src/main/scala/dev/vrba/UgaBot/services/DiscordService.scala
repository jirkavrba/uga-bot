package dev.vrba.UgaBot.services

import dev.vrba.UgaBot.UgaBotModule
import discord4j.core.DiscordClientBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DiscordService @Autowired()(private val modules: Array[UgaBotModule]) {

  def start(token: String): Unit = {
    val client = DiscordClientBuilder.create(token)
      .build
      .login
      .block

    // Register all modules
    modules.tapEach {
      module =>
        println(s"Registering module ${module.name}")
        module.register(client)
    }

    // Block the disconnection stream to wait for the client to logout from the gateway
    client
      .onDisconnect
      .block
  }
}
