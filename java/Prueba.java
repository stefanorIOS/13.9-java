import java.util.LinkedList;

import data.PedidoDAO;
import entities.Bebida;
import entities.Cliente;
import entities.Empleado;
import entities.LineaPedido;
import entities.Pedido;
import entities.Plato;

public class Prueba {

	public static void main(String[] args) {
		
		//getall
		
		PedidoDAO pdao = new PedidoDAO();
		
		LinkedList<Pedido> pedidos = pdao.getAll();
		
		for(Pedido p : pedidos) {
			
			System.out.println("Pedido: " + p.getId());
			
			for(LineaPedido lp : p.getLineas()) {
				
				if (lp.getProducto() instanceof Plato) {
					Plato plato = (Plato) lp.getProducto();
					System.out.println("Linea: " + plato.getNombre());
				} else {
					Bebida bebida = (Bebida) lp.getProducto();
					System.out.println("Linea: " + bebida.getNombre());
				}
				
				
				
				
			}
			
		}
		
		//get
	
		Pedido pedido = new Pedido();
		pedido.setId(8);
		pedido = pdao.getPedido(pedido);
		
		for(LineaPedido lp : pedido.getLineas()) {
			
			Plato plato = (Plato) lp.getProducto();
			
			System.out.println("Linea get: " + plato.getNombre());
			
		}
		
		
		// New pedido
		/*
		Pedido pe = new Pedido();
		Empleado e = new Empleado();
		Cliente c = new Cliente();
		e.setDni("52144578");
		
		pe.setEmpleado(e);
		pe.setCliente(c);
		
		pe.setEstado("En preparación");
		pe.setTipoPedido("Presencial");
		
		LineaPedido lp1 = new LineaPedido();
		Plato plato = new Plato();
		plato.setId(2);
		
		lp1.setCantidad(3);
		lp1.setProducto(plato);
		
		pe.addLineaPedido(lp1);
		
		pdao.newPedido(pe);
		*/
		
		
		
		
		

	}

}
