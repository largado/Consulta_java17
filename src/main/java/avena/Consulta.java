package avena;

import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;

/**
 * @Autor Alexandro Avena
 * @version 0.2
 * Data 01/05/2022
 * Descrição lë arquivo e gera consulta
 */

public class Consulta {
    private static java.sql.Statement consulta;
    private static ResultSet resultado;

    public static void leitor(String path) throws IOException, ClassNotFoundException, SQLException, FileNotFoundException {

        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.25.250:1521/ORCL","CURSO","kv2940bm");
        consulta = con.createStatement();

        // grava no arquivo
        FileWriter escrevedordearquivo = new FileWriter("/Users/alex/Downloads/SAIDA.txt");
        BufferedWriter bufferescrevedor = new BufferedWriter(escrevedordearquivo);

        while (true) {

            if (linha != null) {

                try {

                    Class.forName("oracle.jdbc.OracleDriver");
                    resultado = consulta.executeQuery("select * from tabela_de_clientes where CPF in  ('"+linha+"')");
                    while(resultado.next()) {

                        System.out.println(resultado.getString("CPF"));
                        bufferescrevedor.write(resultado.getString("CPF"));
                        bufferescrevedor.newLine();

                    }

                } catch(SQLException erro) {
                    erro.printStackTrace();
                }

            } else
                break;
            linha = buffRead.readLine();

        }
        buffRead.close();
        bufferescrevedor.close();
    }
}