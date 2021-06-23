package bean;

import java.io.Serializable;

/**
 *
 * @author Tadeu Diniz e Lucas William
 */
public class ProfessorBean extends PessoaBean implements Serializable {

    private int siape;

    public ProfessorBean(String nome, String endereco, String cpf, String telefone, String login, String senha, int nivel, int siape) {
        this.siape = siape;
        super.setNome(nome);
        super.setEndereco(endereco);
        super.setCpf(cpf);
        super.setTelefone(telefone);
        super.setLogin(login);
        super.setSenha(senha);
        super.setNivel(nivel);
    }
    
    public ProfessorBean() {
    }

    /**
     * @return the siape
     */
    public int getSiape() {
        return siape;
    }

    /**
     * @param siape the siape to set
     */
    public void setSiape(int siape) {
        this.siape = siape;
    }

}
