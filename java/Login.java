

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.EmpleadoDAO;
import entities.Empleado;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dni = request.getParameter("dni");
		String pass = request.getParameter("password");
		
		Empleado e = new Empleado();
		e.setDni(dni);
		e.setPassword(pass);
		System.out.println(dni + pass);
		
		EmpleadoDAO edao = new EmpleadoDAO();
		Empleado emp = edao.login(e);
		
		if (emp != null) {
			
			request.getSession().setAttribute("empleado", emp);
			response.sendRedirect("WEB-INF/administracion.jsp");
		} else {
			request.setAttribute("mensaje", "Las credenciales no coinciden con nuestros datos.");
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		}
		
	}

}
