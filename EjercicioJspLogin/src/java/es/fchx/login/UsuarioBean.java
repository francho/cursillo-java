package es.fchx.login;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class UsuarioBean {
    private String login;
    private String nombreCompleto;
    private String password;
    private Boolean validado;

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
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the validado
     */
    public Boolean getValidado() {
        return validado;
    }

    /**
     * @param validado the validado to set
     */
    public void setValidado(Boolean validado) {
        this.validado = validado;
    }

    @Override
    public boolean equals(Object u) {
        if(u.getClass() != this.getClass()) {
            return false;
        } else {
            UsuarioBean u2 = (UsuarioBean)u;
            return login.equals(u2.getLogin()) && password.equals(u2.getPassword());
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.login != null ? this.login.hashCode() : 0);
        hash = 23 * hash + (this.password != null ? this.password.hashCode() : 0);
        return hash;
    }
    
}
