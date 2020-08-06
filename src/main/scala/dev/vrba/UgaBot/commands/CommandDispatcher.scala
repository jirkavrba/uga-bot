package dev.vrba.UgaBot.commands

import discord4j.core.GatewayDiscordClient
import discord4j.core.event.domain.message.MessageCreateEvent
import reactor.core.scala.publisher.{Flux, Mono}

class CommandDispatcher(private val commands: Array[Command]) {

  // The prefix that needs to be before every command to trigger its execution
  private val prefix = "~"

  private def handle(event: MessageCreateEvent): Unit = {
    // Just print the message
    println(event.getMessage.getContent)
  }

  def bindTo(client: GatewayDiscordClient): Unit = {
    client.getEventDispatcher
      .on(classOf[MessageCreateEvent])
      // Message starts with the defined command prefix
      .filter(event => event.getMessage.getContent.startsWith(this.prefix))
      // And its sender is not a bot
      .filter(event => event.getMember.map(user => !user.isBot).orElse(false))
      .subscribe(event => this.handle(event))
  }
}
