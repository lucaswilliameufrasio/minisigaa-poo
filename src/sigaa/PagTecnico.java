package sigaa;

import bean.TecnicoBean;
import java.util.ArrayList;
import java.util.Scanner;

public class PagTecnico {

    public static void Tecnicot(int siape) {
        String nomeArq = "tecnico";
        ArrayList<Object> TecnicoBean = dao.EmpacotamentoDAO.lerArquivoBinario(nomeArq);

        Scanner leitor = new Scanner(System.in);

        int opcaotec = 0, opcao = 0, siapetec = 0;
        String login, senha;

        while (opcaotec != 8) {
            System.out.println("\n");

            for (Object tecnico : TecnicoBean) {
                if (((TecnicoBean) tecnico).getSiape() == siape) {
                System.out.println("\033[31mLogado como " + ((TecnicoBean) tecnico).getNome());
                siapetec = ((TecnicoBean) tecnico).getSiape();
                }
            }

            System.out.println("\033[31;1m----------------------------------------------------------------------------------\033[0m");
            System.out.println("                               M�DULO DO T�CNICO                                                 ");
            System.out.println("| 1 - Cursos      |  2 - Turmas       |  3 - Disciplinas");
            System.out.println("| 4 - Aluno       |  5 - Professores  |  6 - Matr�culas");
            System.out.print("| 7 - T�cnicos    |  8 - Retornar     |  Op��o: ");
            opcaotec = leitor.nextInt();

            switch (opcaotec) {
                //Op��es para CURSOS
                case 1:
                    System.out.println("\n");
                    System.out.println("\033[31;1m----------------------------------------------------------------------------------\033[0m");
                    System.out.print("1 - Cadastrar Curso  |  2 - Listar Curso  |  3 - Retornar  |  Op��o: ");
                    opcao = leitor.nextInt();
                    System.out.println("");

                    switch (opcao) {
                        case 1:
                            dao.CursoDAO.AdicionaCurso();
                            break;

                        case 2:
                            dao.CursoDAO.ListarCursos();
                            break;
                    }
                    break;

                //Op��es para TURMA
                case 2:
                    System.out.println("\033[31;1m----------------------------------------------------------------------------------\033[0m");
                    System.out.println("1 - Abrir Turma               |     2 - Ver Turma ");
                    System.out.println("3 - Disciplina na turma       |     4 - Retornar ao menu anterior");
                    System.out.print("Op��o: ");
                    opcao = leitor.nextInt();

                    switch (opcao) {
                        case 1:
                            dao.TurmaDAO.AdicionaTurma();
                            break;

                        case 2:
                            System.out.println("");
                            dao.TurmaDAO.ListarTurmas();
                            break;

                        case 3:
                            dao.DisciplinaDAO.AdicionarDisciplinaTurma();
                            break;
                    }
                    break;

                //Op��es para DISCIPLINAS
                case 3:
                    System.out.println("\033[31;1m----------------------------------------------------------------------------------\033[0m");
                    System.out.print("1 - Cadastrar Disciplina   |  2 - Listar  |  3 - Retornar  |  Op��o: ");
                    opcao = leitor.nextInt();

                    switch (opcao) {
                        case 1:
                            dao.DisciplinaDAO.AdicionaDisciplina();
                            break;

                        case 2:
                            dao.DisciplinaDAO.ListarDisciplina();
                            break;
                    }
                    break;

                //Op��es para ALUNOS
                case 4:
                    System.out.println("\033[31;1m----------------------------------------------------------------------------------\033[0m");
                    System.out.print("1 - Cadastrar Aluno(a)  |  2 - Listar  |  3 - Mudar Status  |  4 - Retornar  |  Op��o: ");
                    opcao = leitor.nextInt();

                    switch (opcao) {
                        case 1:
                            dao.AlunoDAO.AdicionarAluno();
                            break;

                        case 2:
                            dao.AlunoDAO.ListarAlunos();
                            break;
                            
                        case 3:
                            dao.AlunoDAO.StatusAluno();
                            break;
                    }
                    break;

                //Op��es para PROFESSORES
                case 5:
                    System.out.println("\033[31;1m----------------------------------------------------------------------------------\033[0m");
                    System.out.print("1 - Cadastrar Professor(a)  |  2 - Listar  |  3 - Retornar  |  Op��o: ");
                    opcao = leitor.nextInt();

                    switch (opcao) {
                        case 1:
                            dao.ProfessorDAO.AdicionaProfessor();
                            break;

                        case 2:
                            dao.ProfessorDAO.ListarProfessor();
                            break;
                    }
                    break;

                case 6:
                    System.out.println("\033[31;1m----------------------------------------------------------------------------------\033[0m");
                    System.out.print("1 - Matr�culas Pendentes  |  2 - Retornar  |  Op��o: ");
                    opcao = leitor.nextInt();

                    switch (opcao) {
                        case 1:
                            dao.MatriculaDAO.EfetivarMatricula();
                            break;
                    }
                    break;

                case 7:
                    System.out.println("\033[31;1m----------------------------------------------------------------------------------\033[0m");
                    System.out.print("1 - Inserir T�cnico  |  2 - Listar  |  3 - Retornar  |  Op��o: ");
                    opcao = leitor.nextInt();

                    switch (opcao) {
                        case 1:
                            dao.TecnicoDAO.AdicionaTecnico();
                            break;

                        case 2:
                            dao.TecnicoDAO.ListarTecnico();
                            break;
                    }
                    break;

                case 8:
                    return;
                default:
                    System.out.println("Op��o inv�lida");
                    break;

            }
        }
    }
}
