package bean;

import java.io.Serializable;

/**
 *
 * @author Tadeu Diniz e Lucas William
 */
public class NotaBean implements Serializable {

    private float nota1;
    private float nota2;
    private float nota3;
    private int aluno;
    private int disciplina;
    private int turma;

    public NotaBean(float nota1, float nota2, float nota3, int aluno, int disciplina, int turma) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.turma = turma;
    }

    public NotaBean() {
    }

    /**
     * @return the nota1
     */
    public float getNota1() {
        return nota1;
    }

    /**
     * @param nota1 the nota1 to set
     */
    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    /**
     * @return the nota2
     */
    public float getNota2() {
        return nota2;
    }

    /**
     * @param nota2 the nota2 to set
     */
    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    /**
     * @return the nota3
     */
    public float getNota3() {
        return nota3;
    }

    /**
     * @param nota3 the nota3 to set
     */
    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    /**
     * @return the aluno
     */
    public int getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(int aluno) {
        this.aluno = aluno;
    }

    /**
     * @return the disciplina
     */
    public int getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(int disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the turma
     */
    public int getTurma() {
        return turma;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(int turma) {
        this.turma = turma;
    }

    
}
