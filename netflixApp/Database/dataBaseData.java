package netflixApp.Database;

import netflixApp.GUI.Interface;

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

    //Will return all distinct titles from the serie table in the database
    public ArrayList<Object> getDistinctSeriesTitle(){
        return getResultSetOfQuery("SELECT DISTINCT serie FROM serie$;");
    }

    //Will return the top 15 title from the seizoen table
    public ArrayList<Object> getTop15EpisodesTitle(){
        return getResultSetOfQuery("SELECT TOP 15 Titel FROM seizoen$;");
    }

    //Will return all of the distinct languages from tables persoon and film
    public ArrayList<Object> getAllDistinctLanguages(){
        return getResultSetOfQuery("SELECT Taal FROM (SELECT Taal FROM persoon$ UNION SELECT Taal FROM film$) t3 ORDER BY Taal;");
    }

    //Will return all the distinct genres in the persoon table
    public ArrayList<Object> getAllDistinctGenres(){
        return getResultSetOfQuery("SELECT DISTINCT Genre FROM persoon$;");
    }

    //-----------------------------------------
    //Will return all the ids who saw the serie sherlock
    public ArrayList<Object> getAllIdsWhoSawSherlock(){
        return getResultSetOfQuery("SELECT Id FROM seizoen$" + " JOIN seizoen_serie$ ON seizoen_serie$.SeizoenID = seizoen$.seizoenId" + " JOIN serie$ ON seizoen_serie$.SerieID = serie$.serieID" + " WHERE serie$.serie = 'Sherlock';");
    }

    //Will return all the ids who saw the serie breaking bad
    public ArrayList<Object> getAllIdsWhoSawBreakingBad(){
        return getResultSetOfQuery("SELECT Id FROM seizoen$" + " JOIN seizoen_serie$ ON seizoen_serie$.SeizoenID = seizoen$.seizoenId" + " JOIN serie$ ON seizoen_serie$.SerieID = serie$.serieID" + " WHERE serie$.serie = 'Breaking bad';");
    }

    //Will return all the ids who saw the serie fargo
    public ArrayList<Object> getAllIdsWhoSawFargo(){
        return getResultSetOfQuery("SELECT Id FROM seizoen$" + " JOIN seizoen_serie$ ON seizoen_serie$.SeizoenID = seizoen$.seizoenId" + " JOIN serie$ ON seizoen_serie$.SerieID = serie$.serieID" + " WHERE serie$.serie = 'Fargo';");
    }

    //-----------------------------------------
    //Will return the count of the the ids who saw the serie sherlock
    public ArrayList<Object> getCountOfIdsWhoSawSherlock(){
        return getResultSetOfQuery("SELECT COUNT(Id) FROM seizoen$" + " JOIN seizoen_serie$ ON seizoen_serie$.SeizoenID = seizoen$.seizoenId" + " JOIN serie$ ON seizoen_serie$.SerieID = serie$.serieID" + " WHERE serie$.serie = 'Sherlock';");
    }

    //Will return the count of the the ids who saw the serie breaking bad
    public ArrayList<Object> getCountOfIdsWhoSawBreakingBad(){
        return getResultSetOfQuery("SELECT COUNT(Id) FROM seizoen$" + " JOIN seizoen_serie$ ON seizoen_serie$.SeizoenID = seizoen$.seizoenId" + " JOIN serie$ ON seizoen_serie$.SerieID = serie$.serieID" + " WHERE serie$.serie = 'Breaking bad';");
    }

    //Will return the count of the ids who saw the serie fargo
    public ArrayList<Object> getCountOfIdsWhoSawFargo(){
        return getResultSetOfQuery("SELECT COUNT(Id) FROM seizoen$" + " JOIN seizoen_serie$ ON seizoen_serie$.SeizoenID = seizoen$.seizoenId" + " JOIN serie$ ON seizoen_serie$.SerieID = serie$.serieID" + " WHERE serie$.serie = 'Fargo';");
    }

    //-----------------------------------------
    public  ArrayList<Object> getCount6Jaar(){
        return getResultSetOfQuery("SELECT  COUNT(Leeftijd) " + "FROM (   SELECT Leeftijd FROM persoon$ WHERE Leeftijd = '6 jaar en ouder'" + " UNION all" + " SELECT Leeftijd FROM film$ WHERE Leeftijd = '6 jaar en ouder') leefTijd;");
    }

    public  ArrayList<Object> getCount12Jaar(){
        return getResultSetOfQuery("SELECT  COUNT(Leeftijd) " + "FROM (   SELECT Leeftijd FROM persoon$ WHERE Leeftijd = '12 jaar en ouder'" + " UNION all" + " SELECT Leeftijd FROM film$ WHERE Leeftijd = '12 jaar en ouder') leefTijd;");
    }

    public  ArrayList<Object> getCount16Jaar(){
        return getResultSetOfQuery("SELECT  COUNT(Leeftijd) " + "FROM (   SELECT Leeftijd FROM persoon$ WHERE Leeftijd = '16 jaar en ouder'" + " UNION all" + " SELECT Leeftijd FROM film$ WHERE Leeftijd = '16 jaar en ouder') leefTijd;");
    }

    public  ArrayList<Object> getCount18Jaar(){
        return getResultSetOfQuery("SELECT  COUNT(Leeftijd) " + "FROM (   SELECT Leeftijd FROM persoon$ WHERE Leeftijd = '18 jaar en ouder'" + " UNION all" + " SELECT Leeftijd FROM film$ WHERE Leeftijd = '18 jaar en ouder') leefTijd;");
    }

    //----------------------------------------
    public ArrayList<Object> getCountLijktOpFargo(){
        return getResultSetOfQuery("SELECT COUNT([lijkt een beetje op]) FROM persoon$ WHERE [lijkt een beetje op] = 'Fargo';");
    }

    public ArrayList<Object> getCountLijktOpBreakingBad(){
        return getResultSetOfQuery("SELECT COUNT([lijkt een beetje op]) FROM persoon$ WHERE [lijkt een beetje op] = 'Breaking Bad';");
    }

    //-----------------------------------------
    public ArrayList<Object> getCountGenresDetective(){
        return getResultSetOfQuery("SELECT COUNT(Genre) FROM persoon$ WHERE Genre = 'Detective';");
    }

    public ArrayList<Object> getCountGenresSpanning(){
        return getResultSetOfQuery("SELECT COUNT(Genre) FROM persoon$ WHERE Genre = 'Spanning';");
    }
    //-----------------------------------------
    public void uploadAccToDatabase(String age, String language, String genre){
        String str = String.valueOf(getResultSetOfQuery("SELECT MAX(Id) FROM persoon$;"));
        str = str.replaceAll("\\[", "");
        str = str.replaceAll("]","");

        setInsertIntoDB("INSERT INTO persoon$ (Id, Leeftijd, Taal, Genre) VALUES('"+ (Float.parseFloat(str) + 1)+ "', '"+ age + "', '" + language + "', '" + genre + "')");
        System.out.println("Inserted " + age + " " + language + " " + genre);
    }

    //-----------------------------------------------------------------------------------
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

    //-----------------------------------------
    private void setInsertIntoDB(String insert){
        try {
            this.st.execute(insert);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
