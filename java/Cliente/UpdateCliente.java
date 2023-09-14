package Cliente;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.ClienteDAO;
import data.EmpleadoDAO;
import data.RolDAO;
import entities.Cliente;
import entities.Empleado;
import entities.Rol;


/**
 * Servlet implementation class UpdateCliente
 */
@WebServlet("/clienteeditar")
public class UpdateCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dni = request.getParameter("dni");
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente c = new Cliente();
		c.setDni(dni);
		c = cdao.getCliente(c);
		request.setAttribute("cli", c);
		
		request.getRequestDispatcher("WEB-INF/updateCliente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteDAO cdao = new ClienteDAO();
		String dni = request.getParameter("dni");
		String nom = request.getParameter("nombre");
		String dir = request.getParameter("direccion");
		
		Cliente c = new Cliente(dni,nom,dir);
	
		cdao.updateCliente(c);
		
		LinkedList<Cliente> clientes = cdao.getAll();
		request.setAttribute("listaclientes", clientes);
		
		request.getRequestDispatcher("WEB-INF/listadoClientes.jsp").forward(request, response);
	}

}
