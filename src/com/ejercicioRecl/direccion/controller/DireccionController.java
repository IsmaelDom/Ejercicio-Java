package com.ejercicioRecl.direccion.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejercicioRecl.direccion.dao.DireccionDAO;
import com.ejercicioRecl.direccion.model.Direccion;
import com.ejercicioRecl.usuario.dao.UsuarioDAO;

/**
 * Servlet implementation class DireccionController
 */
@WebServlet("/DireccionController")
public class DireccionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DireccionDAO direccionDAO;
	UsuarioDAO usuarioDAO;
	
	public void init() {
		try {
			direccionDAO = new DireccionDAO();
			usuarioDAO = new UsuarioDAO();
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DireccionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("Dirección Servlet.");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			/*case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				System.out.println("entro");
				registrar(request, response);
				break;*/
			case "mostrar":
				mostrar(request, response);
				break;
			/*case "showedit":
				showEditar(request, response);
				break;	
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;*/
			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("direccion/index.jsp");
		System.out.println("######## Método mostrar clase DireccionController########");
		List<Direccion> listaDireccion= direccionDAO.listarDireccion();
		System.out.println("Servlet --> Direcciones: " + listaDireccion);
		request.setAttribute("lista", listaDireccion);
		dispatcher.forward(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//mostrar(request, response);
		System.out.println("######## Método index ########");
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usuarioDAO = new UsuarioDAO();
		
		String nombre = request.getParameter("txtUsuario");
		String pass = request.getParameter("txtPass");
		
		boolean validar = usuarioDAO.validaUsuario(nombre, pass);
		System.out.println("####### Validar :" + validar);
		
		if(validar == true) {
			try {
				System.out.println("####### Usuario Valido");
				mostrar(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("####### Usuario Invalido");
			request.getSession().setAttribute("msg", "Usuario o contraseña incorrectos, vuelva a intentarlo");
			response.sendRedirect("index.jsp");
		}
		
		if(nombre.isEmpty() || pass.isEmpty()) {
			request.getSession().setAttribute("msg", "Por favor ingrese la contraseña o el usuario");
			response.sendRedirect("index.jsp");
		}
		
	}

}
