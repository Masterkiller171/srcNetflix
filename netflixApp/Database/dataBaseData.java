package netflixApp.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class dataBaseData {
    private Connection conn;
    private Statement st;
    private ResultSet rs;

    public dataBaseData() {
        conn = new connector().getCon();

        try {
            this.st = conn.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> getDistinctSeriesTitle(){
        ArrayList<String> films = new ArrayList<>();

        try {
           this.rs = this.st.executeQuery("select serie FROM serie$");

            while (rs.next()){
                films.add(rs.getString(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return films;
    }
}
