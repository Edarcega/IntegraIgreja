package applications;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

    public static void main(String[] args) {
        Connection conn = null; // Conectar no banco
        Statement st = null; // Preparar consutal
        ResultSet rs = null; // Armazenar no rs

        try {
            conn = DB.getConnection();
            st = conn.createStatement();// Instancia um objeto do tipo statement
            // O rs armazenas os doados do comando passado como String, permitindo as operações
            // o RS tem uma "foto" da tabela retornada pelo comando de consulta
            rs = st.executeQuery("SELECT * FROM IntegraIgreja.tb_membros");

            while (rs.next()) {
                System.out.println(rs.getInt("ID") + ", " + rs.getString("NOME"));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closeConnection();

        }

    }

}
