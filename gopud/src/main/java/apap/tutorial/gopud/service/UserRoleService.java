package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.UserModel;

public interface UserRoleService {
    UserModel addUser(UserModel user);
    public String encrypt(String password);
    UserModel findUserByName(String name);
    public boolean checkChar(String password);
    void changePasswordByName(String name, String password);
}
