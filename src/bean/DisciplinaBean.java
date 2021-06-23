package bean;

import java.io.Serializable;

public class DisciplinaBean implements Serializable {
    private int duracao;
    private String nome;
    private int id_disciplina;
    
    public DisciplinaBean(String nome, int duracao, int id_disciplina) {
        this.nome = nome;
        this.duracao = duracao;
        this.id_disciplina = id_disciplina;
    }
    
    public DisciplinaBean() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**
     * @return the id_disciplina
     */
    public int getId_disciplina() {
        return id_disciplina;
    }

    /**
     * @param id_disciplina the id_disciplina to set
     */
    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }
}
