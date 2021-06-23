package sigaa;

import bean.AlunoBean;
import java.util.ArrayList;
import java.util.Scanner;

public class PagAluno {

    public static void Alunoa(int mat) {
        String nomeArq = "aluno";
        ArrayList<Object> AlunoBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

        Scanner leitor = new Scanner(System.in);

        //Preenchimento dos dados
        int opcaotec = 0, opcao = 0, matr = 0, status = 0;

        while (opcaotec != 3) {
            System.out.println("\n");

            for (Object aluno : AlunoBean) {
                if (((AlunoBean) aluno).getMatricula() == mat) {
                    System.out.println("\033[31mLogado como " + ((AlunoBean) aluno).getNome());
                    matr = ((AlunoBean) aluno).getMatricula();
                    status = ((AlunoBean) aluno).getStatus();
                }
            }

            if (status == 2) {
                System.out.println("\033[31;1m----------------------------------------------------------------------------------\033[0m");
                System.out.println("                                MÓDULO DO ALUNO                                                 ");
                System.out.println("\033[31mAcesso bloqueado: procure a coordenação de cursos");
                opcaotec = leitor.nextInt();
            } else {
                System.out.println("\033[31;1m----------------------------------------------------------------------------------\033[0m");
                System.out.println("                                MÓDULO DO ALUNO                                                 ");
                System.out.print("1 - Ver Notas");
                if (status == 1) {
                    System.out.print("  |  2 - Matrículas");
                }
                System.out.print("  |  3 - Sair");
                System.out.print(" | Opção: ");
                opcaotec = leitor.nextInt();

                switch (opcaotec) {
                    case 1:
                        System.out.println("");
                        dao.DisciplinaDAO.VerNotas(matr);
                        break;

                    case 2:
                        if (status == 1) {
                            System.out.println("");
                            dao.DisciplinaDAO.ListaDisciplinaMatricula(matr);
                        }
                        break;

                    case 3:
                        return;

                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }
        }
    }
}
