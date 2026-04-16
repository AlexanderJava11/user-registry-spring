package alex.userregistryspring.controller;

import alex.userregistryspring.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    private final RegisterService service;

    public RegisterController(RegisterService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        boolean result = service.registerUser(username, password);
        if (result) {
            return "redirect:/success";
        }
        model.addAttribute("error", "could not register user");
        return "register";
    }


}
