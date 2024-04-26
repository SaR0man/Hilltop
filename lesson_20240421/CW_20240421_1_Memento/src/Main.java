
import java.util.Random;
import java.util.Stack;

class Location {
    public int X;
    public int Y;

    public Location(int x, int y) {
        X = x;
        Y = y;
    }

    @Override
    public String toString() {
        return "X : " + X + " , Y = " + Y;
    }
}

enum Direction {
    UP, DOWN, LEFT, RIGHT
}

class Player {
    public int HP = 100;
    public int Stamina = 100;
    public Location location;

    public Player() {
        this.location = new Location(0, 0);
    }

    public void move(Direction direction) {
        switch (direction) {
            case UP:
                location.Y++;
                break;
            case DOWN:
                location.Y--;
                break;
            case LEFT:
                location.X--;
                break;
            case RIGHT:
                location.X++;
                break;
        }
    }

    public void attack() {
        Random random = new Random();
        Stamina -= random.nextInt(10) + 5;
    }

    public void takeDamage() {
        Random random = new Random();
        HP -= random.nextInt(20) + 10;
    }

    public void info() {
        System.out.println("HP       : " + HP);
        System.out.println("Stamina  : " + Stamina);
        System.out.println("Location : " + location);
        System.out.println("---------------------------");
    }

    //Save
    public PlayerMemento save() {
        return new PlayerMemento(this.HP, this.Stamina, this.location.X,this.location.Y);
    }

    //Load
    public void load(PlayerMemento playerMemento) {
        this.HP = playerMemento.HP;
        this.location.X = playerMemento.location.X;
        this.location.Y = playerMemento.location.Y;
        this.Stamina = playerMemento.Stamina;
    }
}

class PlayerMemento {
    public int HP;
    public int Stamina;
    public Location location;

    public PlayerMemento(int HP, int stamina, int x , int y) {
        this.HP = HP;
        Stamina = stamina;
        this.location = new Location(x,y);
    }
}

class PlayerSaves {
    private Player player;
    private Stack<PlayerMemento> saves;//LIFO  Last-in-first-out

    public PlayerSaves(Player player) {
        this.player = player;
        saves = new Stack<>();
    }

    public void savePlayer() {
        PlayerMemento memento = player.save();
        saves.push(memento);
    }

    public void loadPlayer() {
        PlayerMemento memento = saves.pop();
        player.load(memento);
    }

}

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        PlayerSaves playerSaves = new PlayerSaves(player);
        player.info();
        playerSaves.savePlayer();

        player.attack();
        player.takeDamage();
        player.move(Direction.UP);
        player.move(Direction.RIGHT);
        player.move(Direction.RIGHT);
        player.move(Direction.DOWN);
        player.attack();
        player.attack();
        player.info();
        playerSaves.savePlayer();

        player.attack();
        player.takeDamage();
        player.move(Direction.UP);
        player.move(Direction.RIGHT);
        player.move(Direction.LEFT);
        player.move(Direction.LEFT);
        player.move(Direction.LEFT);
        player.move(Direction.LEFT);
        player.move(Direction.LEFT);
        player.move(Direction.LEFT);
        player.move(Direction.DOWN);
        player.attack();
        player.attack();
        player.info();
        playerSaves.savePlayer();

        player.attack();
        player.takeDamage();
        player.move(Direction.UP);
        player.move(Direction.RIGHT);
        player.move(Direction.RIGHT);
        player.move(Direction.UP);
        player.attack();
        player.attack();
        player.info();
        playerSaves.savePlayer();

        System.out.println("\n\n\nGame Over\n\n");

        System.out.println("Load 1.......");
        playerSaves.loadPlayer();
        player.info();

        System.out.println("Load 2.......");
        playerSaves.loadPlayer();
        player.info();

        System.out.println("Load 3.......");
        playerSaves.loadPlayer();
        player.info();

        System.out.println("Load 4.......");
        playerSaves.loadPlayer();
        player.info();
    }
}
