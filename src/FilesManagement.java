import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FilesManagement {

    private static final int COLOR_BLACK = 0;
    private static final int COLOR_WHITE = 1;
    private static final int COLOR_RED   = 2;
    private static final int COLOR_GREEN = 3;
    private static final int COLOR_BLUE  = 4;

    public void save(JPanel cells[]){
        try{
            PrintWriter writer = new PrintWriter(new FileWriter("img.txt"));
            Color bg;
            for (int i = 0; i < cells.length; i++) {
                bg = cells[i].getBackground();
                if (bg == Color.BLACK)
                    writer.print(COLOR_BLACK);
                else if (bg == Color.WHITE)
                    writer.print(COLOR_WHITE);
                else if (bg == Color.RED)
                    writer.print(COLOR_RED);
                else if (bg == Color.GREEN)
                    writer.print(COLOR_GREEN);
                else if (bg == Color.BLUE)
                    writer.print(COLOR_BLUE);
            }
            writer.close();

        }
        catch(IOException e){
            System.err.println("Can not save file");
        }

    }
    public void open(JPanel cells[]){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("img.txt"));

            String line = reader.readLine();
            int currNum;
            for (int i = 0; i < line.length(); i++) {
                currNum = Character.getNumericValue(line.charAt(i));

                if (currNum == COLOR_BLACK)
                    cells[i].setBackground(Color.BLACK);
                else if (currNum == COLOR_WHITE)
                    cells[i].setBackground(Color.WHITE);
                else if (currNum == COLOR_RED)
                    cells[i].setBackground(Color.RED);
                else if (currNum == COLOR_GREEN)
                    cells[i].setBackground(Color.GREEN);
                else if (currNum == COLOR_BLUE)
                    cells[i].setBackground(Color.BLUE);
            }

            reader.close();
        }
        catch(IOException e){
            System.err.println("Can not open file");
        }

    }
}