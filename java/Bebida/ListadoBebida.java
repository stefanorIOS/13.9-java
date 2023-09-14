package Bebida;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import data.BebidaDAO;

import entities.Bebida;


/**
 * Servlet implementation class AltaBebida
 */
@WebServlet("/listadobebida")
@MultipartConfig
public class ListadoBebida extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pathFiles = "C:\\Users\\stefano\\Documents\\javaProjects\\Java-Foodtruck-9.8\\Foodtruck-web\\src\\main\\webapp\\img\\";
	private File uploads = new File(pathFiles);
	private String[] extens = {".ico", ".png", ".jpg", ".jpeg"};
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoBebida() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//Listamos bebida
		BebidaDAO listadoBebida = new BebidaDAO();
		LinkedList<Bebida> bebidas = listadoBebida.getAll();
		request.setAttribute("listadoBebida", bebidas);
		request.getRequestDispatcher("WEB-INF/listadoBebida.jsp").forward(request, response);
		
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    

}
