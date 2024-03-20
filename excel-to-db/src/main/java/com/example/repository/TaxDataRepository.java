package com.example.repository;

import com.example.entity.TaxData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxDataRepository extends CrudRepository<TaxData, Long> {
}
