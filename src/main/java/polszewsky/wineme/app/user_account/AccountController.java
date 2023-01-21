package polszewsky.wineme.app.user_account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import polszewsky.wineme.app.user_account.requests.UserDetailsRequest;
import polszewsky.wineme.app.user_account.requests.UserSubscriptionRequest;

@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PutMapping
    public ResponseEntity<Boolean> registerUser(@RequestBody UserDetailsRequest userRequest) {
        boolean created = accountService.registerNewUserAccount(userRequest);
        return new ResponseEntity<>(created, HttpStatus.OK);
    }


    @PostMapping
    @PreAuthorize("@SecurityMethods.hasRight('IS_USER')")
    public ResponseEntity<Boolean> editUserDetails(@RequestBody @Validated UserDetailsRequest detailsRequest) {
        boolean updated = accountService.updateUserDetails(detailsRequest);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @PostMapping("/password")
    @PreAuthorize("@SecurityMethods.hasRight('IS_USER')")
    public ResponseEntity<Boolean> changePassword(@RequestBody UserDetailsRequest detailsRequest) {
        boolean updated = accountService.changePassword(detailsRequest);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @PostMapping("/subscription")
    @PreAuthorize("@SecurityMethods.hasRight('IS_USER')")
    public ResponseEntity<Boolean> changeSubscriptionLevel(@RequestBody @Validated UserSubscriptionRequest subscriptionRequest) {
        boolean updated = accountService.updateSubscription(subscriptionRequest);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

}
