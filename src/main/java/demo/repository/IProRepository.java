package demo.repository;

import demo.model.Pro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProRepository extends PagingAndSortingRepository<Pro, Long> {
    Iterable<Pro> findProductByName(String name);

    Page<Pro> findAll(Pageable pageable);
    @Query("select c from Pro c where c.name like ?1")

    Iterable<Pro> findAllByNameContaining(String name);
}