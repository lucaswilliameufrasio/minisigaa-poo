package bean;

import java.io.Serializable;

/**
 *
 * @author Tadeu Diniz
 */
public class LoginBean implements Serializable{
    private String login;
    private String senha;
    private int nivel;
    
    public LoginBean(String login, String senha, int nivel) {
        this.login = login;
        this.senha = senha;
        this.nivel = nivel;
    }
    
    public LoginBean() {
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}