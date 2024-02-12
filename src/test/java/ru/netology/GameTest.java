package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game = new Game();

    @Test
    public void FirstPlayerNotRegistered() {
        Player player1 = new Player(1, "Петя", 150);
        Player player2 = new Player(2, "Коля", 175);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Вася", "Коля");
        });
    }

    @Test
    public void SecondPlayersNotRegistered() {
        Player player1 = new Player(1, "Петя", 150);
        Player player2 = new Player(2, "Коля", 175);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Петя", "Толя");
        });
    }

    @Test
    public void whenFirstPlayerWin() {
        Player player1 = new Player(1, "Петя", 150);
        Player player2 = new Player(2, "Коля", 175);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Коля", "Петя");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenSecondPlayerWin() {
        Player player1 = new Player(1, "Петя", 150);
        Player player2 = new Player(2, "Коля", 175);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Петя", "Коля");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenPlayerEquals() {
        Player player1 = new Player(1, "Петя", 150);
        Player player2 = new Player(2, "Коля", 150);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Петя", "Коля");

        Assertions.assertEquals(expected, actual);
    }

}
