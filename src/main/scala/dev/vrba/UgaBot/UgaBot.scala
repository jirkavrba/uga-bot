package dev.vrba.UgaBot

import org.springframework.boot.{CommandLineRunner, SpringApplication}
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class UgaBot extends CommandLineRunner {
  // The application entry point
  override def run(args: String*): Unit = {
    println("Hello from Spring boot")
  }
}

object UgaBot {
  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[UgaBot], args: _*)
  }
}