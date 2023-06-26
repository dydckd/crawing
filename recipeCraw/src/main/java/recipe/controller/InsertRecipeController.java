package recipe.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import recipe.model.CrawRecipe;
import recipe.model.CrawUrl;
import recipe.model.FoodBean;
import recipe.model.RecipeBean;
import recipe.model.RecipeContentBean;
import recipe.model.RecipeDao;

@Controller
public class InsertRecipeController {
	private final String command="/insert.craw";
	private final String getPage="view";
	
	
	@Autowired
	RecipeDao rdao;
	
	@Autowired
	CrawUrl curl;
	
	@Autowired
	CrawRecipe recipe;
	
	@RequestMapping(value=command)
	public String doAction(@RequestParam("url") String url, @RequestParam("category") String category) {
		List<String> urlList = curl.getUrl(url);
		for(String Url : urlList) {
			List<String> cook_step =recipe.cook_step(Url);
			List<String> cook_img = recipe.cook_image(Url);
			if(cook_step.size()== cook_img.size()) {
				RecipeBean rbean = new RecipeBean();
				rbean.setRecipename(recipe.title(Url));
				rbean.setRecipecategory(category);
				rbean.setServings(recipe.amount(Url));
				rbean.setCookimage(recipe.recipe_image(Url));
				rdao.insertRecipe(rbean);
				int recipenum = rdao.getNum(recipe.title(Url));
				System.out.println(recipenum);
				System.out.println(recipe.title(Url));
				RecipeContentBean rcbean = new RecipeContentBean();
				System.out.println("¼³¸í°¹¼ö:"+cook_step.size());
				System.out.println("±×¸²°¹¼ö:"+cook_img.size());
				for(int i=0;i<cook_step.size();i++) {
					rcbean.setRecipenum(recipenum);
					rcbean.setCookcontent(cook_step.get(i));
					rcbean.setRecipeimage(cook_img.get(i));
					int cnt= rdao.insertRecipeContent(rcbean);
					System.out.println(cnt);
				}
				
				Map<String, String> map = recipe.ingrediant(Url);
				FoodBean fbean = new FoodBean();
				Iterator<String> iter = map.keySet().iterator();
				while(iter.hasNext()) {
					fbean.setRecipenum(recipenum);
					String ingre = iter.next();
					String amount = map.get(ingre).trim();
					System.out.println(ingre);
					boolean result = rdao.checkCate(ingre);
					System.out.println(result);
					if(result) {
						String cate = rdao.getCate(ingre);
						System.out.println(cate);
						fbean.setFoodcategory(cate);
					}else {
						List<String> ingreList = rdao.getIngredient();
						for(String x: ingreList) {
							
							boolean ingflag =ingre.contains(x);
							if(ingflag) {
								fbean.setFoodcategory(rdao.getCate(x));
								System.out.println(rdao.getCate(x));
								break;
							}else {
								fbean.setFoodcategory("");
							}
						}
					}
					fbean.setFoodname(ingre);
					fbean.setFoodamount(amount);
					int cnt = rdao.insertFood(fbean);
					System.out.println(cnt);
				}
				
			}
		}
		return getPage;
	}
	
}
