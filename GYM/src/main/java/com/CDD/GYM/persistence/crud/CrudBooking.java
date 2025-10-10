package com.CDD.GYM.persistence.crud;

import com.CDD.GYM.persistence.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudBooking extends CrudRepository<BookEntity,Integer> {
}
