public class Tennis {
    public static void main(String[] args){
        Player A = new Player('A');
        Player B = new Player('B');
        Game game = new Game(A,B,"ABABABAAB");
        game.initializeGame();
        System.out.println(game.generateScoreBoard());
    }
}
