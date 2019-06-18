package ArrayRewrite;

import BookFile.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static public void main(String[]args){
        String fileX = "./array_x.txt";
        String fileY = "./array_y.txt";

        try {

            String[] list = read(fileX);
            List<String> l = new ArrayList<>();

            for(int i = 0; i<list.length; i++){
                if((i+1)%2 == 0){
                    l.add(list[i]);
                }
            };
            FileWriter fw = new FileWriter(fileY);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String s:l){
                bw.write(s+"; ");
            }
            bw.close();
            fw.close();

            String[] list2 = read(fileY);
            for(String s:list2){
                System.out.println(s);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    static String[] read(String file){
        String[] arr = null;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            arr = line.split(";");
            for(int i = 0; i<arr.length; i++){
                arr[i] = arr[i].trim();
            };
            br.close();
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return arr;
    }
}
