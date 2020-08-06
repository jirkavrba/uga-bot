package dev.vrba.UgaBot.commands

sealed trait CommandScope

case class GuildScope() extends CommandScope
case class DirectMessagesScope() extends CommandScope
case class Everywhere() extends CommandScope
