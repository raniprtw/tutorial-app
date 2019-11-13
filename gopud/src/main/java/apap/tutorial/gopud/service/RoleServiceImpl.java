package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.RoleModel;
import apap.tutorial.gopud.repository.RoleDb;
import org.hibernate.annotations.OnDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired private RoleDb roleDb;

    @Override
    public List<RoleModel> findAll() {
        return roleDb.findAll();
    }

    @Override
    public RoleModel addRole(RoleModel role){
        return roleDb.save(role);
    }
}
