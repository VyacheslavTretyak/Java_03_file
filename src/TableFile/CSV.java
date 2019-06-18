package TableFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSV {
    private int rows;
    private int columns;
    private String [][] table;
    public void addColumn(String title){
        if(rows == 0){
            rows = 1;
        }
        String [][] tmp = table;
        table = new String[rows][++columns];
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns - 1; j++){
                table[i][j] = tmp[i][j];
            }
            if(i == 0) {
                table[i][columns - 1] = title;
            }
        }
    }
    public void addRow(String [] row){
        if(columns == 0){
            System.out.println("You must add column!");
            return;
        }
        String [][] tmp = table;
        table = new String[++rows][columns];
        for(int i = 0; i<rows - 1; i++){
            for(int j = 0; j<columns; j++){
                table[i][j] = tmp[i][j];
            }
        }
        int count = row.length<=columns?row.length:columns;
        for (int i = 0; i<count; i++){
            table[rows-1][i] = row[i];
        }
    }
    public void save(String fileName){
        try {
            FileWriter fw = new FileWriter(fileName);
            for(String[] r:table) {
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < r.length; i++) {
                    str.append(r[i]);
                    if (i < r.length - 1) {
                        str.append(",");
                    }
                }
                str.append("\n");
                fw.write(str.toString());
            }
            fw.close();
            System.out.println("Save ok!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void clear(){
        table = null;
        columns = 0;
        rows = 0;
    }
    public void load(String fileName){
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            clear();
            while(true) {
                String str = br.readLine();
                if (str == null){
                    break;
                }
                String[] row = str.split(",");
                if(rows == 0){
                    for(String s:row){
                        addColumn(s);
                    }
                }else {
                    addRow(row);
                }
            }
            br.close();
            fr.close();
            System.out.println("Load ok!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void show(){
        int len = 0;
        int []lengthArr = new int[columns];
        for(int c = 0; c<columns; c++){
            int max= 0;
            for(int r = 0; r<rows; r++){
                if(table[r][c].length()> max){
                    max = table[r][c].length();
                }
            }
            lengthArr[c] = max;
            len += max;
        }
        len += columns*3+1;
        line(len);
        System.out.print("\n|");
        for(int i = 0; i<columns; i++){
            System.out.print(" ");
            System.out.printf("%"+lengthArr[i]+"s",table[0][i]);
            System.out.print(" |");
        }
        line(len);
        for(int r = 1; r<rows; r++){
            System.out.print("\n|");
            for(int c = 0; c<columns; c++) {
                System.out.print(" ");
                System.out.printf("%" + lengthArr[c] + "s", table[r][c]);
                System.out.print(" |");
            }
        }
        line(len);

    }
    private void line(int len){
        System.out.print("\n");
        for(int i = 0; i<len; i++){
            System.out.print("-");
        }
    }
}
