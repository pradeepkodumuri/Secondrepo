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
import com.tek.com.demo.model.finalorder;
import com.tek.com.demo.service.ServicesOfShop;

@WebServlet(urlPatterns = { "/select" })
@Configurable
public class ShoppingServlet extends HttpServlet {


	List<Items> ls;
	@Autowired
	ServicesOfShop shpser;
	@Override 
	public void init() throws ServletException{
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,getServletConfig().getServletContext());
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String option = request.getParameter("option");
		String method = request.getParameter("method");
		// shpser = new shopservice();
		HttpSession session = request.getSession();
		if (session.isNew()) {
			System.out.println("map created");
			ls = new ArrayList<Items>();
			session.setAttribute("itemsAdded", ls);
		}
		if (option != null) {

			if (option.equals("1")) {

				request.setAttribute("itemslist", shpser.getItems());
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
				Items selectedItem = shpser.getitem(itemno);
				selectedItem.setQuantity(quantity);
				System.out.println(selectedItem.getName());
				sessionattribute.add(selectedItem);
				session.setAttribute("itemsAdded", sessionattribute);

				request.setAttribute("itemslist", shpser.getItems());
				request.getRequestDispatcher("itemslist.jsp").forward(request, response);

			}

			else if (request.getParameter("method").equals("Checkout")) {

				request.getRequestDispatcher("checkout.jsp").forward(request, response);

			} else if (request.getParameter("method").equals("PlaceOrder")) {
				System.out.println(request.getParameter("user"));
				finalorder r = new finalorder((List<Items>) session.getAttribute("itemsAdded"),
						request.getParameter("user"));
				shpser.save(r);
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
