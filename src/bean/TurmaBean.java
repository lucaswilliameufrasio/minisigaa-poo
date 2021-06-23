package bean;

import java.io.Serializable;

public class TurmaBean implements Serializable {
    private int nome;
    private int ano;
    private int turno;
    private int id_turma;
    
    public TurmaBean(int nome, int ano, int turno, int id_turma) {
        this.nome = nome;
        this.ano = ano;
        this.turno = turno;
        this.id_turma = id_turma;
    }
    
    public TurmaBean() {
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the id_turma
     */
    public int getId_turma() {
        return id_turma;
    }

    /**
     * @param id_turma the id_turma to set
     */
    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }
}