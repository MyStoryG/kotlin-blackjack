package blackjack.dto

import blackjack.Player

class PlayersDto(private val players: List<Player>) {

    fun showPlayerNames() {
        val names = players.map { it.name }
            .toMutableList()
            .joinToString(",")
        println("%s에게 2장의 나누었습니다.".format(names))
    }

    fun showInitCards() {
        players.forEach {
            println("%s카드: %s".format(it.name, it.cards.map { c -> c.show() }))
        }
    }
}