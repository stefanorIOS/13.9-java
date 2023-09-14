package Cliente;


import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.ClienteDAO;
import entities.Cliente;

/**
 * Servlet implementation class DeleteCliente
 */
@WebServlet("/clienteborrar")
public class DeleteCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dni = request.getParameter("dni");
		
		Cliente c = new Cliente();
		c.setDni(dni);
		ClienteDAO cdao = new ClienteDAO();
		
		cdao.deleteCliente(c);
		LinkedList<Cliente> clientes = cdao.getAll();
		request.setAttribute("listaclientes", clientes);
		
		request.getRequestDispatcher("WEB-INF/listadoClientes.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
