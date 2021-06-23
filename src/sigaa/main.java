package sigaa;

import java.io.IOException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException  {
        int escolha = 0;
        Scanner leitor = new Scanner(System.in);

        while (escolha != 4) {
            System.out.println("\n");
            System.out.println("\033[31;1m----------------------------------------------------------------------------------");
            System.out.println("\033[33m                                    MINI SIGAA                                     ");
            System.out.println("\033[31;1m----------------------------------------------------------------------------------");
            //System.out.println("\033[37mTADEU - vermelho");
            //System.out.println("\033[32mTADEU - verde");
            //System.out.println("\033[33mTADEU - amarelo");
            //System.out.println("\033[34mTADEU - azul");
            //System.out.println("\033[35mTADEU - rosa");
            //System.out.println("\033[36mTADEU - ciano");
              
            dao.LoginDAO.EntradaLogin();
            //PagProfessor.Professorp();
            //PagTecnico.Tecnicot();
            
        }
    }
}
