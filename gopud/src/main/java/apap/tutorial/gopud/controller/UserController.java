package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.UserModel;
import apap.tutorial.gopud.service.RoleService;
import apap.tutorial.gopud.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired private UserRoleService userRoleService;
    @Autowired private RoleService roleService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user, Model model){
        userRoleService.addUser(user);
        model.addAttribute("listRole", roleService.findAll());
        return "home";
    }

    @RequestMapping(value = "/change-password/{username}", method = RequestMethod.GET)
    public String changeUserPassword(@PathVariable String username, Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        if (!username.equalsIgnoreCase(currentPrincipalName)){
            return "home";
        }

        UserModel user = userRoleService.findUserByName(username);
        model.addAttribute("user", user);
        return "form-change-password-user";

    }

    @RequestMapping(value = "/change-password/{username}", method = RequestMethod.POST)
    public String changePasswordSubmit(@PathVariable String username, Model model, @ModelAttribute UserModel user,@RequestParam("password") String password,
                                       @RequestParam("oldpassword") String oldPassword, @RequestParam("passwordKonfirmasi") String passwordKonfirmasi) {

        UserModel isUser = userRoleService.findUserByName(username);



        if (new BCryptPasswordEncoder().matches(oldPassword, isUser.getPassword())){
            if (password.equalsIgnoreCase(passwordKonfirmasi)){
                if(userRoleService.checkChar(password)){
                    userRoleService.changePasswordByName(username, password);
                    return "home";
                }
                else{
                    UserModel thisUser = userRoleService.findUserByName(username);
                    model.addAttribute("user", thisUser);
                    return "/error/password-invalid";
                }

            }
            UserModel thisUser = userRoleService.findUserByName(username);
            model.addAttribute("user", thisUser);
            return "/error/password-mismatch";

        }
        else{
            UserModel thisUser = userRoleService.findUserByName(username);
            model.addAttribute("user", thisUser);
            return "error/password-salah";
        }
    }
}
