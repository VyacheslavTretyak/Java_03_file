package InputAndWrite;

import java.io.*;

public class Main {
    static public void main(String[]args){
        String fileName = "input.txt";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            while(true){
                System.out.print("input: ");
                String data = br.readLine();
                if(data.isEmpty()){
                    break;
                }
                bw.write(data);
                bw.write("\n");
            }
            System.out.println("Save ok!");
            br.close();
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
