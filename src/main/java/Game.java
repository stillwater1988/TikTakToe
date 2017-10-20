public class Game {

    public static final String NONE = "NONE";

    private TicTacToeBoard board = null;

    private String previousPlayer = "";

    private String winner = "";

    private Boolean over = false;

    public Game () {
        this.setBoard(new TicTacToeBoard());
    }

    public void move(String currentPlayer, int col, int row) {
        String value = getBoard().getValue(col, row);
        if (value != null && !"".equals(value)) {
            throw new CellNotEmptyException();
        }
        if (getPreviousPlayer().equals(currentPlayer)) {
            throw new WrongSequenceException();
        }
        getBoard().setValue(currentPlayer, col, row);
        setPreviousPlayer(currentPlayer);
        recalculate();
    }

    private void recalculate() {

        String winner = "";

        // row 1 wins
        if (getBoard().getBoard().get(1).get(1)
                .equals(getBoard().getBoard().get(1).get(2))
            && getBoard().getBoard().get(1).get(1)
                .equals(getBoard().getBoard().get(1).get(3))
            && !isOver()) {
            winner = getBoard().getBoard().get(1).get(1);
            if (!"".equals(winner)) {
                setOver(true);
            }
        }

        // row 2 wins
        if (getBoard().getBoard().get(2).get(1)
                .equals(getBoard().getBoard().get(2).get(2))
                && getBoard().getBoard().get(2).get(1)
                .equals(getBoard().getBoard().get(2).get(3))
                && !isOver()) {
            winner = getBoard().getBoard().get(2).get(1);
            if (!"".equals(winner)) {
                setOver(true);
            }
        }

        // row 3 wins
        if (getBoard().getBoard().get(3).get(1)
                .equals(getBoard().getBoard().get(3).get(2))
                && getBoard().getBoard().get(3).get(1)
                .equals(getBoard().getBoard().get(3).get(3))
                && !isOver()) {
            winner = getBoard().getBoard().get(3).get(1);
            if (!"".equals(winner)) {
                setOver(true);
            }
        }

        // col 1 wins
        if (getBoard().getBoard().get(1).get(1)
                .equals(getBoard().getBoard().get(2).get(1))
                && getBoard().getBoard().get(1).get(1)
                .equals(getBoard().getBoard().get(3).get(1))
                && !isOver()) {
            winner = getBoard().getBoard().get(1).get(1);
            if (!"".equals(winner)) {
                setOver(true);
            }
        }

        // col 2 wins
        if (getBoard().getBoard().get(1).get(2)
                .equals(getBoard().getBoard().get(2).get(2))
                && getBoard().getBoard().get(1).get(2)
                .equals(getBoard().getBoard().get(3).get(2))
                && !isOver()) {
            winner = getBoard().getBoard().get(1).get(2);
            if (!"".equals(winner)) {
                setOver(true);
            }
        }

        // col 3 wins
        if (getBoard().getBoard().get(1).get(3)
                .equals(getBoard().getBoard().get(2).get(3))
                && getBoard().getBoard().get(1).get(3)
                .equals(getBoard().getBoard().get(3).get(3))
                && !isOver()) {
            winner = getBoard().getBoard().get(1).get(3);
            if (!"".equals(winner)) {
                setOver(true);
            }
        }

        // diag 1 wins
        if (getBoard().getBoard().get(1).get(1)
                .equals(getBoard().getBoard().get(2).get(2))
                && getBoard().getBoard().get(1).get(1)
                .equals(getBoard().getBoard().get(3).get(3))
                && !isOver()) {
            winner = getBoard().getBoard().get(1).get(1);
            if (!"".equals(winner)) {
                setOver(true);
            }
        }

        // diag 2 wins
        if (getBoard().getBoard().get(1).get(3)
                .equals(getBoard().getBoard().get(2).get(2))
                && getBoard().getBoard().get(1).get(3)
                .equals(getBoard().getBoard().get(3).get(1))
                && !isOver()) {
            winner = getBoard().getBoard().get(1).get(3);
            if (!"".equals(winner)) {
                setOver(true);
            }
        }

        if (!isOver()) {
            Boolean gameover = true;
            for (int i = 1; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    if ("".equals(getBoard().getValue(i, j))) {
                        gameover = false;
                    }
                }
            }
            setOver(gameover);
            winner = "NONE";
        }

        setWinner(winner);
    }

    public boolean isOver() {
        return this.over;
    }

    public String getWinner() {
        return this.winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setOver(Boolean over) {
        this.over = over;
    }

    public TicTacToeBoard getBoard() {
        return board;
    }

    public void setBoard(TicTacToeBoard board) {
        this.board = board;
    }

    public void setPreviousPlayer(String previousPlayer) {
        this.previousPlayer = previousPlayer;
    }

    public String getPreviousPlayer() {
        return previousPlayer;
    }

}
