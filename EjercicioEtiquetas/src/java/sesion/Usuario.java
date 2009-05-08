/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sesion;

import java.io.Serializable;

/**
 *
 * @author AdminLocal
 */
public class Usuario implements Serializable{
    private String identificador;
    private String nombreCompleto;
    private String password;
    private Boolean validado;

    public Usuario()
    {
        identificador = "";
        nombreCompleto = "";
        password = "";
        validado = false;
    }
    /**
     * @return the identificador
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
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

}
