package kaue.fulgencio.dev.password.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password")
public class PasswordController {

    @PostMapping("/verification")
    public ResponseEntity<?> passwordVerification(@RequestBody String password){
        return ResponseEntity.noContent().build();
    }
}
