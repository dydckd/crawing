package com.spring.ex;

import recipe.model.FoodBean;
import recipe.model.RecipeDao;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecipeDao rdao = new RecipeDao();
		FoodBean fbean = new FoodBean();
		String ingre = "´ßºÀ ±¸¸Å 2ÆÑ";
		String x = "ÆÄÇÁ¸®Ä«";
		
		int index = ingre.indexOf("±¸¸Å");
		System.out.println(index);
		System.out.println(ingre.length()-index);
		String ingre2=null;
		String ingre3=null;
		
		if(ingre.length()-index == 2) {
			ingre2 = ingre.substring(0, index);
			ingre3 = "";
		}else {
			ingre2 = ingre.substring(0, index);
			ingre3 = ingre.substring(index+2);
		}
		System.out.println(index);
		System.out.println(ingre2);
		System.out.println(ingre3);
	}

}
