package com.test.book.repository;

import com.test.book.bean.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * @author Administrator
 */
public interface BookRepository extends Repository<Book, Integer> {

    /**
     *  分页查询
     * @param pageable 分页条件
     * @return
     */
    Optional<Page<Book>> findAll(Pageable pageable);
}
