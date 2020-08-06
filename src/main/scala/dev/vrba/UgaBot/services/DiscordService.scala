package dev.vrba.UgaBot.services

import org.springframework.stereotype.Service

@Service
class DiscordService {
  def start(token: String): Unit = {
    println(s"Starting the application with token [$token]")
  }
}
