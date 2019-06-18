package TableFile;

public class Main {
    static public void main(String[]args){
        CSV table = new CSV();
        table.addColumn("id");
        table.addColumn("name");
        table.addColumn("year");
        table.addRow(new String[]{"1","name12", "2001"});
        table.addRow(new String[]{"2","name2", "2002"});
        table.addRow(new String[]{"3","titleName3", "2003"});
        table.addRow(new String[]{"11","name4", "2004"});
        String file = "table.csv";
        table.save(file);
        table.load(file);
        table.show();

    }
}
