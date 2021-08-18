package demo.service.cate;


import demo.model.Cate;
import demo.repository.ICateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CateService implements ICateService {
    @Autowired
    private ICateRepository cateRepository;

    @Override
    public Iterable<Cate> findAll() {
        return cateRepository.findAll();
    }

    @Override
    public Optional<Cate> findById(Long id) {
        return cateRepository.findById(id);
    }

    @Override
    public Cate save(Cate cate) {
        return cateRepository.save(cate);
    }

    @Override
    public void remove(Long id) {
        cateRepository.deleteById(id);
    }
}