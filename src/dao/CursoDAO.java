package dao;

import bean.CursoBean;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tadeu Diniz e Lucas William
 */
public class CursoDAO {

    public static void AdicionaCurso() {
        int opcao = 0;
        while (opcao != 2) {
            int id = (int) Math.round(Math.random() * 100);
            Scanner leitor = new Scanner(System.in);
            
            System.out.println("ID - " + id);
            System.out.print("Nome do curso: ");
            String nomecurso = leitor.nextLine();
            
            String nomeArq = "curso";
            ArrayList<Object> CursoBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

            CursoBean novoCurso = new CursoBean();

            novoCurso.setId_curso(id);
            novoCurso.setNome(nomecurso);
            System.out.print("Dura��o (semestres): ");
            novoCurso.setDuracao(leitor.nextInt());

            CursoBean.add(novoCurso);

            leitor.nextLine(); // esvazia o buffer do teclado
            System.out.printf("\n");

            // Serializa��o: gravando o objeto no arquivo bin�rio
            dao.EmpacotamentoDAO.gravarArquivoBinario(CursoBean, nomeArq);

            System.out.print("Deseja inserir outro aluno(a): 1 Sim  |  2 N�o - ");
            opcao = leitor.nextInt();
        }
    }

    /**
     *
     * @return
     */
    public static void ListarCursos() {
        String nomeArq = "curso";
        ArrayList<Object> CursoBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object curso : CursoBean) {
            System.out.println(((CursoBean) curso).getId_curso() + "|  Nome: " + ((CursoBean) curso).getNome());
            System.out.println("Dura��o (semestres): " + ((CursoBean) curso).getDuracao());
            System.out.println(".................................................");
        }
    }

    public static CursoBean ListaSimplesCursos() {
        String nomeArq = "curso";
        ArrayList<Object> CursoBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object curso : CursoBean) {
            String cursoInfo = ((CursoBean) curso).getId_curso() + " | " + ((CursoBean) curso).getNome();
            System.out.println(cursoInfo);
        }
        return null;
    }

    public static CursoBean CursoRecebeID(int x) {
        String nomeArq = "curso";
        ArrayList<Object> CursoBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object curso : CursoBean) {
            if (((CursoBean) curso).getId_curso() == x) {
                System.out.print(((CursoBean) curso).getNome());
            }
        }
        return null;
    }
}
