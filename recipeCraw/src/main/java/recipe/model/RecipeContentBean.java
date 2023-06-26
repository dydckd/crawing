package recipe.model;

public class RecipeContentBean {
	private int recipecontentnum;
	private int recipenum;
	private String recipeimage;
	private String cookcontent;
	
	
	public String getRecipeimage() {
		return recipeimage;
	}
	public void setRecipeimage(String recipeimage) {
		this.recipeimage = recipeimage;
	}
	public int getRecipecontentnum() {
		return recipecontentnum;
	}
	public void setRecipecontentnum(int recipecontentnum) {
		this.recipecontentnum = recipecontentnum;
	}
	public int getRecipenum() {
		return recipenum;
	}
	public void setRecipenum(int recipenum) {
		this.recipenum = recipenum;
	}
	public String getCookcontent() {
		return cookcontent;
	}
	public void setCookcontent(String cookcontent) {
		this.cookcontent = cookcontent;
	}
	
	
}
