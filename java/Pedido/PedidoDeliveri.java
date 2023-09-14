package Pedido;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.PedidoDAO;
import entities.Cliente;
import entities.Empleado;
import entities.LineaPedido;
import entities.Pedido;

/**
 * Servlet implementation class PedidoDeliveri
 */
@WebServlet("/PedidoDeliveri")
public class PedidoDeliveri extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidoDeliveri() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Cliente cliente = new Cliente();
		cliente = (Cliente) session.getAttribute("cliente");
		
		String servicio = request.getParameter("servicio");
		String[] cantidades = request.getParameterValues("cantidad");
		
		LinkedList<LineaPedido> lineas = (LinkedList<LineaPedido>) session.getAttribute("lineas");
		Pedido p = new Pedido();
			
		int i = 0;
		for(LineaPedido lp : lineas) {
				
			lp.setCantidad(Integer.parseInt(cantidades[i]));
			p.addLineaPedido(lp);
			System.out.println("La cantidad del item " + i + " es " + cantidades[i]);
			i++;
		}
			
		
		Empleado e = new Empleado();
		
		e.setDni("52144578");
		p.setEstado("En preparación");
		p.setCliente(cliente);
		p.setEmpleado(e);
		PedidoDAO pdao = new PedidoDAO();
		p.setTipoPedido("Presencial");
		pdao.newPedido(p);
		response.sendRedirect("listadopedido");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
