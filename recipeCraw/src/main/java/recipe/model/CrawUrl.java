package recipe.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class CrawUrl {
	
	//final String Url = "https://www.10000recipe.com/ranking/home_new.html";

	public List<String> getUrl(String Url) {
		List<String> urlList = new ArrayList<String>();
		Connection conn = Jsoup.connect(Url);
		try {
			Document document = conn.get();
			Elements title = document.select("div.common_sp_thumb");
			System.out.println(title.size());
			for (int k = 0; k < title.size(); k++) {
				String url = title.select("a").get(k).attr("abs:href");
				urlList.add(url);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return urlList;
	}
}
