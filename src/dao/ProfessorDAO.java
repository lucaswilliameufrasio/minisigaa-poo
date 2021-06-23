package dao;

import bean.DisciplinaTurmaBean;
import bean.ProfessorBean;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tadeu Diniz e Lucas William
 */
public class ProfessorDAO {

    public static void AdicionaProfessor() {
        int opcao = 0;
        while (opcao != 2) {
            Scanner leitor = new Scanner(System.in);
            int siape = (int) Math.round(Math.random() * 201800) + 99999;

            //Verifica se o arquivo existe, se sim, continua
            //gravar no arquivo dos professores
            String nomeArq = "professor";
            ArrayList<Object> ProfessorBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

            //Objeto professore
            ProfessorBean novoProfessor = new ProfessorBean();

            //Dados do professore para inserir
            novoProfessor.setSiape(siape);
            novoProfessor.setNivel(2);
            System.err.println("SIAPE = " + siape);
            System.out.print("Nome: ");
            novoProfessor.setNome(leitor.nextLine());
            System.out.print("Endereço: ");
            novoProfessor.setEndereco(leitor.nextLine());
            System.out.print("CPF: ");
            novoProfessor.setCpf(leitor.nextLine());
            System.out.print("Telefone: ");
            novoProfessor.setTelefone(leitor.nextLine());
            System.out.println("...........");
            System.out.print("Login: ");
            novoProfessor.setLogin(leitor.nextLine());
            System.out.print("Senha: ");
            novoProfessor.setSenha(leitor.nextLine());
            System.out.println("...........");

            ProfessorBean.add(novoProfessor);

            // Serialização: gravando o objeto no arquivo binário
            dao.EmpacotamentoDAO.gravarArquivoBinario(ProfessorBean, nomeArq);

            System.out.print("Deseja inserir outro professor(a): 1 Sim  |  2 Não - ");
            opcao = leitor.nextInt();
        }
    }

    /**
     *
     * @return
     */
    public static ProfessorBean ListarProfessor() {
        Scanner leitor = new Scanner(System.in);
        int matr = 0;
        ArrayList<ProfessorBean> listaProfessor = new ArrayList<>();
        String nomeArq = "professor";
        ArrayList<Object> ProfessorBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        System.out.println("");
        for (Object professor : ProfessorBean) {
            System.out.println(((ProfessorBean) professor).getSiape() + " | " + ((ProfessorBean) professor).getNome());
            System.out.println("\033[33m.................................................");
        }

        System.out.print("Qual professor(a) deseja ver (SIAPE)? - 0 para cancelar ");
        matr = leitor.nextInt();
        for (Object professor : ProfessorBean) {
            ProfessorBean professorTemp = (ProfessorBean) professor;
            if (professorTemp.getSiape() == matr) {
                System.out.println("............................");
                System.err.println("Matrícula: " + professorTemp.getSiape());
                System.out.println("Nome: " + professorTemp.getNome());
                System.out.println("CPF: " + professorTemp.getCpf());
                System.out.println("Endereço: " + professorTemp.getEndereco());
                System.out.println("Telefone: " + professorTemp.getTelefone());
                System.out.println("----------");
                System.out.println("Login: " + professorTemp.getLogin());
                System.out.println("Senha: " + professorTemp.getSenha());
            }
        }
        return null;
    }

    public static ProfessorBean ListarSimplesProfessor() {
        String nomeArq = "professor";
        ArrayList<Object> ProfessorBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object professor : ProfessorBean) {
            System.out.println(((ProfessorBean) professor).getSiape() + " | " + ((ProfessorBean) professor).getNome());
        }
        return null;
    }

    public static ProfessorBean ProfessorRecebeID(int x) {
        String nomeArq = "professor";
        ArrayList<Object> ProfessorBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object professor : ProfessorBean) {
            if (((ProfessorBean) professor).getSiape() == x) {
                System.out.println(((ProfessorBean) professor).getNome());
            }
        }
        return null;
    }

    public static DisciplinaTurmaBean ListaDisciplinasProfessor(int x) {
        Scanner entrada = new Scanner(System.in);
        int escolha = 0;
        String nomeArq = "disciplinaturma";
        ArrayList<Object> DisciplinaTurmaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object disciplinas : DisciplinaTurmaBean) {
            if (((DisciplinaTurmaBean) disciplinas).getProfessor() == x) {
                dao.DisciplinaDAO.ListaDisciplinaProf(x);
                System.out.println("-------------");
                break;
            }
        }

        System.out.print("Qual disciplina deseja ver? ");
        escolha = entrada.nextInt();
        System.out.println("");

        dao.DisciplinaDAO.VerNotasTurma(escolha);
        return null;
    }
}
