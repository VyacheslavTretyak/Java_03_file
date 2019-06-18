package BookFile;

import java.io.Serializable;

public class Book implements Serializable {
    public String title;
    public String author;
    public String year;

    @Override
    public String toString() {
        return "title: "+title+", author: "+author+", year: "+year+"\n";
    }
}
