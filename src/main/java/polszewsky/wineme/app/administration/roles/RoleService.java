package polszewsky.wineme.app.administration.roles;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
