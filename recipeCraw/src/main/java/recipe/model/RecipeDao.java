package recipe.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecipeDao {
	private final String namespace="recipe.model.RecipeBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insertRecipe(RecipeBean rbean) {
		int cnt=-1;
		cnt=sqlSessionTemplate.insert(namespace+".InsertRecipe", rbean);
		return cnt;
	}
	
	public int getNum(String title) {
		int cnt = sqlSessionTemplate.selectOne(namespace+".GetNum", title);
		return cnt;
	}
	
	public int insertRecipeContent(RecipeContentBean rcbean) {
		int cnt = sqlSessionTemplate.insert(namespace+".InsertRecipeContent",rcbean);
		return cnt;
	}
	
	public int insertFood(FoodBean fbean) {
		int cnt = sqlSessionTemplate.insert(namespace+".InsertFood",fbean);
		return cnt;
	}
	public boolean checkCate(String ingre) {
		boolean flag = false;
		int cnt =-1;
		cnt = sqlSessionTemplate.selectOne(namespace+".CheckCate", ingre);
		if(cnt>0) {
			flag = true;
		}
		return flag;
	}
	
	public String getCate(String ingre) {
		String cate = sqlSessionTemplate.selectOne(namespace+".GetCate",ingre);
		return cate;
	}
	
	public List<String> getIngredient(){
		List<String> ingredientList = sqlSessionTemplate.selectList(namespace+".GetIngredient");
		return ingredientList;
	}
	
}
