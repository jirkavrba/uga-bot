package dev.vrba.UgaBot

import discord4j.core.GatewayDiscordClient
import org.springframework.stereotype.Service

@Service
trait UgaBotModule {

  val name: String

  // Register the module and subscribe to the events within the gateway event stream
  def register(client: GatewayDiscordClient): Unit
}
