package org.nagarro;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameTest {


    @Test
    public void GameReturnsFiveResults() {
        Game game = new Game();
        List<Integer> result = game.nextRoll();
        Assertions.assertThat(result).hasSize(5);
    }

    @Test
    public void rerolledDicesReturnsEightAsScore() {
        Game game = new Game();
        assertThat(game.selectPair()).isEqualTo(8);
    }
    @Test
    public void rerolledDicesReturnsFourAsScore() {
        Game game = new Game();
        assertThat(game.selectPair()).isEqualTo(4);
    }


}
