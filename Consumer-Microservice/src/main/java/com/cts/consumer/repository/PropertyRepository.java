package com.cts.consumer.repository;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.consumer.model.Property;

@Repository
@Transactional
@DynamicUpdate
public interface PropertyRepository extends JpaRepository<Property, Long> {

	Property findByConsumerId(Long consumerid);

	boolean existsById(Long propertyId);

}
