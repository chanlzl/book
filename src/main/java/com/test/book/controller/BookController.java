package com.test.book.controller;

import com.test.book.bean.Book;
import com.test.book.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Administrator
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
@Slf4j
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping("")
    public ResponseEntity findAll(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex,
                                  @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        log.info("pageIndex:{}, pageSize:{}", pageIndex, pageSize);
        PageRequest pageable = PageRequest.of(pageIndex-1, pageSize);
        Optional<Page<Book>> optional = bookRepository.findAll(pageable);
        
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.ok(Optional.empty());
    }
}
