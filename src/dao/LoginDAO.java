package dao;

import bean.AlunoBean;
import bean.LoginBean;
import bean.TecnicoBean;
import bean.ProfessorBean;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tadeu Diniz e Lucas William
 */
public class LoginDAO {

    public static LoginBean EntradaLogin() {
        Scanner leitor = new Scanner(System.in);
        System.out.print("informe o usuario: ");
        String nome = leitor.nextLine();
        System.out.print("informe a senha: ");
        String senha = leitor.nextLine();

        String acessoprof = "professor";
        ArrayList<Object> ProfessorBean = dao.EmpacotamentoDAO.lerArquivoBinario(acessoprof);
        for (Object professor : ProfessorBean) {
            if (((ProfessorBean) professor).getLogin().equalsIgnoreCase(nome) && ((ProfessorBean) professor).getSenha().equalsIgnoreCase(senha)) {
                int siapetec = ((ProfessorBean) professor).getSiape();
                sigaa.PagProfessor.Professorp(((ProfessorBean) professor).getSiape());
                break;
            }
        }

        String acessotec = "tecnico";
        ArrayList<Object> TecnicoBean = dao.EmpacotamentoDAO.lerArquivoBinario(acessotec);
        for (Object tecnico : TecnicoBean) {
            if (((TecnicoBean) tecnico).getLogin().equalsIgnoreCase(nome) && ((TecnicoBean) tecnico).getSenha().equalsIgnoreCase(senha)) {
                int siapetec = ((TecnicoBean) tecnico).getSiape();
                sigaa.PagTecnico.Tecnicot(((TecnicoBean) tecnico).getSiape());
                break;
            }
        }
        
        String acessoal = "aluno";
        ArrayList<Object> AlunoBean = dao.EmpacotamentoDAO.lerArquivoBinario(acessoal);
        for (Object aluno : AlunoBean) {
            if (((AlunoBean) aluno).getLogin().equalsIgnoreCase(nome) && ((AlunoBean) aluno).getSenha().equalsIgnoreCase(senha)) {
                int siapetec = ((AlunoBean) aluno).getMatricula();
                sigaa.PagAluno.Alunoa(((AlunoBean) aluno).getMatricula());
                break;
            }
        }

        return null;
    }
}
