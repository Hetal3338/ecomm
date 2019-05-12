package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Cart;
import com.ecomm.model.Product;

@Controller
public class CartController 
{
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/showCart")
	public String showCart(Model m)
	{
		String username="Hetal";
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		
		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
		
		
		return "MyCart";
	}
	
	@RequestMapping(value="totalProductDisplay/addToCart/{productId}")
	public String addToCart(@PathVariable("productId")int productId,@RequestParam("quantity")int quantity,Model m)
	{
		
		
		Product product=productDAO.getProduct(productId);
		Cart cartItem=new Cart();
		
		String username="Hetal";
		
		cartItem.setProductId(product.getProductId());
		cartItem.setProductName(product.getProductName());
		cartItem.setPrice(product.getPrice());
		cartItem.setQuantity(quantity);
		cartItem.setUsername(username);
		cartItem.setPstatus("NP");
		
		cartDAO.addCartItem(cartItem);
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		
		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
		
		
		return "MyCart";
	}
	@RequestMapping(value="/updateCartItem/{cartItemId}")
	public String updateCartItem(@PathVariable("cartItemId")int cartItemId,@RequestParam("quantity")int quantity,Model m)
	{
		String username="Hetal";
		
		Cart cartItem=cartDAO.getCartItem(cartItemId);
		cartItem.setQuantity(quantity);
		cartDAO.updateCartItem(cartItem);
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		
		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
		
		return "MyCart";
	}
	@RequestMapping(value="/deleteCartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId")int cartItemId,Model m)
	{
		String username="Hetal";
		
		Cart cartItem=cartDAO.getCartItem(cartItemId);
		cartDAO.deleteCartItem(cartItem);
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		
		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
		
		return "MyCart";
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
	@RequestMapping(value="/checkout")
	public String showOrderConfim(Model m)
	{
		String username="Hetal";
		
		List<Cart> cartItemList=cartDAO.listCartItems(username);
		
		m.addAttribute("cartItemList", cartItemList);
		m.addAttribute("grandTotal", this.getGrandTotal(cartItemList));
		
		
		return "OrderConfirm";
	}
}
