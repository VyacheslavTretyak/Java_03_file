package BookFile;

import SaveGame.SaveGame;

import java.io.*;

public class Main {
    static public void main(String[]args){
        String file = "./book.txt";

        Book book = new Book();
        book.title = "TitleBook";
        book.author = "Author";
        book.year = "2001";
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(book.toString());
            fw.close();
            System.out.println("Save ok!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
