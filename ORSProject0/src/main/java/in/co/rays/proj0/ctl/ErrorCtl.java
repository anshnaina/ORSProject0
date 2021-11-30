package in.co.rays.proj0.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/ErrorCtl"})
public class ErrorCtl extends BaseCtl {
	@GetMapping
	public String display(Model model) {
		return "ErrorView";
	}
}