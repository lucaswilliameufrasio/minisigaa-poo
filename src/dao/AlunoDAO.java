package dao;

import java.util.ArrayList;
import java.util.Scanner;
import bean.AlunoBean;

/**
 *
 * @author Tadeu Diniz e Lucas William
 */
public class AlunoDAO {

    public static void AdicionarAluno() {
        int opcao = 0;
        while (opcao != 2) {
            Scanner leitor = new Scanner(System.in);
            int matricula = (int) Math.round(Math.random() * 201800) + 99999;

            String nomeArq = "aluno";
            ArrayList<Object> AlunoBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

            //Objeto Aluno
            AlunoBean novoAluno = new AlunoBean();

            //Dados do aluno para inserir
            novoAluno.setMatricula(matricula);
            novoAluno.setNivel(3);
            System.out.println("Matrícula = " + matricula);

            //Lista de cursos
            dao.CursoDAO.ListaSimplesCursos();
            System.out.print("Selecione o curso (id): ");
            novoAluno.setCurso(leitor.nextInt());
            leitor.nextLine();
            System.out.print("Nome: ");
            novoAluno.setNome(leitor.nextLine());
            System.out.print("Endereço: ");
            novoAluno.setEndereco(leitor.nextLine());
            System.out.print("CPF: ");
            novoAluno.setCpf(leitor.nextLine());
            System.out.print("Telefone: ");
            novoAluno.setTelefone(leitor.nextLine());
            System.out.println("...........");
            System.out.print("Login: ");
            novoAluno.setLogin(leitor.nextLine());
            System.out.print("Senha: ");
            novoAluno.setSenha(leitor.nextLine());
            System.out.println("...........");
            System.out.print("Status: ");
            novoAluno.setStatus(1);
            System.out.println("ativo");

            AlunoBean.add(novoAluno);

            // Serialização: gravando o objeto no arquivo binário
            dao.EmpacotamentoDAO.gravarArquivoBinario(AlunoBean, nomeArq);

            System.out.print("Deseja inserir outro aluno(a): 1 Sim  |  2 Não - ");
            opcao = leitor.nextInt();
        }
    }

    public static AlunoBean ListarAlunos() {
        Scanner leitor = new Scanner(System.in);
        int matr = 0;
        String nomeArq = "aluno";
        ArrayList<Object> AlunoBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        System.out.println("");
        for (Object aluno : AlunoBean) {
            String alunoInfo = "Matricula: " + ((AlunoBean) aluno).getMatricula() + "\nNome: " + ((AlunoBean) aluno).getNome();
            System.out.println(alunoInfo);
            System.out.println("\033[33m.................................................");
        }

        System.out.print("Qual aluno(a) deseja ver (matrícula)? ");
        matr = leitor.nextInt();
        System.out.println("");
        for (Object aluno : AlunoBean) {
            AlunoBean alunoTemp = (AlunoBean) aluno;
            if (alunoTemp.getMatricula() == matr) {
                System.out.println("");
                System.err.println("Matrícula: " + ((AlunoBean) aluno).getMatricula());
                System.out.println("Nome: " + ((AlunoBean) aluno).getNome());
                System.out.println("CPF: " + ((AlunoBean) aluno).getCpf());
                System.out.println("Endereço: " + ((AlunoBean) aluno).getEndereco());
                System.out.println("Telefone: " + ((AlunoBean) aluno).getTelefone());
                System.out.println("-------");
                System.out.println("Login: " + ((AlunoBean) aluno).getLogin());
                System.out.println("Senha: " + ((AlunoBean) aluno).getSenha());
                System.out.println("-------");
                System.out.println("Situação: " + ((AlunoBean) aluno).getStatus());
            }
        }
        return null;
    }

    public static AlunoBean NomeAlunos(int matricula) {
        String nomeArq = "aluno";
        ArrayList<Object> AlunoBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object aluno : AlunoBean) {
            System.out.print(((AlunoBean) aluno).getNome());
        }
        return null;
    }

    public static AlunoBean NomeAluno(int matricula) {
        String nomeArq = "aluno";
        ArrayList<Object> AlunoBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object aluno : AlunoBean) {
            if (((AlunoBean) aluno).getMatricula() == matricula) {
                System.out.print(((AlunoBean) aluno).getNome());
            }
        }
        return null;
    }

    public static AlunoBean NomeAlunoMat(int matricula) {
        String nomeArq = "aluno";
        ArrayList<Object> AlunoBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object aluno : AlunoBean) {
            if (((AlunoBean) aluno).getMatricula() == matricula) {
                System.out.print(((AlunoBean) aluno).getMatricula() + " | ");
                System.out.print(((AlunoBean) aluno).getNome());
            }
        }
        return null;
    }

    public static void StatusAluno() {
        Scanner leitor = new Scanner(System.in);
        String nome = null;
        int matr = 9999999, opcao = 0;
        
        String nomeArq = "aluno";
        ArrayList<Object> AlunoBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

        System.out.print("Digite o nome do aluno: ");
        nome = leitor.nextLine();

        for (Object name : AlunoBean) {
            if (((AlunoBean) name).getNome().contains(nome)) {
                System.out.print(((AlunoBean) name).getMatricula());
                System.out.println(" | " + ((AlunoBean) name).getNome());
                System.out.println("--------------");
            }
        }

        System.out.print("Qual deseja alterar o status? (matrícula) - 0 Cancelar: ");
        matr = leitor.nextInt();

        if (matr == 0) {
            System.out.println("Cancelado!");
        } else {
            System.out.print("1 - Ativo | 2 - Jubilado | 3 - Formado - Opção: ");
            opcao = leitor.nextInt();
            //muda o status da matrícula
            for (Object aluno : AlunoBean) {
                if (((AlunoBean) aluno).getMatricula() == matr) {
                    ((AlunoBean) aluno).setStatus(opcao);
                }
            }
            System.out.println("\033[34mAlterado com sucesso!");
            // Serialização: gravando o objeto no arquivo binário
            dao.EmpacotamentoDAO.gravarArquivoBinario(AlunoBean, nomeArq);
        }
    }
}
