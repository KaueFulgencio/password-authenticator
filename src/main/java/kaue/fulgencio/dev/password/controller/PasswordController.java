package kaue.fulgencio.dev.password.controller;

import kaue.fulgencio.dev.password.service.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/password")
public class PasswordController {
    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/verification")
    public ResponseEntity<?> passwordVerification(@RequestBody PasswordRequest request) {
        List<String> errors = passwordService.validatePassword(request.getPassword());
        if (errors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body(errors);
    }
}
