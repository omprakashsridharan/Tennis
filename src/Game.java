public class Game {
    Player A;
    Player B;
    String gameString;
    final int[] pointsMap = new int[]{0,15,30,40};

    public Game(Player a, Player b,String gameString) {
        A = a;
        B = b;
        this.gameString = gameString;

    }

    public void initializeGame(){
        for(char c: gameString.toCharArray()){
            updateScoreBoard(c);
        }
    }

    public void updateScoreBoard(char c){
        updatePoints(c);
        updateGames();
        updateSets();
    }

    private void updatePoints(char c) {
        if(c == A.getName()){
            A.setPoints(A.getPoints()+1);
        }else {
            B.setPoints(B.getPoints()+1);
        }
    }

    private void updateGames() {
        if(hasMinTwoDifference(A.getPoints(),B.getPoints()) && A.getPoints()>3){
            resetPoints();
            A.setGames(A.getGames()+1);
        }

        else if(hasMinTwoDifference(B.getPoints(),A.getPoints()) && B.getPoints()>3){
            resetPoints();
            B.setGames(B.getGames()+1);
        }
    }

    private void resetPoints() {
        A.setPoints(0);
        B.setPoints(0);
    }

    private void updateSets() {
        if(hasMinTwoDifference(A.getGames(),B.getGames()) && A.getGames()>5){
            resetGames();
            A.setSets(A.getSets()+1);
        }

        else if(hasMinTwoDifference(B.getGames(),A.getGames()) && B.getGames()>5){
            resetGames();
            B.setSets(B.getSets()+1);
        }
    }

    private void resetGames() {
        A.setGames(0);
        B.setGames(0);
    }

    public String generateScoreBoard(){
        StringBuilder sb = new StringBuilder();
        sb.append("Players: \t"+A.getName()+"\t"+B.getName());
        sb.append("\n");
        sb.append("Games:   \t"+A.getSets()+"\t"+B.getSets());
        sb.append("\n");
        sb.append("Sets:    \t"+A.getGames()+"\t"+B.getGames());
        sb.append("\n");
        if(A.getPoints()<4 && B.getPoints()<4 )
            sb.append("Points:  \t"+pointsMap[A.getPoints()]+"\t"+pointsMap[B.getPoints()]+"\n");
        else if(A.getPoints() == B.getPoints())
            sb.append("Points:  \t"+pointsMap[3]+"\t"+pointsMap[3]+"\n");
        else if(A.getPoints() > B.getPoints())
            sb.append("Points:  \t"+"Adv"+"\t"+pointsMap[3]+"\n");
        else if(A.getPoints() == B.getPoints())
            sb.append("Points:  \t"+pointsMap[3]+"\t"+"Adv"+"\n");

        return sb.toString();
    }

    public boolean hasMinTwoDifference(int a,int b){
        return a-b >= 2;
    }
}
