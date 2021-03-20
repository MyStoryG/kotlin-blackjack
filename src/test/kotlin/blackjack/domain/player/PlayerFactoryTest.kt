package blackjack.domain.player

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

internal class PlayerFactoryTest {
    @DisplayName("플레이어 생성")
    @Test
    fun create() {
        val input = "pobi,jason"
        val users = PlayerFactory.create(input)

        assertAll(
            { assertThat(users.players.size).isEqualTo(2) },
            { assertThat(users.players.map { it.playerName }).containsExactly(PlayerName("pobi"), PlayerName("jason")) }
        )
    }

    @DisplayName("중복된 이름의 플레이어가 있는 경우 예외 발생")
    @Test
    fun validateDuplicatedName() {
        val duplicatedInput = "pobi,pobi"
        assertThrows<IllegalArgumentException> { PlayerFactory.create(duplicatedInput) }
    }
}