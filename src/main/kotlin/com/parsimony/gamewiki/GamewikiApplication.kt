package com.parsimony.gamewiki

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GamewikiApplication

fun main(args: Array<String>) {
    runApplication<GamewikiApplication>(*args)
}
