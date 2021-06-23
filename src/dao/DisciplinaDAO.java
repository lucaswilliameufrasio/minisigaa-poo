package dao;

import bean.AlunoBean;
import bean.DisciplinaBean;
import bean.DisciplinaTurmaBean;
import bean.MatriculaBean;
import bean.NotaBean;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tadeu Diniz e Lucas William
 */
public class DisciplinaDAO {

    public static void AdicionaDisciplina() {
        int opcao = 0;
        while (opcao != 2) {
            Scanner leitor = new Scanner(System.in);
            int id = (int) Math.round(Math.random() * 100);
            String nomeArq = "disciplina";
            ArrayList<Object> DisciplinaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

            dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

            DisciplinaBean novoDisciplina = new DisciplinaBean();

            System.out.println("ID Disciplina = " + id);
            novoDisciplina.setId_disciplina(id);
            System.out.print("Nome da disciplina: ");
            novoDisciplina.setNome(leitor.nextLine());
            System.out.print("Duração (horas): ");
            novoDisciplina.setDuracao(leitor.nextInt());

            DisciplinaBean.add(novoDisciplina);

            leitor.nextLine(); // esvazia o buffer do teclado
            System.out.printf("\n");

            // Serialização: gravando o objeto no arquivo binário
            dao.EmpacotamentoDAO.gravarArquivoBinario(DisciplinaBean, nomeArq);

            System.out.print("Deseja inserir outra disciplina(a): 1 Sim  |  2 Não - ");
            opcao = leitor.nextInt();
        }
    }

    public static DisciplinaBean ListarDisciplina() {
        String nomeArq = "disciplina";
        ArrayList<Object> DisciplinaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        System.out.println("");
        for (Object disciplina : DisciplinaBean) {
            String disciplinaInfo = "Nome: " + ((DisciplinaBean) disciplina).getNome() + "\nDuração (horas): " + ((DisciplinaBean) disciplina).getDuracao();
            System.out.println(disciplinaInfo);
            System.out.println("\033[33m.................................................");
        }
        return null;
    }

