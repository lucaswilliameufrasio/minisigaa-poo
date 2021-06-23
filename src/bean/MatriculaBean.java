package bean;

import java.io.Serializable;

/**
 *
 * @author Tadeu Diniz
 */
public class MatriculaBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private int aluno;
    private int disciplina;
    private int professor;
    private int status;
    private int idmatricula;
    private int turma;
    
    public MatriculaBean(int aluno, int disciplina, int status, int idmatricula, int turma, int professor) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.status = status;
        this.idmatricula = idmatricula;
        this.turma = turma;
        this.professor = professor;
    }
    
    public MatriculaBean() {
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

    /**
     * @return the idmatricula
     */
    public int getIdmatricula() {
        return idmatricula;
    }

    /**
     * @param idmatricula the idmatricula to set
     */
    public void setIdmatricula(int idmatricula) {
        this.idmatricula = idmatricula;
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

    /**
     * @return the professor
     */
    public int getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(int professor) {
        this.professor = professor;
    }
    
}
