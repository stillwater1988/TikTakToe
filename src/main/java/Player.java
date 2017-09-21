public class Player {

    private String name;

    public static String NAME_X = "X";

    public static String NAME_O = "O";

    public Player(String name) {
        if (!NAME_X.equals(name) && !NAME_O.equals(name)) {
            name = NAME_X;
        }
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
