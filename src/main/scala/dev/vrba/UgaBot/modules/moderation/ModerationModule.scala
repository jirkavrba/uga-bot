package dev.vrba.UgaBot.modules.moderation

import dev.vrba.UgaBot.UgaBotModule
import dev.vrba.UgaBot.commands.CommandDispatcher
import dev.vrba.UgaBot.modules.moderation.commands.WarnCommand
import discord4j.core.GatewayDiscordClient
import org.springframework.stereotype.Service

@Service
class ModerationModule extends UgaBotModule {

  override val name: String = "Moderation"

  override def register(client: GatewayDiscordClient): Unit = {
    val dispatcher = new CommandDispatcher(Array(new WarnCommand))

    dispatcher.bindTo(client)
  }
}
