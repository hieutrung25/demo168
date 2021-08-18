package demo.repository;

import demo.model.Cate;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICateRepository extends PagingAndSortingRepository<Cate,Long> {
}
