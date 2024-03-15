package org.example.authorization_and_authentication.service.appuser;

import org.example.authorization_and_authentication.model.AppUser;
import org.example.authorization_and_authentication.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class AppUserService implements IAppUserService, UserDetailsService {
    @Autowired
    private AppUserRepo appUserRepo;
    @Override
    public void save(AppUser appUser) {
        appUserRepo.save(appUser);
    }

    @Override
    public void remove(Long id) {
        appUserRepo.deleteById(id);
    }

    @Override
    public Iterable<AppUser> findAll() {
        return appUserRepo.findAll();
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return appUserRepo.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepo.findByName(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(appUser.getAppRole());

        UserDetails userDetails = new User(
                appUser.getName(),
                appUser.getPassword(),
                grantedAuthorities
        );
        return userDetails;
    }
}
