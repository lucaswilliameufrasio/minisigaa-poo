package sigaa;

import bean.ProfessorBean;
import java.util.ArrayList;
import java.util.Scanner;

public class PagProfessor {

    public static void Professorp(int siape) {
        String nomeArq = "professor";
        int siapeprof = 0;
        ArrayList<Object> ProfessorBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

        Scanner leitor = new Scanner(System.in);

        int opcaotec = 0, opcao = 0;
        String login, senha;

        while (opcaotec != 2) {
            System.out.println("\n");

            for (Object professor : ProfessorBean) {
                if (((ProfessorBean) professor).getSiape() == siape) {
                    System.out.println("\033[31mLogado como " + ((ProfessorBean) professor).getNome());
                    siapeprof = ((ProfessorBean) professor).getSiape();
                }
            }

            System.out.println("\033[31;1m----------------------------------------------------------------------------------\033[0m");
            System.out.println("                               MÓDULO DO PROFESSOR                                                 ");
            System.out.println("1 - Disciplinas  |  2 - Sair");
            System.out.print("Opção: ");
            opcaotec = leitor.nextInt();

            switch (opcaotec) {
                case 1:
                    System.out.println("");
                    dao.ProfessorDAO.ListaDisciplinasProfessor(siapeprof);
                    break;

                case 2:
                    return;

                default:
                    System.out.println("Opção inválida");
                    break;

            }
        }
    }
}
