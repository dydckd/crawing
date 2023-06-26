package recipe.model;

public class RecipeBean {
	private int recipenum;
	private String recipename;
	private String recipecategory;
	private String servings;
	private String cookimage;
	private int readcount;
	
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public int getRecipenum() {
		return recipenum;
	}
	public void setRecipenum(int recipenum) {
		this.recipenum = recipenum;
	}
	public String getRecipename() {
		return recipename;
	}
	public void setRecipename(String recipename) {
		this.recipename = recipename;
	}
	public String getRecipecategory() {
		return recipecategory;
	}
	public void setRecipecategory(String recipecategory) {
		this.recipecategory = recipecategory;
	}
	public String getServings() {
		return servings;
	}
	public void setServings(String servings) {
		this.servings = servings;
	}
	public String getCookimage() {
		return cookimage;
	}
	public void setCookimage(String cookimage) {
		this.cookimage = cookimage;
	}
	
	
	
}
