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
        String condition = "IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES" + " WHERE TABLE_NAME = 'film$')  BEGIN";
        String film = " CREATE TABLE [dbo].[film$](" + " [film] [nvarchar](255) NULL," + " [Leeftijd] [nvarchar](255) NULL,"
                + " [Taal] [nvarchar](255) NULL,"
                + " [Tijdsduur] [datetime] NULL" +
                " ) ON [PRIMARY] SET ANSI_NULLS ON SET QUOTED_IDENTIFIER ON";

        String persoon = " CREATE TABLE [dbo].[persoon$](" +
                "            [Id] [float] NULL," +
                "            [Leeftijd] [nvarchar](255) NULL," +
                "            [Taal] [nvarchar](255) NULL," +
                "            [Genre] [nvarchar](255) NULL," +
                "            [lijkt een beetje op] [nvarchar](255) NULL" +
                "    ) ON [PRIMARY]" +
                "    SET ANSI_NULLS ON" +
                "    SET QUOTED_IDENTIFIER ON";

        String seizoen = " CREATE TABLE [dbo].[seizoen$](" +
                "            [seizoenId] [float] NULL," +
                "            [Id] [float] NULL," +
                "            [Aflevering] [float] NULL," +
                "            [Titel] [nvarchar](255) NULL," +
                "            [Tijdsduur] [datetime] NULL" +
                "    ) ON [PRIMARY]" +
                "    SET ANSI_NULLS ON" +
                "    SET QUOTED_IDENTIFIER ON";

        String seizoen_serie = " CREATE TABLE [dbo].[seizoen_serie$](" +
                "            [SerieID] [float] NULL," +
                "            [Seizoen] [float] NULL," +
                "            [SeizoenID] [float] NULL" +
                "    ) ON [PRIMARY]" +
                "    SET ANSI_NULLS ON" +
                "    SET QUOTED_IDENTIFIER ON";

        String serie = " CREATE TABLE [dbo].[serie$](" +
                "            [serieID] [float] NULL," +
                "            [serie] [nvarchar](255) NULL" +
                "    ) ON [PRIMARY]";

        String first20Records = " INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'Sherlock film', N'12 jaar en ouder', N'Engels', CAST(N'1899-12-30T01:29:00.000' AS DateTime))" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'12 jaar en ouder', N'Engels', CAST(N'1899-12-30T01:34:00.000' AS DateTime))" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'16 jaar en ouder', N'Engels-Amerikaans', CAST(N'1899-12-30T02:34:00.000' AS DateTime))" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'18 jaar en ouder', N'Nederlands', CAST(N'1899-12-30T01:20:00.000' AS DateTime))" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'16 jaar en ouder', N'Engels-Amerikaans', CAST(N'1899-12-30T01:39:00.000' AS DateTime))" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'12 jaar en ouder', N'Engels-Amerikaans', CAST(N'1899-12-30T02:41:00.000' AS DateTime))" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'16 jaar en ouder', N'Engels-Amerikaans', CAST(N'1899-12-30T01:43:00.000' AS DateTime))" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'6 jaar en ouder', N'Nederlands', CAST(N'1899-12-30T01:37:00.000' AS DateTime))" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'6 jaar en ouder', N'Duits', CAST(N'1899-12-30T02:58:00.000' AS DateTime))" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'12 jaar en ouder', N'Vlaams', CAST(N'1899-12-30T01:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[film$] ([film], [Leeftijd], [Taal], [Tijdsduur]) VALUES (N'film', N'16 jaar en ouder', N'Engels', CAST(N'1899-12-30T02:16:00.000' AS DateTime))" +
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
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (1, 1001, 1, N'A Study in Pink', CAST(N'1899-12-30T01:28:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (1, 1002, 2, N'The Blind Banker', CAST(N'1899-12-30T01:28:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (1, 1003, 3, N'The Great Game', CAST(N'1899-12-30T01:28:00.000' AS DateTime))";

        String nextNextNext20Records = " INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (2, 1004, 1, N'A Scandal in Belgravia', CAST(N'1899-12-30T01:28:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (2, 1005, 2, N'The Hounds of Baskerville', CAST(N'1899-12-30T01:28:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (2, 1006, 3, N'The Reichenbach Fall', CAST(N'1899-12-30T01:28:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (3, 1007, 1, N'The Empty Hearse', CAST(N'1899-12-30T01:28:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (3, 1008, 2, N'The Sign of Three', CAST(N'1899-12-30T01:28:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (3, 1009, 3, N'His Last Vow', CAST(N'1899-12-30T01:28:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (4, 2000, 1, N'Pilot', CAST(N'1899-12-30T00:58:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (4, 2001, 2, N'Cat’s in the Bag…', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (4, 2002, 3, N'…And the Bag’s in the River', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (4, 2003, 4, N'Cancer Man', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (4, 2004, 5, N'Gray Matter', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (4, 2005, 6, N'Crazy Handful of Nothin’', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (4, 2006, 7, N'A No-Rough-Stuff-Type Deal', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2007, 1, N'Seven Thirty-Seven', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2008, 2, N'Grilled', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2009, 3, N'Bit by a Dead Bee', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2010, 4, N'Down', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2011, 5, N'Breakage', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2012, 6, N'Peekaboo', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2013, 7, N'Negro Y Azul', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2014, 8, N'Better Call Saul', CAST(N'1899-12-30T00:48:00.000' AS DateTime))";

        String lastRecords = " INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2015, 9, N'4 Days Out', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2016, 10, N'Over', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2017, 11, N'Mandala', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2018, 12, N'Phoenix', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (5, 2019, 13, N'ABQ', CAST(N'1899-12-30T00:48:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3001, 1, N'The Crocodile''s Dilemma', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3002, 2, N'The Rooster Prince', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3003, 3, N'A Muddy Road', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3004, 4, N'Eating the Blame', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3005, 5, N'The Six Ungraspables', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3006, 6, N'Buridan''s Ass', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3007, 7, N'Who Shaves the Barber?', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3008, 8, N'The Heap', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3009, 9, N'A Fox, a Rabbit, and a Cabbage', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (6, 3010, 10, N'Morton''s Fork', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3101, 1, N'Waiting for Dutch', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3102, 1, N'Before the Law', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3103, 1, N'The Myth of Sisyphus', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3105, 1, N'The Gift of the Magi', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3104, 1, N'Fear and Trembling', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3106, 1, N'Rhinoceros', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3107, 1, N'Did you do this? No, you did it!', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3108, 1, N'Loplop', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3109, 1, N'The Castle', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
                "    INSERT [dbo].[seizoen$] ([seizoenId], [Id], [Aflevering], [Titel], [Tijdsduur]) VALUES (7, 3110, 1, N'Palindrome', CAST(N'1899-12-30T01:08:00.000' AS DateTime))" +
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
