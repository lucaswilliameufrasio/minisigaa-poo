package dao;

import bean.DisciplinaTurmaBean;
import bean.MatriculaBean;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tadeu Diniz e Lucas William
 */
public class MatriculaDAO {

    public static void NovaMatricula(int matricula, int disciplina, int turma, int professor) {
        int matr = (int) Math.round(Math.random() * 1000);
        String nomeArq = "matricula";
        ArrayList<Object> MatriculaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

        dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

        MatriculaBean novoMatricula = new MatriculaBean();
        novoMatricula.setIdmatricula(matr);
        novoMatricula.setAluno(matricula);
        novoMatricula.setProfessor(professor);
        novoMatricula.setDisciplina(disciplina);
        novoMatricula.setTurma(turma);
        novoMatricula.setStatus(3);

        MatriculaBean.add(novoMatricula);

        // Serialização: gravando o objeto no arquivo binário
        dao.EmpacotamentoDAO.gravarArquivoBinario(MatriculaBean, nomeArq);
    }

    public static void MatriculaPendente(int idmatricula) {
        String nomeArq = "matricula";
        ArrayList<Object> MatriculaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

        //muda o status da matrícula
        for (Object muda : MatriculaBean) {
            if (((MatriculaBean) muda).getIdmatricula() == idmatricula) {
                ((MatriculaBean) muda).setStatus(2);
            }
        }

        // Serialização: gravando o objeto no arquivo binário
        dao.EmpacotamentoDAO.gravarArquivoBinario(MatriculaBean, nomeArq);
    }

    public static void AddDisciTurma(int matricula, int disciplina, int turma, int professor) {
        int matr = (int) Math.round(Math.random() * 10000);
        String nomeArq = "disciplinaturma";
        ArrayList<Object> DisciplinaTurmaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

        dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

        DisciplinaTurmaBean novoMatricula = new DisciplinaTurmaBean();
        novoMatricula.setId_matricula(matr);
        novoMatricula.setProfessor(professor);
        novoMatricula.setDisciplina(disciplina);
        novoMatricula.setTurma(turma);

        DisciplinaTurmaBean.add(novoMatricula);

        // Serialização: gravando o objeto no arquivo binário
        dao.EmpacotamentoDAO.gravarArquivoBinario(DisciplinaTurmaBean, nomeArq);
    }

    public static void AdicionaMatricula(int matricula, int disciplina, int turma) {
        int matr = (int) Math.round(Math.random() * 10000);
        String nomeArq = "matricula";
        ArrayList<Object> MatriculaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

        //muda o status da matrícula
        for (Object muda : MatriculaBean) {
            if (((MatriculaBean) muda).getIdmatricula() == matr) {
                ((MatriculaBean) muda).setStatus(1);
            }
        }

        // Serialização: gravando o objeto no arquivo binário
        dao.EmpacotamentoDAO.gravarArquivoBinario(MatriculaBean, nomeArq);
    }

    public static MatriculaBean ListarMatricula() {
        String nomeArq = "matricula";
        ArrayList<Object> MatriculaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object matricula : MatriculaBean) {
            if (((MatriculaBean) matricula).getStatus() == 3) {
                String matriculaInfo = ((MatriculaBean) matricula).getIdmatricula() + " | Aluno: " + ((MatriculaBean) matricula).getAluno() + "\nDisciplina: " + ((MatriculaBean) matricula).getDisciplina();
                System.out.println(matriculaInfo);
                System.out.println(".................................................");
            }
        }
        return null;
    }

    public static void EfetivarMatricula() {
        Scanner ler = new Scanner(System.in);
        int troca = 1;
        int matr = 999999, opcao = 0;
        String nomeArq = "matricula";
        ArrayList<Object> MatriculaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

        if (MatriculaBean.isEmpty()) {
            System.out.println("Lista de matrículas vazia");
        } else {
            //mostra os resultados
            System.out.println("");
            for (Object matricula : MatriculaBean) {
                if (((MatriculaBean) matricula).getStatus() == 2) {
                    String matriculaInfo = ((MatriculaBean) matricula).getIdmatricula() + " | Aluno: " + ((MatriculaBean) matricula).getAluno() + "\nDisciplina: " + ((MatriculaBean) matricula).getDisciplina();
                    System.out.println(matriculaInfo);
                    System.out.println(".................................................");
                }
            }
            //Solicita selecionar a MATRÍCULA
            System.out.print("Selecione a matrícula - 0 para Cancelar: ");
            matr = ler.nextInt();

            if (matr == 0) {
                System.out.println("Cancelado");
            } else {
                for (Object matricula : MatriculaBean) {
                    if (((MatriculaBean) matricula).getIdmatricula() == matr) {
                        int aluno = ((MatriculaBean) matricula).getAluno();
                        int disciplina = ((MatriculaBean) matricula).getDisciplina();
                        int turma = ((MatriculaBean) matricula).getTurma();
                        dao.DisciplinaDAO.AdicionarAlunoDisciplina(aluno, disciplina, turma);
                    }
                }

                //muda o status da matrícula
                for (Object muda : MatriculaBean) {
                    if (((MatriculaBean) muda).getIdmatricula() == matr) {
                        ((MatriculaBean) muda).setStatus(1);
                    }
                }

                // Serialização: gravando o objeto no arquivo binário
                dao.EmpacotamentoDAO.gravarArquivoBinario(MatriculaBean, nomeArq);

                System.out.println("Matrícula efetivada!");
            }
        }

    }
}
