package alex.userregistryspring.service;

import alex.userregistryspring.model.AppUser;
import alex.userregistryspring.repository.AppUserRepository;

public class RegisterService {
    private final AppUserRepository repository;

    public RegisterService(AppUserRepository repository) {
        this.repository = repository;
    }

    public boolean registerUser(String username, String password) {
        if (username == null || username.isBlank()) {
            return false;
        }
        if (password == null || password.isBlank()) {
            return false;
        }
        AppUser user = new AppUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole("USER");
    }
}
