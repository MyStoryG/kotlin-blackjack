package view

import model.CardNumberCalculator
import model.Dealer
import model.Names
import model.Participant
import model.ProfitCalculator

object ResultView {
    fun showDistributedCard(names: Names) {
        var players = ""
        for ((index, name) in names.values.withIndex()) {
            if (index == 0) {
                players += name
                continue
            }
            players += ", $name"
        }
        println("딜러와 ${players}에게 2장의 카드를 나누었습니다.")
    }

    fun showPlayersCardState(players: List<Participant>) {
        players.forEach { player ->
            showPlayerCardState(player)
        }
    }

    fun showPlayerCardState(player: Participant) {
        var cards = ""
        cards += "${player.name}카드: ${player.cards.joinToString()} ,"
        cards = cards.substring(0, cards.lastIndex - 1)
        println(cards)
    }

    fun showPlayersCardStateResult(players: List<Participant>) {
        players.forEach { player ->
            showPlayerCardStateResult(player)
        }
    }

    fun showPlayerCardStateResult(player: Participant) {
        var playerCardState = "${player.name}카드: ${player.cards.joinToString()} ,"
        playerCardState = playerCardState.substring(
            0,
            playerCardState.lastIndex - 1
        ) + " - 결과: ${CardNumberCalculator.sumCardNumbers(player.cards)}"
        println(playerCardState)
    }

    fun showGameProfitResult(dealer: Dealer, players: List<Participant>) {
        println("\n## 최종 수익")
        showGameDealerProfitResult(dealer, players)
        players.forEach { player ->
            println("${player.name}: ${ProfitCalculator().run(dealer, player)}")
        }
    }

    private fun showGameDealerProfitResult(dealer: Dealer, players: List<Participant>) {
        var dealerProfit = 0
        players.forEach { player ->
            dealerProfit += ProfitCalculator().run(dealer, player)
        }
        println("${dealer.name}: ${-dealerProfit}")
    }

    fun showReceivedCardByDealer() {
        println("딜러는 16이하라 한장의 카드를 더 받았습니다.\n")
    }
}
