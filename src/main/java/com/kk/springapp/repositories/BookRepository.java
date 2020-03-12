package com.kk.springapp.repositories;

import com.kk.springapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository  extends CrudRepository<Book, Long> {
}