    public static DisciplinaBean DisciplinaRecebeId(int x) {
        String nomeArq = "disciplina";
        ArrayList<Object> DisciplinaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object disciplina : DisciplinaBean) {
            if (((DisciplinaBean) disciplina).getId_disciplina() == x) {
                System.out.print(((DisciplinaBean) disciplina).getId_disciplina() + " | " + ((DisciplinaBean) disciplina).getNome());
            }
        }
        return null;
    }

    public static DisciplinaBean NomeDisciplina(int x) {
        String nomeArq = "disciplina";
        ArrayList<Object> DisciplinaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object disciplina : DisciplinaBean) {
            if (((DisciplinaBean) disciplina).getId_disciplina() == x) {
                System.out.print(((DisciplinaBean) disciplina).getNome());
            }
        }
        return null;
    }

    public static DisciplinaBean ListarSimplesDisciplina() {
        String nomeArq = "disciplina";
        ArrayList<Object> DisciplinaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object disciplina : DisciplinaBean) {
            String disciplinaInfo = ((DisciplinaBean) disciplina).getId_disciplina() + " | Nome: " + ((DisciplinaBean) disciplina).getNome();
            System.out.println(disciplinaInfo);
        }
        return null;
    }

    public static DisciplinaBean ListaDisciplinaTurmaID(int x) {
        String nomeArq = "disciplinaturma";
        ArrayList<Object> DisciplinaTurmaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object disciplina : DisciplinaTurmaBean) {
            if (((DisciplinaTurmaBean) disciplina).getTurma() == x) {
                DisciplinaRecebeId(((DisciplinaTurmaBean) disciplina).getDisciplina());
                System.out.print(" | ");
                dao.ProfessorDAO.ProfessorRecebeID(((DisciplinaTurmaBean) disciplina).getProfessor());
            }
        }
        return null;
    }
    
    public static DisciplinaBean ListaDisciplinaProf(int x) {
        String nomeArq = "disciplinaturma";
        ArrayList<Object> DisciplinaTurmaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object disciplina : DisciplinaTurmaBean) {
            if (((DisciplinaTurmaBean) disciplina).getProfessor() == x) {
                DisciplinaRecebeId(((DisciplinaTurmaBean) disciplina).getDisciplina());
                System.out.print(" | ");
                dao.ProfessorDAO.ProfessorRecebeID(((DisciplinaTurmaBean) disciplina).getProfessor());
            }
        }
        return null;
    }

    public static DisciplinaBean ListaDisciplinaMatricula(int matricula) {
        int opcao2 = 9999999;
        Scanner leitor = new Scanner(System.in);

        String nomeArq = "disciplinaturma";
        ArrayList<Object> DisciplinaTurmaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

        JaMatriculado(matricula);

        System.out.println("");
        System.out.println("\033[31;1m---------------------------------------\033[0m");
        System.out.println("Disciplinas disponíveis para matrícula:");
        System.out.println("\033[31;1m---------------------------------------\033[0m");

        ListaDisciplinasTurma(matricula);

        System.out.print("Escolha a Disciplina que deseja se matricular (0 para cancelar): ");
        opcao2 = leitor.nextInt();

        if (opcao2 == 0) {
            System.out.println("Matrícula não realizada");
        } else {
            dao.MatriculaDAO.MatriculaPendente(opcao2);
            System.out.println("Matrícula realizada com sucesso!");
        }
        return null;
    }

    public static DisciplinaBean ListaDisciplinaTurma(int x) {
        String nomeArq = "disciplinaturna";
        ArrayList<Object> DisciplinaTurmaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object disciplina : DisciplinaTurmaBean) {
            if (((DisciplinaTurmaBean) disciplina).getProfessor() == x) {
                DisciplinaRecebeId(((DisciplinaTurmaBean) disciplina).getDisciplina());
                System.out.print(" | ");
                dao.ProfessorDAO.ProfessorRecebeID(((DisciplinaTurmaBean) disciplina).getProfessor());
            }
        }
        return null;
    }

    public static void AdicionarDisciplinaTurma() {
        int opcao = 0;
        Scanner leitor = new Scanner(System.in);
        System.out.println("");
        System.out.println("Relação de Turmas");
        dao.TurmaDAO.ListarSimplesTurmas();
        System.err.print("Selecione a Turma (ID): ");
        System.out.println("-----------");
        int turmaselect = leitor.nextInt();

        while (opcao != 2) {
            int id_matr = (int) Math.round(Math.random() * 300);
            String nomeArq = "disciplinaturma";
            ArrayList<Object> DisciplinaTurmaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

            DisciplinaTurmaBean disciTurma = new DisciplinaTurmaBean();

            disciTurma.setTurma(turmaselect);

            disciTurma.setId_matricula(id_matr);
            System.out.println("\nRelação de Disciplinas");
            dao.DisciplinaDAO.ListarSimplesDisciplina();
            System.out.println("-----------");
            System.err.print("Selecione a Disciplina: ");
            int disci = leitor.nextInt();
            disciTurma.setDisciplina(disci);

            System.out.println("\nRelação de Professores");
            dao.ProfessorDAO.ListarSimplesProfessor();
            System.out.println("-----------");
            System.err.print("Selecione professor(a): ");
            int prof = leitor.nextInt();
            disciTurma.setProfessor(prof);

            DisciplinaTurmaBean.add(disciTurma);

            //grava na matrícula
            String nomeArq2 = "aluno";
            ArrayList<Object> AlunoBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq2);
            for (Object aluno : AlunoBean) {
                dao.MatriculaDAO.NovaMatricula(((AlunoBean) aluno).getMatricula(), disci, turmaselect, prof);
            }

            // Serialização: gravando o objeto no arquivo binário
            dao.EmpacotamentoDAO.gravarArquivoBinario(DisciplinaTurmaBean, nomeArq);

            System.out.print("Deseja inserir outra disciplina: 1 Sim  |  2 Não - ");
            opcao = leitor.nextInt();
        }
    }

    public static void AdicionarAlunoDisciplina(int aluno, int disciplina, int turma) {
        String nomeArq = "nota";
        ArrayList<Object> NotaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

        NotaBean novaNota = new NotaBean();

        novaNota.setNota1(0);
        novaNota.setNota2(0);
        novaNota.setNota3(0);
        novaNota.setAluno(aluno);
        novaNota.setDisciplina(disciplina);
        novaNota.setTurma(turma);

        NotaBean.add(novaNota);

        // Serialização: gravando o objeto no arquivo binário
        dao.EmpacotamentoDAO.gravarArquivoBinario(NotaBean, nomeArq);
    }

    public static void DisciplinasAluno(int matricula) {
        int opcao = 0;
        Scanner leitor = new Scanner(System.in);
        String nomeArq = "nota";
        ArrayList<Object> NotaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

        for (Object disci : NotaBean) {
            if (((NotaBean) disci).getAluno() == matricula) {
                System.out.print(((NotaBean) disci).getDisciplina() + " | ");
                NomeDisciplina(((NotaBean) disci).getDisciplina());
                System.out.println("");
                System.out.println("----------");
            }
        }
        System.out.println("");
        System.out.print("Qual disciplina deseja ver? ");
        opcao = leitor.nextInt();
        System.out.println("");
        VerNotas(matricula);
    }

    public static void VerNotas(int matricula) {
        float media = 0;
        String nomeArq = "nota";
        ArrayList<Object> NotaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object nota : NotaBean) {
            if (((NotaBean) nota).getAluno() == matricula) {
                NomeDisciplina(((NotaBean) nota).getDisciplina());
                System.out.println("");
                if (((NotaBean) nota).getNota1() > 6) {
                    System.out.print("\033[37mNota 1: " + "\033[34m" + ((NotaBean) nota).getNota1());
                } else {
                    System.out.print("\033[31mNota 1: " + ((NotaBean) nota).getNota1());
                }
                if (((NotaBean) nota).getNota2() > 6) {
                    System.out.print("\033[34m |  Nota 2: " + ((NotaBean) nota).getNota2());
                } else {
                    System.out.print("\033[31m |  Nota 2: " + ((NotaBean) nota).getNota2());
                }
                if (((NotaBean) nota).getNota3() > 6) {
                    System.out.println("\033[34m |  Nota 3: " + ((NotaBean) nota).getNota3());
                } else {
                    System.out.println("\033[31m |  Nota 3: " + ((NotaBean) nota).getNota3());
                }
                media = (((NotaBean) nota).getNota1() + ((NotaBean) nota).getNota2() + ((NotaBean) nota).getNota3()) / 3;
                if (media > 6) {
                    System.out.println("\033[34mMédia: " + media + "  -  Aprovado!");
                } else {
                    System.out.println("\033[31mMédia: " + media + "  -  Reprovado :-(");
                }
                System.out.println("---------");
            }
        }
    }

    public static void AlterarNotas(int matricula) {
        Scanner leitor = new Scanner(System.in);
        float opcao = leitor.nextFloat();
        String nomeArq = "nota";
        ArrayList<Object> NotaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
        for (Object upnota : NotaBean) {
            if (((NotaBean) upnota).getAluno() == matricula) {
                dao.AlunoDAO.NomeAluno(matricula);
                System.out.print("Nota 1 -");
                ((NotaBean) upnota).setNota1(opcao);
                System.out.print("Nota 2 -");
                ((NotaBean) upnota).setNota2(opcao);
                System.out.print("Nota 3 -");
                ((NotaBean) upnota).setNota3(opcao);
            }
        }
        // Serialização: gravando o objeto no arquivo binário
        dao.EmpacotamentoDAO.gravarArquivoBinario(NotaBean, nomeArq);
    }

    public static void VerNotasTurma(int disciplina) {
        float media = 0;
        Scanner leitor = new Scanner(System.in);
        Scanner notaAlunoLe = new Scanner(System.in);
        float notaluno = 0;
        int opcao = 0, opcao2 = 0;
        int opcaoVerNota = 0;
        while (opcao != 2) {
            String nomeArq = "nota";
            ArrayList<Object> NotaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);
            for (Object nota : NotaBean) {
                if (((NotaBean) nota).getDisciplina() == disciplina) {
                    media = (((NotaBean) nota).getNota1() + ((NotaBean) nota).getNota2() + ((NotaBean) nota).getNota3()) / 3;
                    System.out.println("\033[32mMat      Aluno                                    | Nota 1 | Nota 2 | Nota 3 | Média Final");
                    dao.AlunoDAO.NomeAlunoMat(((NotaBean) nota).getAluno());
                    System.out.printf("%36.1f%10.1f%9.1f%11.1f%n", ((NotaBean) nota).getNota1(), ((NotaBean) nota).getNota2(), ((NotaBean) nota).getNota3(), media, "\n");
                    System.out.println("\033[39m--------------------------------");
                }
            }
            System.out.println("");
            System.out.print("Deseja Alterar notas? 1 - Sim  |  2 - Não - ");
            opcao = leitor.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Qual aluno? (matrícula): ");
                    opcao2 = leitor.nextInt();
                    for (Object upnota : NotaBean) {
                        if (((NotaBean) upnota).getAluno() == opcao2 && ((NotaBean) upnota).getDisciplina() == disciplina) {
                            dao.AlunoDAO.NomeAluno(opcao2);
                            System.out.println(" ");
                            System.out.print("Nota 1 - ");
                            ((NotaBean) upnota).setNota1(notaluno = notaAlunoLe.nextFloat());
                            System.out.print("Nota 2 - ");
                            ((NotaBean) upnota).setNota2(notaluno = notaAlunoLe.nextFloat());
                            System.out.print("Nota 3 - ");
                            ((NotaBean) upnota).setNota3(notaluno = notaAlunoLe.nextFloat());
                        }

                    }
                    // Serialização: gravando o objeto no arquivo binário
                    dao.EmpacotamentoDAO.gravarArquivoBinario(NotaBean, nomeArq);
                    break;

                case 2:
                    return;
            }
        }
    }

    public static void JaMatriculado(int matricula) {
        String nomeArq = "nota";
        ArrayList<Object> NotaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

        System.out.println("\033[31;1mJá matriculado em:");
        for (Object not : NotaBean) {
            if (((NotaBean) not).getAluno() == matricula) {
                NomeDisciplina(((NotaBean) not).getDisciplina());
                System.out.println("");
                System.out.println("\33[1m---------");
            }
        }
    }

    public static void ListaDisciplinasTurma(int aluno) {
        String nomeArq = "matricula";
        ArrayList<Object> MatriculaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

        for (Object disciplina : MatriculaBean) {
            if (((MatriculaBean) disciplina).getAluno() == aluno && ((MatriculaBean) disciplina).getStatus() == 3) {
                System.out.print(((MatriculaBean) disciplina).getIdmatricula());
                System.out.print(" | ");
                NomeDisciplina(((MatriculaBean) disciplina).getDisciplina());
                System.out.print(" | ");
                dao.ProfessorDAO.ProfessorRecebeID(((MatriculaBean) disciplina).getProfessor());
                dao.TurmaDAO.TurmaRecebeID(((MatriculaBean) disciplina).getTurma());
                System.out.println("----------");
            }
        }
    }

    public static void DisciplinasDaturma(int turma, int disciplina) {
        String nomeArq = "nota";
        ArrayList<Object> NotaBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

        for (Object alunos : NotaBean) {
            if (((NotaBean) alunos).getTurma() == turma && ((NotaBean) alunos).getDisciplina() == disciplina) {
                dao.AlunoDAO.NomeAlunoMat(((NotaBean) alunos).getAluno());
                System.out.println("");
            }
        }
    }
}
