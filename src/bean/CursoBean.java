package bean;

import java.io.Serializable;

public class CursoBean implements Serializable{
    private String nome;
    private int duracao;
    private int id_curso;
    
    public CursoBean(String nome, int duracao, int id_curso) {
        this.nome = nome;
        this.duracao = duracao;
        this.id_curso = id_curso;
    }
    
    public CursoBean() {
        TurmaBean turma = new TurmaBean();
        DisciplinaBean disciplina = new DisciplinaBean();
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
     * @return the id_curso
     */
    public int getId_curso() {
        return id_curso;
    }

    /**
     * @param id_curso the id_curso to set
     */
    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }
}