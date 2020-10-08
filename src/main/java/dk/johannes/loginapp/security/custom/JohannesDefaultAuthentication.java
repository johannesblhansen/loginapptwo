package dk.johannes.loginapp.security.custom;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JohannesDefaultAuthentication extends AbstractAuthenticationToken {
    private final Object principal;
    private Object credentials;

    public JohannesDefaultAuthentication(Collection<? extends GrantedAuthority> authorities, Object principal, Object credentials) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        this.setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return getCredentials();
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}
