package com.ecomm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;

@Controller
public class ProductController
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	@RequestMapping(value="/product")
	public String showProductPage(Model m)
	{
		Product product=new Product();
		m.addAttribute("product", product);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productlist", listProducts);
		List<Category> categoryList=categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "product";
	}
	
	public LinkedHashMap<Integer,String> getCategoryList(List<Category> categoryList)
	{
		LinkedHashMap<Integer,String> categoryList1=new LinkedHashMap<Integer,String>();
		
		int i=0;
		while(i<categoryList.size())
		{
			Category category=categoryList.get(i);
			categoryList1.put(category.getCategoryId(),category.getCategoryName());
			i++;
		}
			return categoryList1;
		
	}
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product1,@RequestParam("pimage") MultipartFile fileImage,Model m)
	{
		productDAO.addProduct(product1);
		
		//Image Insertion
		String path="C:\\Users\\Admin\\Desktop\\BlueChipFrontend2\\src\\main\\webapp\\resources\\images\\";
		
		path=path+String.valueOf(product1.getProductId())+".jpg";
		
		File image=new File(path);
		
		if(!fileImage.isEmpty())
		{
			try
			{
				byte[] buffer=fileImage.getBytes();
				FileOutputStream fos=new FileOutputStream(image);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();
			}
			catch(Exception e)
			{
				m.addAttribute("ErrorInfo", e.getMessage());
			}
		}
		else
		{
			m.addAttribute("ErrorInfo", "Problem Occured");
		}
		
		//Complete Image Insertion
		
		Product product=new Product();
		m.addAttribute("product", product);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productlist", listProducts);
		
		List<Category> categoryList=categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "product";
		
	}
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable ("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		productDAO.deleteProduct(product);
		
		Product product1=new Product();
		m.addAttribute("product", product1);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productlist", listProducts);
		
		List<Category> categoryList=categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "product";
	}
	
	@RequestMapping(value="/editProduct/{productId}")
	public String editProduct(@PathVariable ("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		
		m.addAttribute("product", product);
		
		List<Category> categoryList=categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "UpdateProduct";
	}
	@RequestMapping(value="/editProduct/updateProduct",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product")Product product1,Model m)
	{
		productDAO.updateProduct(product1);
	
		
		Product product=new Product();
		m.addAttribute("product", product);
		
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productlist", listProducts);
		
		List<Category> categoryList=categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "product";
	}

	@RequestMapping(value="/totalProductDisplay/{productId}")
	public String totalProductDisplay(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		m.addAttribute("product", product);
		return "TotalProductDisplay";
	}
	@RequestMapping(value="/productDisplay")
	public String productDisplay(Model m)
	{
		List<Product> listProducts=productDAO.listProducts();
		m.addAttribute("productlist", listProducts);
		
		return "ProductDisplay";
	}
}
