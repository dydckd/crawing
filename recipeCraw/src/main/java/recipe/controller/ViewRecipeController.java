package recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewRecipeController {
	
	private final String command="/view.craw";
	private final String getPage="view";
	
	@RequestMapping(value=command)
	public String doAction() {
		return getPage;
	}
}
