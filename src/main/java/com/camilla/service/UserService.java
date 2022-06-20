package com.camilla.service;

import com.camilla.domain.User;
import com.camilla.repository.UserRepository;
import com.camilla.service.exception.UserNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNaoEncontradoException(id));
    }

    public List<User> todos() {
        return repository.findAll();
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id, User user) {
        user.setId(id);
        return repository.save(user);
    }

}
