package dao;

import bean.TurmaBean;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tadeu Diniz e Licas William
 */
public class TurmaDAO {

    public static void AdicionaTurma() {
        int opcao = 0;
        while (opcao != 2) {
            int id = (int) Math.round(Math.random() * 100);
            Scanner leitor = new Scanner(System.in);
            String nomeArq = "turma";
            ArrayList<Object> TurmaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

            //Lista os Cursos
            System.out.println("Relação de Cursos");
            dao.CursoDAO.ListaSimplesCursos();
            System.out.println("-------------");

            TurmaBean novaTurma = new TurmaBean();

            System.out.println("ID Turma: " + id);
            novaTurma.setId_turma(id);
            System.out.print("ID do curso: ");
            novaTurma.setNome(leitor.nextInt());
            System.out.print("Ano: ");
            novaTurma.setAno(leitor.nextInt());
            System.out.print("Turno (1 - Matutino | 2 - Verpertino | 3 - Noturno): ");
            novaTurma.setTurno(leitor.nextInt());
            TurmaBean.add(novaTurma);

            leitor.nextLine(); // esvazia o buffer do teclado
            System.out.printf("\n");

            // Serialização: gravando o objeto no arquivo binário
            dao.EmpacotamentoDAO.gravarArquivoBinario(TurmaBean, nomeArq);

            System.out.print("Deseja inserir outra turma: 1 Sim  |  2 Não - ");
            opcao = leitor.nextInt();
        }
    }

    /**
     *
     * @return
     */
    public static TurmaBean ListarTurmas() {
        int opcao = 0, opcao2 = 0;
        Scanner leitor = new Scanner(System.in);
        
        String nomeArq = "turma";
        ArrayList<Object> TurmaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        
        for (Object turma : TurmaBean) {
            System.out.print(((TurmaBean) turma).getId_turma() + " | Nome da Turma: ");
            dao.CursoDAO.CursoRecebeID(((TurmaBean) turma).getNome());
            System.out.println(((TurmaBean) turma).getAno());
            System.out.println("\033[33m.................................................");
        }
        
        System.out.print("Qual turma deseja ver? ");
        opcao = leitor.nextInt();
        
        System.out.println("\n");
        System.out.println("Informações desta Turma: ");
        for (Object turma : TurmaBean) {
            if (((TurmaBean) turma).getId_turma() == opcao) {
                dao.CursoDAO.CursoRecebeID(((TurmaBean) turma).getNome());
                System.out.print(((TurmaBean) turma).getAno());
                System.out.print(" - ");
                if (((TurmaBean) turma).getTurno() == 1) {
                    System.out.println("Turno: Matutino");
                }
                if (((TurmaBean) turma).getTurno() == 2) {
                    System.out.println("Turno: Vespertino");
                }
                if (((TurmaBean) turma).getTurno() == 3) {
                    System.out.println("Turno: Noturno");
                }
                System.out.println("-----------");
            }
        }
        System.out.println("Disciplinas:");
        dao.DisciplinaDAO.ListaDisciplinaTurmaID(opcao);
        System.out.println("");

        System.out.print("Deseja ver uma Disciplina? ID DISCIPLINA | 0 para cancelar - ");
        opcao2 = leitor.nextInt();
        
        System.out.println("\033[34mAlunos nesta turma:");
        dao.DisciplinaDAO.DisciplinasDaturma(opcao, opcao2);

        return null;
    }

    public static TurmaBean ListarSimplesTurmas() {
        String nomeArq = "turma";
        ArrayList<Object> TurmaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object turma : TurmaBean) {
            System.out.print(((TurmaBean) turma).getId_turma() + " | ");
            System.out.print("Nome da Turma: ");
            dao.CursoDAO.CursoRecebeID(((TurmaBean) turma).getNome());
            System.out.println(((TurmaBean) turma).getAno());
        }
        return null;
    }

    public static TurmaBean TurmaRecebeID(int x) {
        String nomeArq = "turma";
        ArrayList<Object> TurmaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object turma : TurmaBean) {
            if (((TurmaBean) turma).getId_turma() == x) {
                System.out.print("Nome da Turma: ");
                dao.CursoDAO.CursoRecebeID(((TurmaBean) turma).getNome());
                System.out.println(((TurmaBean) turma).getAno());
                if (((TurmaBean) turma).getTurno() == 1) {
                    System.out.println("Matutino");
                }
                if (((TurmaBean) turma).getTurno() == 2) {
                    System.out.println("Vespertino");
                }
                if (((TurmaBean) turma).getTurno() == 3) {
                    System.out.println("Noturno");
                }
            }
        }
        return null;
    }

}
