package com.kk.springapp.repositories;

import com.kk.springapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends  CrudRepository<Author, Long>{
}
