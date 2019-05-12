package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.OrderDetailDAO;
import com.ecomm.dao.UserDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.OrderDetail;

@Controller
public class OrderController 
{ 	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderDetailDAO orderDetailDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/payment")
	public String ShowPaymentPage(Model m)
	{
		System.out.println("I am in payment mapping");
		
		String username="Hetal";
		
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		m.addAttribute("grandTotal", this.getGrandTotal(listCartItems));
		
		
		
		return "Payment";
	}
	@RequestMapping(value="/receipt",method=RequestMethod.POST)
	public String paymentProcess(@RequestParam("pmode")String pmode,Model m)
	{
		String username="Hetal";
		
		List<Cart> listCartItems=cartDAO.listCartItems(username);
		int grandTotal=this.getGrandTotal(listCartItems);
		
		OrderDetail orderDetail=new OrderDetail();
		
		orderDetail.setUsername(username);
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setPmode(pmode);
		orderDetail.setAmount(grandTotal);
		
		System.out.println("miid :"+orderDetail.getOrderId());
		
		orderDetailDAO.paymentProcess(orderDetail);
		orderDetailDAO.updateOrderDetail(username, orderDetail.getOrderId());
		orderDetailDAO.updateCartItemStatus(username);
		
		m.addAttribute("grandTotal", this.getGrandTotal(listCartItems));
		m.addAttribute("cartItemList", listCartItems);
		m.addAttribute("orderDetail", orderDetail);
		m.addAttribute("user", userDAO.getUserDetail(username));
		
	
		
		return "Receipt";
	}
	public int getGrandTotal(List<Cart> cartItemList)
	{
		int grandTotal=0;
		
		int count=0;
		
		while(count<cartItemList.size())
		{
			Cart cartItem=cartItemList.get(count);
			grandTotal=grandTotal+(cartItem.getQuantity()*cartItem.getPrice());
			count++;
		}
			return grandTotal;	
	}
}
