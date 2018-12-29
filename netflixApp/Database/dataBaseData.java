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

    public ArrayList<Object> getDistinctSeriesTitle(){
        return getResultSetOfQuery("SELECT DISTINCT serie FROM serie$;");
    }

    public ArrayList<Object> getTop15EpisodesTitle(){
        return getResultSetOfQuery("SELECT TOP 15 Titel FROM seizoen$;");
    }

    public ArrayList<Object> getAllDistinctLanguages(){
        return getResultSetOfQuery("SELECT Taal FROM (SELECT Taal FROM persoon$ UNION SELECT Taal FROM film$) t3 ORDER BY Taal;");
    }

    public ArrayList<Object> getAllDistinctGenres(){
        return getResultSetOfQuery("SELECT DISTINCT Genre FROM persoon$;");
    }

    public ArrayList<Object> getAllIdsWhoSawSherlock(){
        return getResultSetOfQuery("SELECT Id FROM seizoen$" + " JOIN seizoen_serie$ ON seizoen_serie$.SeizoenID = seizoen$.seizoenId" + " JOIN serie$ ON seizoen_serie$.SerieID = serie$.serieID" + " WHERE serie$.serie = 'Sherlock';");
    }

    public ArrayList<Object> getAllIdsWhoSawBreakingBad(){
        return getResultSetOfQuery("SELECT Id FROM seizoen$" + " JOIN seizoen_serie$ ON seizoen_serie$.SeizoenID = seizoen$.seizoenId" + " JOIN serie$ ON seizoen_serie$.SerieID = serie$.serieID" + " WHERE serie$.serie = 'Breaking bad';");
    }

    public ArrayList<Object> getAllIdsWhoSawFargo(){
        return getResultSetOfQuery("SELECT Id FROM seizoen$" + " JOIN seizoen_serie$ ON seizoen_serie$.SeizoenID = seizoen$.seizoenId" + " JOIN serie$ ON seizoen_serie$.SerieID = serie$.serieID" + " WHERE serie$.serie = 'Fargo';");
    }

    private ArrayList<Object> getResultSetOfQuery(String query){
        ArrayList<Object> datalist = new ArrayList<>();
        try {
            this.rs = this.st.executeQuery(query);

            while (rs.next()){
                datalist.add(rs.getString(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return datalist;
    }
}
