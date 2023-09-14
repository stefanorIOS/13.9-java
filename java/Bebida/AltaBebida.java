package Bebida;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
@WebServlet("/altabebida")
@MultipartConfig
public class AltaBebida extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pathFiles = "C:\\Users\\Usuario\\Desktop\\Laureano\\Universidad\\2023\\Java (elect)\\Foodtruck\\Java-Foodtruck\\Foodtruck-web\\src\\main\\webapp\\img";
	private File uploads = new File(pathFiles);
	private String[] extens = {".ico", ".png", ".jpg", ".jpeg"};
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaBebida() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/altaBebida.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		float precio = Float.parseFloat(request.getParameter("precio"));
		String nombre = request.getParameter("nombre");
		float litros = Float.parseFloat(request.getParameter("litros"));
		
		Bebida b = new Bebida(precio, nombre, litros);
		
		
		
		Part part = request.getPart("imagen");
		
		if(part == null) {
			System.out.println("No ha seleccionado un archivo");
			return;
		}
		
		if(isExtension(part.getSubmittedFileName(), extens)) {
			String photo = saveFile(part,uploads);
			b.setFoto(photo);
		}
		
		
		BebidaDAO bdao = new BebidaDAO();
		
		bdao.newBebida(b);
		
		response.sendRedirect("listadobebida");
		
	}
    
    	private String saveFile(Part part, File pathUploads) {
		
		String pathAbsolute = "";
		String fileName = "";
		
		try {
			
			Path path = Paths.get(part.getSubmittedFileName());
			Random random = new Random();
			fileName = (random.nextInt(1000) + 1) + path.getFileName().toString();
			
			InputStream input = part.getInputStream();
			
			if(input != null) {
				File file = new File(pathUploads, fileName);
				pathAbsolute = file.getAbsolutePath();
				
				// Guardamos el archivo
				Files.copy(input, file.toPath()); 
			}
			
			
		} catch (Exception e) {
			
		}
		
		return "img/" + fileName;
		
	}
	
	private boolean isExtension(String fileName, String[] extensions) {
		for(String et : extensions) {
			if(fileName.toLowerCase().endsWith(et)) {
				return true;
			}
		}
		return false;
	}

}
