package bean;

import java.io.Serializable;

public class AlunoBean extends PessoaBean implements Serializable {
    //Declara as variáveis
    private int matricula;
    private int curso;
    private int status;
    
    //Inicia as variáveis
    public AlunoBean(String nome, String endereco, String cpf, String telefone, int status, String login, String senha, int nivel, int matricula, int curso) {
        this.matricula = matricula;
        this.curso = curso;
        super.setNome(nome);
        super.setEndereco(endereco);
        super.setCpf(cpf);
        super.setTelefone(telefone);
        super.setLogin(login);
        super.setSenha(senha);
        this.status = status;
        super.setNivel(nivel);
    }
    
    //Construtor
    public AlunoBean() {
    }

    /**
     * @return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the curso
     */
    public int getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(int curso) {
        this.curso = curso;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
}

 