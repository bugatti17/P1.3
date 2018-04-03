package Practica3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String idSesion="";
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//Inicio de sesion
		HttpSession sesion = request.getSession(true);
		String url="";
		if(idSesion.equals("")){
		idSesion =sesion.getId();
		}
		
	
		
		String nombre = request.getParameter("name");
		sesion.setAttribute("Nombre", nombre);
		//Lo añadimos a la petición. Pues para la sesion deberemos 
		//utilizar sessionscope que no lo ha explicado
		request.setAttribute("Nombre", nombre);
		
		String apellido = request.getParameter("surname");
		sesion.setAttribute("Apellido", apellido);
		//Lo añadimos a la petición. Pues para la sesion deberemos 
		//utilizar sessionscope que no lo ha explicado
		request.setAttribute("Apellido", apellido);
		
		String email = request.getParameter("email");
		sesion.setAttribute("Email", email);
		//Lo añadimos a la petición. Pues para la sesion deberemos 
		//utilizar sessionscope que no lo ha explicado
		request.setAttribute("Email", email);
	
		sesion.setMaxInactiveInterval(5);

		
		if(idSesion.equals(sesion.getId())) {
		url="/WEB-INF/sesion.jsp";	
		}else {
			url="/index.html";
			sesion.invalidate();
			idSesion="";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);

				
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}