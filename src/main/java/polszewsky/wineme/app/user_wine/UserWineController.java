package polszewsky.wineme.app.user_wine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import polszewsky.wineme.app.user_wine.requests.UserWineCreateRequest;
import polszewsky.wineme.app.user_wine.requests.UserWineUpdateRequest;

@RestController
@RequestMapping("/user/wines")
public class UserWineController {

    @Autowired
    private UserWineService userWineService;

    @GetMapping
    @PreAuthorize("@SecurityMethods.hasRight('READ_WINES')")
    public ResponseEntity<Page<UserWine>> getUserWineList(){

        Page<UserWine> wines = userWineService.findAll();
        return new ResponseEntity<>(wines, HttpStatus.OK);
    }

    @GetMapping("/{wineId}")
    @PreAuthorize("@SecurityMethods.hasRight('READ_WINES')")
    public ResponseEntity<UserWine> getUserWineDetails(@PathVariable @Validated Integer wineId){

        UserWine wine = userWineService.findById(wineId);
        return new ResponseEntity<>(wine, HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("@SecurityMethods.hasRight('WRITE_WINES')")
    public ResponseEntity<UserWine> createUserWine(@RequestBody @Validated UserWineCreateRequest createRequest){

        UserWine wine = userWineService.addWine(createRequest);
        return new ResponseEntity<>(wine, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("@SecurityMethods.hasRight('EDIT_WINES')")
    public ResponseEntity<UserWine> updateUserWine(@RequestBody @Validated UserWineUpdateRequest updateRequest){

        UserWine wine = userWineService.updateWine(updateRequest);
        return new ResponseEntity<>(wine, HttpStatus.OK);
    }

    @DeleteMapping("/{wineId}")
    @PreAuthorize("@SecurityMethods.hasRight('DELETE_WINES')")
    public ResponseEntity<Boolean> deleteUserWine(@PathVariable @Validated Integer wineId){

        boolean deleted = userWineService.deleteWine(wineId);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

}
