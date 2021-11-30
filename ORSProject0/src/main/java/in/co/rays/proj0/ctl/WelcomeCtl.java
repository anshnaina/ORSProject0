package in.co.rays.proj0.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Contains navigation logics for Welcome.
 * 
 * @author DAO
 * @version 1.0
 * @Copyright (c) SunilOS
 */

@Controller
@RequestMapping("/Welcome")
public class WelcomeCtl extends BaseCtl {
	@RequestMapping(method = RequestMethod.GET)
    public String display(ModelMap model) {
		System.out.println("this is display method in WelcomeCtl");
        return "Welcome";
    }
}

