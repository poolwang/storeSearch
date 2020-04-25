package cn.wl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.wl.pojo.ResultModel;
import cn.wl.service.ProductService;

@Controller
public class HelloController {
	@Autowired
	private ProductService productService;
	
    @RequestMapping("/productList")
    public String queryProduct(String queryString, @RequestParam("catalog_name") String catalogName, String price,
			String sort, Integer curPage, ModelMap model) {
		try {
			//查询结果
			ResultModel resultModel = productService.queryProduct(queryString, catalogName, price, sort, curPage);
			//将结果放在request作用域返回到页面
			model.addAttribute("result", resultModel);
			model.addAttribute("queryString", queryString);
			model.addAttribute("catalog_name", catalogName);
			model.addAttribute("price", price);
			model.addAttribute("sort", sort);
			model.addAttribute("page", curPage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "product_list";
	}
}
