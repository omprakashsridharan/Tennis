import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TennisTest {

    @Test
    void main() {
        Player A = new Player('A');
        Player B = new Player('B');
        Game game = new Game(A,B,"AAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBBBBBBBAAAABBBB");
        game.initializeGame();
        System.out.println(game.generateScoreBoard());
        assertTrue(game.A.getGames() == 6);

    }
}