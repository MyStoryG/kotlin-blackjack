package blackjack.domain.player

import blackjack.domain.DrawDecider
import blackjack.domain.card.Card
import blackjack.domain.card.Hands

class Player(val playerName: PlayerName) {
    val hands = Hands(mutableListOf())

    fun draw(card: Card, decider: DrawDecider) {
        if (canDraw() && decider.isDraw()) {
            hands.draw(card)
        }
    }

    fun canDraw() = hands.calculateScore() <= DRAW_CONDITION

    fun calculateScore() = hands.calculateScore()

    companion object {
        private const val DRAW_CONDITION = 21
    }
}