package bean;

import java.io.Serializable;

/**
 *
 * @author Tadeu Diniz e Lucas William
 */
public class DisciplinaTurmaBean implements Serializable{
    private int turma;
    private int disciplina;
    private int professor;
    private int id_matricula;
    private int status;
    
    public DisciplinaTurmaBean(int turma, int disciplina, int professor, int id_matricula, int status) {
        this.turma = turma;
        this.disciplina = disciplina;
        this.professor = professor;
        this.id_matricula = id_matricula;
        this.status = status;
    }
    
    public DisciplinaTurmaBean() {
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

    /**
     * @return the id_matricula
     */
    public int getId_matricula() {
        return id_matricula;
    }

    /**
     * @param id_matricula the id_matricula to set
     */
    public void setId_matricula(int id_matricula) {
        this.id_matricula = id_matricula;
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
