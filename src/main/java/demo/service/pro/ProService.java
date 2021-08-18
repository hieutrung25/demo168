package demo.service.pro;

import demo.model.Pro;
import demo.repository.IProRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProService implements IProService {
    @Autowired
    private IProRepository proRepository;

    @Override
    public Iterable<Pro> findAll() {
        return proRepository.findAll();
    }

    @Override
    public Optional<Pro> findById(Long id) {
        return proRepository.findById(id);
    }

    @Override
    public Pro save(Pro pro) {
        return proRepository.save(pro);
    }

    @Override
    public void remove(Long id) {
        proRepository.deleteById(id);
    }


    @Override
    public Page<Pro> findAll(Pageable pageable) {
        return proRepository.findAll(pageable);
    }

    @Override
    public Iterable<Pro> findAllByNameContaining(String name) {
        return proRepository.findAllByNameContaining(name);
    }
}