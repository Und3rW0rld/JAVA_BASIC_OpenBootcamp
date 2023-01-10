package ExcerciceNine;

public class infoGames {
    public int position;
    public String name;
    public String score;
    public infoGames(){}
    public infoGames(int position, String name, String score){
       this.position = position;
       this.name = name;
       this.score = score;
    }

    public int getScore() {
        return Integer.parseInt(score);
    }

    public String getName() {
        return name;
    }
}
