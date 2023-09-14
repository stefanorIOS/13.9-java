package Cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.ClienteDAO;
import entities.Cliente;

/**
 * Servlet implementation class busquedaCliente
 */
@WebServlet("/busquedaCliente")
public class busquedaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public busquedaCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre =  request.getParameter("name");
		String dni =  request.getParameter("dni");
		String direccion =  request.getParameter("direccion");
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente c = new Cliente();
		Cliente busquedaC = new Cliente();
		
		c.setDni(dni);
		c.setDireccion(direccion);
		c.setNombre(nombre);
		
		busquedaC = cdao.getCliente(c);
		
		if(busquedaC == null) {
			request.getRequestDispatcher("WEB-INF/altaCliente.jsp").forward(request, response);
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("cliente", c);
			response.sendRedirect("PedidoDeliveri");
			
			
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
