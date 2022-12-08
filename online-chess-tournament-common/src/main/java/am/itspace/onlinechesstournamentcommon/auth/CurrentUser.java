package am.itspace.onlinechesstournamentcommon.auth;

import am.itspace.onlinechesstournamentcommon.entity.UserType;
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    public CurrentUser(String email, String password, UserType type) {
        super(email, password, AuthorityUtils.createAuthorityList(type.name()));
    }
}
