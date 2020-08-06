package dev.vrba.UgaBot.commands

import discord4j.core.event.domain.message.MessageCreateEvent

trait Command {
  // Name of the command that is used to invoke it like `{prefix}{name} parameters...`
  val name: String

  // Aliases that can be used instead of `{name}`
  val aliases: Array[String]

  // Scope of the command (eg. some commands might not make sense to be executed in direct messages, so they are limited to guilds only)
  val scope: CommandScope

  def execute(event: MessageCreateEvent)
}
