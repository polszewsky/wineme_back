package polszewsky.wineme.app.common.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import polszewsky.wineme.app.administration.users.User;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MyUserDetails extends User implements UserDetails {

        private static final List<GrantedAuthority> ROLE_USER = Collections
                .unmodifiableList(AuthorityUtils.createAuthorityList("USER_BASIC"));

        public MyUserDetails(User user, Collection<? extends GrantedAuthority> authorities) {
            super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return ROLE_USER;
        }

        @Override
        public String getUsername() {
            return getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }


}
