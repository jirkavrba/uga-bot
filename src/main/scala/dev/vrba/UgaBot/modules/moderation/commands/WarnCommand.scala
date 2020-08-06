package dev.vrba.UgaBot.modules.moderation.commands

import dev.vrba.UgaBot.commands.{Command, CommandScope, GuildScope}
import discord4j.core.event.domain.message.MessageCreateEvent

class WarnCommand extends Command {
  override val name: String = "warn"
  override val aliases: Array[String] = Array("w")
  override val scope: CommandScope = GuildScope()

  override def execute(event: MessageCreateEvent): Unit = {
  }
}
