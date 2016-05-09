
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author oneiroi
 */
public class BDD {
    // Permet l'accès et la connection à la BDD 
    // Permet l'affichage des meilleurs score

    public static void finPartie(String gagnant) throws SQLException {
        /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/finstere";
        String utilisateur = "brogniar3u";
        String motDePasse = "32216849@";
        Connection connexion = null;
        try {
            // connexion à la base
            connexion = (Connection) DriverManager.getConnection(url, utilisateur, motDePasse);

            /* Création de l'objet gérant les requêtes */
            Statement statement = connexion.createStatement();

            Calendar cal = Calendar.getInstance();
            //On récupère la date et l'heure du moment 
            java.sql.Timestamp timestamp = new Timestamp(cal.getTime().getTime());

            //La requete
            String sql = "INSERT INTO score(nomGagnant,date,score) " + "VALUES ('"+gagnant+"','" + timestamp + "','0')";  // avec score
           // String sql = "INSERT INTO score(nomGagnant,date) " + "VALUES ('" + gagnant + "','" + timestamp + "')";
             
            //On prépare la requête
            PreparedStatement ps = connexion.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);

            // On éxécute la requête
            ps.execute();

            //On récupère la clé générée
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            // On récupère la ligne créée grace à l'id
            ResultSet rs2 = statement.executeQuery("SELECT numPartie, nomGagnant, date FROM score WHERE numPartie ='" + generatedKey + "';");

            // On afiche le message de fin de jeu
            while (rs2.next()) {
                if (gagnant != null) {
                    Outils.afficherTexte(rs2.getString("nomGagnant") + " a gagné la partie " + generatedKey + " le " + rs2.getDate("date") + " à " + rs2.getTimestamp("date").getHours() + ":" + rs2.getTimestamp("date").getMinutes() + ":" + rs2.getTimestamp("date").getSeconds());
                } else {
                    Outils.afficherTexte("Personne n'a gagné la partie " + generatedKey + " le " + rs2.getDate("date") + " à " + rs2.getTimestamp("date").getHours() + ":" + rs2.getTimestamp("date").getMinutes() + ":" + rs2.getTimestamp("date").getSeconds());
                }
            }

        } catch (SQLException e) {
            System.out.println("erreur BDD");
            /* Gérer les éventuelles erreurs ici */
        } finally {
            if (connexion != null) {
                /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                connexion.close();

            }
        }

    }

    public static void highScores() {

        /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/finstere";
        String utilisateur = "brogniar3u";
        String motDePasse = "32216849@";
        Connection connexion = null;
        try {
            connexion = (Connection) DriverManager.getConnection(url, utilisateur, motDePasse);

            /* Création de l'objet gérant les requêtes */
            Statement statement = connexion.createStatement();

            /* Exécution d'une requête SELECT */
            //La requete
            String sql = "SELECT numPartie, nomGagnant, date, score FROM score;";

            //On prépare la requête
            PreparedStatement ps = connexion.prepareStatement(sql);
            ResultSet rs = statement.executeQuery(sql);

            String s ="\"------------------- HIGH SCORES -------------------- \n PSEUDO      SCORE \n ";
            while (rs.next()) {
                if (rs.getString("nomGagnant") != null) {
                   
                      s +=rs.getString("nomGagnant") + "          " + rs.getInt("score")+"\n";
                }
            }
            Outils.afficherTexte(s);

        } catch (SQLException e) {
            /* Gérer les éventuelles erreurs ici */
            System.out.println("erreur BDD");
        } finally {
            if (connexion != null) {
                /* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
                //connexion.close();
            }

        }

    }
}
