package kaue.fulgencio.dev.password.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordService {

    public List<String> validatePassword(String password) {
        List<String> errors = new ArrayList<>();

        addError(errors, passwordLength(password));

        if (password != null) {
            addError(errors, hasUppercase(password));
            addError(errors, hasLowercase(password));
            addError(errors, hasDigit(password));
            addError(errors, hasSpecialCharacter(password));
        }

        return errors;
    }

    private void addError(List<String> errors, String errorMessage) {
        if (errorMessage != null) {
            errors.add(errorMessage);
        }
    }

    private String passwordLength(String password) {
        if (password == null || password.isBlank()) {
            return "Password cannot be null or empty";
        }

        if (password.length() < 8) {
            return "Password must be at least 8 characters long";
        }

        return null;
    }

    private String hasUppercase(String password) {
        if (!password.matches(".*[A-Z].*")) {
            return "Password must contain at least one uppercase letter";
        }

        return null;
    }

    private String hasLowercase(String password) {
        if (!password.matches(".*[a-z].*")) {
            return "Password must contain at least one lowercase letter";
        }

        return null;
    }

    private String hasDigit(String password) {
        if (!password.matches(".*\\d.*")) {
            return "Password must contain at least one digit";
        }

        return null;
    }

    private String hasSpecialCharacter(String password) {
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            return "Password must contain at least one special character";
        }

        return null;
    }
}