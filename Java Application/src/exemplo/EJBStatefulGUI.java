/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo;

import exemplo.bean.GUIBean;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class EJBStatefulGUI extends GUIBean {

    protected EJBStatefulExemploInterface beanStateful;

    public EJBStatefulGUI() {
        super();
        try {
            Properties props = new Properties();
            props.load(new java.io.FileInputStream("jndi.properties"));
            InitialContext ctx = new InitialContext(props);
            beanStateful = (EJBStatefulExemploInterface) ctx.lookup("ejb/EJBStatefulExemplo");
        } catch (IOException | NamingException e) {
            System.err.println("Erro ao tentar achar EBJs:");
            e.printStackTrace(System.err);
            JOptionPane.showMessageDialog(this.getParent(), "Erro ao conectar ao servidor.");
            btnEnvia.setEnabled(false);
        }
    }

    @Override
    protected void btnEnvia(ActionEvent evt) {
        String s;
        double d;
        int i;
        try {
            s = txtString.getText();
            d = Double.parseDouble(txtDouble.getText());
            i = Integer.parseInt(txtInt.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Algum número informado é inválido!");
            return;
        }
        beanStateful.set(new ObjetoExemplo(s, i, d));
        JOptionPane.showConfirmDialog(this, "Resultado EJBStatefulExemploInterface: " + beanStateful.get());
    }
}
