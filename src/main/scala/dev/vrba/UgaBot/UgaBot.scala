package dev.vrba.UgaBot

import dev.vrba.UgaBot.services.DiscordService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.{CommandLineRunner, SpringApplication}
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class UgaBot @Autowired()(private val discordService: DiscordService) extends CommandLineRunner {
  // The application entry point
  override def run(args: String*): Unit = {
    if (args.isEmpty)
      throw new IllegalArgumentException("The application requires passing the Discord bot token as the first argument.")

    else
      discordService.start(args.head)
  }
}

object UgaBot {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[UgaBot], args: _*)
  }
}