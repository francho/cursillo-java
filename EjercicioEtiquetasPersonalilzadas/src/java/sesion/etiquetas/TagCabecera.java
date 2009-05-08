/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sesion.etiquetas;

import java.io.IOException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import sesion.Usuario;

/**
 *
 * @author Administrador
 */
public class TagCabecera extends BodyTagSupport {

    @Override
    public int doStartTag() throws JspTagException {
        // el motor JSP llama este método cuando encuentre el
        // comienzo de una marca implementada por esta clase
        return SKIP_BODY;

    }

    @Override
    public int doEndTag() throws JspTagException {
        // el motor llama este método cuando encuentre el
        // final de una marca implementada por esta clase

        try {

            Usuario usuario = (Usuario) pageContext.getSession().getAttribute("usuario");

            if (usuario.getValidado()) {
                pageContext.getOut().write("Bienvenido " + usuario.getNombreCompleto());
                pageContext.getOut().write("| <a href=\"logout\">Logout</a>");
            } else {
                pageContext.getOut().write("Usuario no identificado ");
                pageContext.getOut().write("| <a href=\"login.jsp\">Login</a> ");
                pageContext.getOut().write("| <a href=\"registro.jsp\">Registrarse</a> ");
            }

        } catch (IOException ex) {
            throw new JspTagException("Error: la etiqueta hola no puede escribir en la salida del JSP");
        }
        return EVAL_PAGE;
    }
}
