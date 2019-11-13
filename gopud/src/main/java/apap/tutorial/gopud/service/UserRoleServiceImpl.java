package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.UserModel;
import apap.tutorial.gopud.repository.UserRoleDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDb userDb;

    @Override public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);

    }

    @Override public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override public UserModel findUserByName(String name){
        UserModel target = null;
        List<UserModel> userList = userDb.findAll();
        for (UserModel user : userList){
            if (user.getUsername().equalsIgnoreCase(name)){
                target =  user;
            }
        }
        return target;
    }

    @Override public boolean checkChar(String password) {
        String num = ".*[0-9].*";
        String hurufKapital = ".*[A-Z].*";
        String hurufKecil = ".*[a-z].*";
        Integer l = password.length();
        if(l >= 8 && password.matches(num) && (password.matches(hurufKapital) || password.matches(hurufKecil))){
            return true;
        }
        return false;
    }

    @Override
    public void changePasswordByName(String name, String password) {
        String encryptedPass = encrypt(password);
        List<UserModel> userList = userDb.findAll();
        for (UserModel user : userList){
            if (user.getUsername().equalsIgnoreCase(name)){
                user.setPassword(encryptedPass);
                userDb.save(user);
            }
        }
    }
}
