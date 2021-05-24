package homework4;

public class TicTacToe {

    static final char empty_cell_sym = '-';
    public static void start(){
        char [][] field= {
                {empty_cell_sym,empty_cell_sym,empty_cell_sym},
                {empty_cell_sym,empty_cell_sym,empty_cell_sym},
                {empty_cell_sym,empty_cell_sym,empty_cell_sym}
        };
        drawField(field);
    }
}
