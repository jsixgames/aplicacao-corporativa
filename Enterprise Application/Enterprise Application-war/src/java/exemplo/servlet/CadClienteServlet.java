package exemplo.servlet;

import exemplo.jpa.CadCliente;
import exemplo.jpa.facade.CadClienteFacadeRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadClienteServlet", urlPatterns = {"/CadClienteServlet"})
public class CadClienteServlet extends HttpServlet {

    @EJB
    private CadClienteFacadeRemote cadclienteFacade;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadClienteServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cadastro de Clientes</h1>");
            out.println("<h2>Cadastrar Cliente</h2>");
            out.println("<form action=\"CadClienteServlet\" method=\"post\">");
            out.println("<b>\n" +
"            Nome: <input type=\"text\" name=\"nome\" value=\"\" autofocus required /> <br/>\n" +
"            Sobrenome: <input type=\"text\" name=\"sobrenome\" value=\"\" required/> <br/>\n" +
"            Data de nascimento: <input type=\"text\" name=\"data\" value=\"\" required/><br/>\n" +
"            CPF: <input type=\"text\" name=\"cpf\" value=\"\" required/><br/> \n" +
"            Telefone: <input type=\"text\" name=\"telefone\" value=\"\" required/><br/>\n" +
"            Email: <input type=\"email\" name=\"email\" value=\"\" required/>\n" +
"            <input type=\"submit\" value=\"Verificar\" name=\"B3\" style=\"font-size: 10pt; font-family: Verdana\" onClick=\"this.form.action='Principal.jsp'\"> <br/>\n" +
"            Senha: <input type=\"password\" name=\"senha\" value=\"\" required/> <br/>\n" +
"            Sexo: <input type=\"radio\" name=\"sexo\" value =\"masculino\" required>Masculino\n" +
"                  <input type=\"radio\" name=\"sexo\" value =\"feminino\" required>Feminino <br/><br/>\n" +
"            </b>\n" +
"            <input type=\"reset\" style=\"height: 40px; width: 150px; \" value=\"Limpar Campos\"/>\n" +
"            <input type=\"submit\" style=\"height: 40px; width: 150px; margin-left: 5px;\" name='cadastrar' value=\"Cadastrar\"/>");
           
            if (request.getParameter("cadastrar") != null && request.getParameter("cadastrar").equals("Cadastrar")) {
                try {
                    out.println("<font color=\"red\">");
                    CadCliente c = new CadCliente();   
                    c.setNome(request.getParameter("nome"));
                    c.setSobrenome(request.getParameter("sobrenome"));
                    c.setDnascimento(null);
                    c.setCpf(Long.MIN_VALUE);
                    c.setTelefone(Long.MIN_VALUE);
                    c.setEmail(request.getParameter("email"));
                    c.setSenha(request.getParameter("senha"));
                    c.setSexo(request.getParameter("sexo"));
                    cadclienteFacade.create(c);
                    out.println("Contato cadastrado com sucesso.");
                } catch (Exception e) {
                    out.println("Erro ao gravar Contato.");
                } finally {
                    out.println("</font>");
                }
            }

            out.println("<h2>Contatos Cadastrados</h2>");
            List<CadCliente> list = cadclienteFacade.findAll();
            for (CadCliente cliente : list) {
                out.println(cliente + "<br/>");
            }
            out.println("<br/>");
            out.println("<a href=\".\">Voltar</a>");;
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
