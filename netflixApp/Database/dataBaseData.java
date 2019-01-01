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
        return getResultSetOfQuery("SELECT TOP 15 Id FROM seizoen$" + " JOIN seizoen_serie$ ON seizoen_serie$.SeizoenID = seizoen$.seizoenId" + " JOIN serie$ ON seizoen_serie$.SerieID = serie$.serieID" + " WHERE serie$.serie = 'Breaking bad';");
    }

    //Will return all the ids who saw the serie fargo
    public ArrayList<Object> getAllIdsWhoSawFargo(){
        return getResultSetOfQuery("SELECT TOP 15 Id FROM seizoen$" + " JOIN seizoen_serie$ ON seizoen_serie$.SeizoenID = seizoen$.seizoenId" + " JOIN serie$ ON seizoen_serie$.SerieID = serie$.serieID" + " WHERE serie$.serie = 'Fargo';");
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
    public ArrayList<Object> getAllIds(){
        return getResultSetOfQuery("SELECT Id FROM persoon$");
    }

    //-----------------------------------------
    public void uploadAccToDatabase(String age, String language, String genre, String serie, int season){
        String str = String.valueOf(getResultSetOfQuery("SELECT MAX(Id) FROM persoon$;"));
        str = str.replaceAll("\\[", "");
        str = str.replaceAll("]","");

        ArrayList<String> allDataSeason = getRandomAfleveringTitleAndTime(serie, season);
            modifyDB("INSERT INTO persoon$ (Id, Leeftijd, Taal, Genre) VALUES('" + (Float.parseFloat(str) + 1) + "', '" + age + "', '" + language + "', '" + genre + "')");
            modifyDB("INSERT INTO seizoen$ (seizoenId, Id, Aflevering, Titel, Tijdsduur) VALUES('" + season + "', '" + (Float.parseFloat(str) + 1) + "', '" + allDataSeason.get(0) + "', '" + allDataSeason.get(1) + "', '" + allDataSeason.get(2) + "')");
            System.out.println("Inserted " + age + " " + language + " " + genre + " " + serie + " " + season + " " + allDataSeason.get(0) + " " + allDataSeason.get(1) + " " + allDataSeason.get(2));
    }

    private ArrayList<String> getRandomAfleveringTitleAndTime(String serie, int season){
        ArrayList<String> Afleveringen = new ArrayList<>();
        ArrayList<String> Titles = new ArrayList<>();
        ArrayList<String> Times = new ArrayList<>();

        ArrayList<String> AflTitlTim = new ArrayList<>();
        int serieNum = 0;
        switch (serie){
            case "Sherlock":
                serieNum = 1;
            break;
            case "Breaking Bad":
                serieNum = 2;
            break;
            case "Fargo":
                serieNum = 3;
            break;
        }

         ArrayList<Object> objs =  getResultSetOfQuery("SELECT Aflevering FROM seizoen$ WHERE seizoenId =" + "( SELECT SeizoenID FROM seizoen_serie$ WHERE SerieID = '"+ serieNum +"' AND Seizoen = '" + season + "');");
        for (Object obj : objs) {
            Afleveringen.add(String.valueOf(obj));
        }


        objs = getResultSetOfQuery("SELECT Titel FROM seizoen$ WHERE seizoenId =" + "( SELECT SeizoenID FROM seizoen_serie$ WHERE SerieID = '"+ serieNum +"' AND Seizoen = '" + season + "');");
        for (Object obj : objs) {
            Titles.add(String.valueOf(obj));
        }


       objs = getResultSetOfQuery("SELECT Tijdsduur FROM seizoen$ WHERE seizoenId =" + "( SELECT SeizoenID FROM seizoen_serie$ WHERE SerieID = '"+ serieNum +"' AND Seizoen = '" + season + "');");
        for (Object obj : objs) {
            Times.add(String.valueOf(obj));
        }
        int randoNum = (int)(Math.random() * (Afleveringen.size() - 1));

        String afl = Afleveringen.get(randoNum);
        String tit = Titles.get(randoNum);
        String tim = Times.get(randoNum);

        AflTitlTim.add(afl);
        AflTitlTim.add(tit);
        AflTitlTim.add(tim);

        return AflTitlTim;
    }
    //-----------------------------------------
    public void removeIdFromDB(float id){
        modifyDB("DELETE FROM persoon$ WHERE Id = '" + id +"'");
    }

    //-----------------------------------------------------------------------------------
    private ArrayList<Object> getResultSetOfQuery(String query){
        ArrayList<Object> datalist = new ArrayList<>();
        try {
            conn = new connector().getCon();

            this.st = conn.createStatement();
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
    private void modifyDB(String insert){
        try {
            conn = new connector().getCon();

            this.st = conn.createStatement();
            this.st.execute(insert);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
