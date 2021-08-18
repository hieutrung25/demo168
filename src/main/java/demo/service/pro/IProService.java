package demo.service.pro;

import demo.model.Pro;
import demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProService extends IGeneralService<Pro> {
    Page<Pro> findAll(Pageable pageable);

    Iterable<Pro> findAllByNameContaining(String name);
}