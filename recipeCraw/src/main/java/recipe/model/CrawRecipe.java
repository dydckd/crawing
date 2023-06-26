package recipe.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class CrawRecipe {
	
	//요리순서 불러오는 메서드
	
	//식재료 불러오는 메서드(map key:재료이름 value:재료용량)
	public Map<String, String> ingrediant(String url){
		Map<String, String> ing_map=null;
		final String Url = url;
		Connection conn = Jsoup.connect(Url);
		try {
				Document document = conn.get();
				Elements ingrediant = document.select("div.ready_ingre3");
				Iterator<Element> jaeryo = ingrediant.select("li").iterator();
				ing_map = new HashMap<String, String>();
				while(jaeryo.hasNext()) {
					String y = jaeryo.next().text();
					System.out.println(y);
					int index = y.indexOf("구매");
					String a= null;
					String b= null;
					
					if(y.length()-index == 2) {
						 a = y.substring(0, index);
						 b = "";
					}else {
						 a = y.substring(0, index);
						 b = y.substring(index+2);
					}
					ing_map.put(a, b);
					//String[] x= jaeryo.next().text().replace("구매", "").split(" ", 2);
					//for(int i=0 ; i< x.length-1 ;i++) {
						//ing_map.put(x[i], x[i+1]);
					//}
				}
				
			} catch (IOException e) {
						e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return ing_map;
	}
	//몇인분인지 불러오는 메서드
	public String amount(String url) {
		String amounts="";
		final String Url = url;
		Connection conn = Jsoup.connect(Url);
		try {
				Document document = conn.get();
				Elements amount = document.select("div.view2_summary>div.view2_summary_info");
				String[] inbun = amount.select("span").text().split(" ", 2);
				for(int j=0;j<inbun.length-1;j++) {
					amounts = inbun[0].substring(0, 1);
				}
				
			} catch (IOException e) {
						e.printStackTrace();
			}
		return amounts;
	}
	
	//레시피 이름 불러오는 메서드
	public String title(String url) {
		String name="";
		Connection conn = Jsoup.connect(url);
		try {
				Document document = conn.get();
				Elements titles = document.select("div.view2_summary");
				 name = titles.select("h3").text();
				
			} catch (IOException e) {
						e.printStackTrace();
			}
		return name;
	}
	//레시피 완성 이미지 불러오는 메서드
	public String recipe_image(String url) {
		String Thumbs="";
		final String Url = url;
		Connection conn = Jsoup.connect(Url);
		try {
				Document document = conn.get();
				Elements mainThumbs = document.select("div.centeredcrop");
				Thumbs = mainThumbs.select("img").attr("src");
				
			} catch (IOException e) {
						e.printStackTrace();
			}
		return Thumbs;
	}
	
	//요리순서 이미지 불러오는 메서드
	public List<String> cook_image(String url) {
		List<String> imgList=new ArrayList<String>();
		final String Url = url;
		Connection conn = Jsoup.connect(Url);
		try {
				Document document = conn.get();
				Elements step = document.select("div.view_step>div.view_step_cont");
				for (int k = 0; k < step.select("img").size(); k++) {
					final String img = step.select("img").get(k).attr("src");
					imgList.add(img);
					}
			} catch (IOException e) {
						e.printStackTrace();
			}
		return imgList;
	}
	
	public List<String> cook_step(String url) {
		List<String> cookList=new ArrayList<String>();
		final String Url = url;
		Connection conn = Jsoup.connect(Url);
		try {
				Document document = conn.get();
				Elements step = document.select("div.view_step>div.view_step_cont");
				for (int k = 0; k < step.size(); k++) {
					final String cook = step.get(k).text();
					cookList.add(cook);
					}
			} catch (IOException e) {
						e.printStackTrace();
			}
		return cookList;
	}
	
	
}
