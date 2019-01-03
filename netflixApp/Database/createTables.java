package netflixApp.Database;

import java.sql.Connection;
import java.sql.Statement;

public class createTables {
    private Connection conn;

    public createTables(Connection conn) {
        this.conn = conn;
    }

    public void constructDB(){
        try {
            Statement sta = conn.createStatement();
            createDB(sta);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Er is een fout opgelopen met het maken van de database");
        }
    }

    private void createDB(Statement state){
        String condition = "IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES" + " WHERE TABLE_NAME = 'film')  BEGIN";
        String film = " CREATE TABLE [dbo].[film$](" + " [film] [nvarchar](255) NULL," + " [Leeftijd] [nvarchar](255) NULL,"
                + " [Taal] [nvarchar](255) NULL,"
                + " [Tijdsduur] [nvarchar](255) NULL" +
                " ) ON [PRIMARY] SET ANSI_NULLS ON SET QUOTED_IDENTIFIER ON";

        String persoon = " CREATE TABLE [dbo].[persoon$](" +
                "            [Id] [float] NULL," +
                "            [Leeftijd] [nvarchar](255) NULL," +
                "            [Taal] [nvarchar](255) NULL," +
                "            [Genre] [nvarchar](255) NULL," +
                "            [lijkt een beetje op] [nvarchar](255) NULL" +
                "    ) ON [PRIMARY]" +
                "    SET ANSI_NULLS ON" +
                "    SET QUOTED_IDENTIFIER ON create unique index [persoon$_Id_uindex]" +
                "  on [persoon$] (Id)";

        String seizoen = " CREATE TABLE [dbo].[seizoen$](" +
                "            [seizoenId] [float] NOT NULL," +
                "            [Id] [float] NOT NULL," +
                "            [Aflevering] [float] NULL," +
                "            [Titel] [nvarchar](255) NULL," +
                "            [Tijdsduur] [nvarchar](255) NULL" +
                "    ) ON [PRIMARY]" +
                "    SET ANSI_NULLS ON" +
                "    SET QUOTED_IDENTIFIER ON";

        String seizoen_serie = " CREATE TABLE [dbo].[seizoen_serie$](" +
                "            [SerieID] [float] NOT NULL," +
                "            [Seizoen] [float] NOT NULL," +
                "            [SeizoenID] [float] NOT NULL" +
                "    ) ON [PRIMARY]" +
                "    SET ANSI_NULLS ON" +
                "    SET QUOTED_IDENTIFIER ON";

        String serie = " CREATE TABLE [dbo].[serie$](" +
                "            [serieID] [float] NULL," +
                "            [serie] [nvarchar](255) NULL" +
                "    ) ON [PRIMARY]";

        String first20Records = " INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'Sherlock film', N'12 jaar en ouder', N'Engels', N'01:29' )" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'12 jaar en ouder', N'Engels', N'01:34' )" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'16 jaar en ouder', N'Engels-Amerikaans', N'02:34' )" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'18 jaar en ouder', N'Nederlands', N'01:20' )" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'16 jaar en ouder', N'Engels-Amerikaans', N'01:39' )" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'12 jaar en ouder', N'Engels-Amerikaans', N'02:41' )" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'16 jaar en ouder', N'Engels-Amerikaans', N'01:43' )" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'6 jaar en ouder', N'Nederlands', N'01:37' )" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'6 jaar en ouder', N'Duits', N'02:58' )" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'12 jaar en ouder', N'Vlaams', N'01:48' )" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'16 jaar en ouder', N'Engels', N'02:16' )" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (1001, N'12 jaar en ouder', N'Engels', N'Detective', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (1002, N'12 jaar en ouder', N'Engels', N'Detective', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (1003, N'12 jaar en ouder', N'Engels', N'Detective', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (1004, N'12 jaar en ouder', N'Engels', N'Detective', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (1005, N'12 jaar en ouder', N'Engels', N'Detective', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (1006, N'12 jaar en ouder', N'Engels', N'Detective', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (1007, N'12 jaar en ouder', N'Engels', N'Detective', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (1008, N'12 jaar en ouder', N'Engels', N'Detective', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (1009, N'12 jaar en ouder', N'Engels', N'Detective', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2000, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')";

        String next20Records = " INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2001, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2002, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2003, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2004, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2005, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2006, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2007, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2008, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2009, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2010, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2011, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2012, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2013, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2014, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2015, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2016, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2017, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2018, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (2019, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Fargo')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3001, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Breaking Bad')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3002, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Breaking Bad')";

        String nextNext20Records = " INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3003, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Breaking Bad')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3004, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Breaking Bad')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3005, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Breaking Bad')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3006, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Breaking Bad')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3007, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Breaking Bad')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3008, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Breaking Bad')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3009, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Breaking Bad')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3010, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'Breaking Bad')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3101, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'NULL')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3102, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'NULL')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3103, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'NULL')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3105, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'NULL')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3104, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'NULL')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3106, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'NULL')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3107, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'NULL')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3108, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'NULL')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3109, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'NULL')" +
                "    INSERT [dbo].[persoon$] ([Id], [Leeftijd], [Taal], [Genre], [lijkt een beetje op]) VALUES (3110, N'16 jaar en ouder', N'Engels-Amerikaans', N'Spanning', N'NULL')" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (1, 1001, 1, N'A Study in Pink', N'01:28' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (1, 1002, 2, N'The Blind Banker', N'01:28' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (1, 1003, 3, N'The Great Game', N'01:28' )";

        String nextNextNext20Records = " INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (2, 1004, 1, N'A Scandal in Belgravia', N'01:28' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (2, 1005, 2, N'The Hounds of Baskerville', N'01:28' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (2, 1006, 3, N'The Reichenbach Fall', N'01:28' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (3, 1007, 1, N'The Empty Hearse', N'01:28' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (3, 1008, 2, N'The Sign of Three', N'01:28' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (3, 1009, 3, N'His Last Vow', N'01:28' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (4, 2000, 1, N'Pilot', N'00:58' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (4, 2001, 2, N'Cat’s in the Bag…', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (4, 2002, 3, N'…And the Bag’s in the River', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (4, 2003, 4, N'Cancer Man', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (4, 2004, 5, N'Gray Matter', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (4, 2005, 6, N'Crazy Handful of Nothin’', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (4, 2006, 7, N'A No-Rough-Stuff-Type Deal', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2007, 1, N'Seven Thirty-Seven', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2008, 2, N'Grilled', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2009, 3, N'Bit by a Dead Bee', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2010, 4, N'Down', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2011, 5, N'Breakage', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2012, 6, N'Peekaboo', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2013, 7, N'Negro Y Azul', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2014, 8, N'Better Call Saul', N'00:48' )";

        String lastRecords = " INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2015, 9, N'4 Days Out', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2016, 10, N'Over', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2017, 11, N'Mandala', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2018, 12, N'Phoenix', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2019, 13, N'ABQ', N'00:48' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3001, 1, N'The Crocodile''s Dilemma', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3002, 2, N'The Rooster Prince', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3003, 3, N'A Muddy Road', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3004, 4, N'Eating the Blame', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3005, 5, N'The Six Ungraspables', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3006, 6, N'Buridan''s Ass', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3007, 7, N'Who Shaves the Barber?', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3008, 8, N'The Heap', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3009, 9, N'A Fox, a Rabbit, and a Cabbage', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3010, 10, N'Morton''s Fork', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3101, 1, N'Waiting for Dutch', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3102, 1, N'Before the Law', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3103, 1, N'The Myth of Sisyphus', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3105, 1, N'The Gift of the Magi', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3104, 1, N'Fear and Trembling', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3106, 1, N'Rhinoceros', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3107, 1, N'Did you do this? No, you did it!', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3108, 1, N'Loplop', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3109, 1, N'The Castle', N'01:08' )" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3110, 1, N'Palindrome', N'01:08' )" +
                "    INSERT [dbo].[seizoen_serie$] ([SerieID], [Seizoen], [SeizoenID]) VALUES (1, 1, 1)" +
                "    INSERT [dbo].[seizoen_serie$] ([SerieID], [Seizoen], [SeizoenID]) VALUES (1, 2, 2)" +
                "    INSERT [dbo].[seizoen_serie$] ([SerieID], [Seizoen], [SeizoenID]) VALUES (1, 3, 3)" +
                "    INSERT [dbo].[seizoen_serie$] ([SerieID], [Seizoen], [SeizoenID]) VALUES (2, 1, 4)" +
                "    INSERT [dbo].[seizoen_serie$] ([SerieID], [Seizoen], [SeizoenID]) VALUES (2, 2, 5)" +
                "    INSERT [dbo].[seizoen_serie$] ([SerieID], [Seizoen], [SeizoenID]) VALUES (3, 1, 6)" +
                "    INSERT [dbo].[seizoen_serie$] ([SerieID], [Seizoen], [SeizoenID]) VALUES (3, 2, 7)" +
                "    INSERT [dbo].[serie$] ([serieID], [serie]) VALUES (1, N'Sherlock')" +
                "    INSERT [dbo].[serie$] ([serieID], [serie]) VALUES (2, N'Breaking Bad')" +
                "    INSERT [dbo].[serie$] ([serieID], [serie]) VALUES (3, N'Fargo')";

        String finalCondition = "END ELSE PRINT 'Tables already exists';";


        try {
            state.execute(condition + film + persoon + seizoen + seizoen_serie + serie + first20Records + next20Records + nextNext20Records + nextNextNext20Records + lastRecords + finalCondition);
            System.out.println("Db created");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Query kon niet uitgevoerd worden");
        }
    }








}