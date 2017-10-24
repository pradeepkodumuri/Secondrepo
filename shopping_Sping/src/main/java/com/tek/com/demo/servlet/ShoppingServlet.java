package com.tek.com.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.tek.com.demo.model.Items;
import com.tek.com.demo.model.Endproduct;
import com.tek.com.demo.service.Services;

@WebServlet(urlPatterns = { "/select" })
@Configurable
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Items> ls;
	@Autowired
	Services services;
	@Override 
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String option = request.getParameter("option");
		String method = request.getParameter("method");
		// services = new shopservice();
		HttpSession session = request.getSession();
		if (session.isNew()) {
			System.out.println("map created");
			ls = new ArrayList<Items>();
			session.setAttribute("itemsAdded", ls);
		}
		if (option != null) {

			if (option.equals("1")) {

				request.setAttribute("itemslist", services.getItems());
				request.getRequestDispatcher("itemslist.jsp").forward(request, response);
			} else if (option.equals("2")) {
				request.getRequestDispatcher("checkout.jsp").forward(request, response);
			} else if (option.equals("3")) {
				request.getRequestDispatcher("AllOrders.jsp").forward(request, response);
			}

		}
		if (method != null) {

			if (request.getParameter("method").equals("AddtoCart")) {
				List<Items> sessionattribute = (List<Items>) session.getAttribute("itemsAdded");
				String itemno = request.getParameter("itemno");
				String quantity = request.getParameter("quantity");
				Items selectedItem = services.getitem(itemno);
				selectedItem.setQuantity(quantity);
				System.out.println(selectedItem.getName());
				sessionattribute.add(selectedItem);
				session.setAttribute("itemsAdded", sessionattribute);

				request.setAttribute("itemslist", services.getItems());
				request.getRequestDispatcher("itemslist.jsp").forward(request, response);

			}

			else if (request.getParameter("method").equals("Checkout")) {

				request.getRequestDispatcher("checkout.jsp").forward(request, response);

			} else if (request.getParameter("method").equals("PlaceOrder")) {
				System.out.println(request.getParameter("user"));
				Endproduct r = new Endproduct((List<Items>) session.getAttribute("itemsAdded"),
						request.getParameter("user"));
				services.save(r);
				request.getRequestDispatcher("order.jsp").forward(request, response);

			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
