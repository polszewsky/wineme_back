package polszewsky.wineme.app.common.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
public class AuthController {

    @GetMapping("/list")
    @PreAuthorize("@securityMethods.hasRight('ADD_WINE')")
    public ResponseEntity<String> getHelloWorld(){

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/list2")
    @PreAuthorize("@securityMethods.hasRight('ADD_COMMENT')")
    public ResponseEntity<String> getHelloWorld2(){
        return new ResponseEntity<>("OK2", HttpStatus.OK);
    }
}
