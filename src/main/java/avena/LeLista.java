package avena;

import java.sql.SQLException;
import java.io.IOException;

/**
 * @Autor Alexandro Avena
 * @version 0.2
 * Data 01/05/2022
 * Descrição lë arquivo e gera consulta
 */

public class LeLista {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        String path = "/Users/alex/Downloads/arquivo.txt";
        Consulta.leitor(path);
    }

}