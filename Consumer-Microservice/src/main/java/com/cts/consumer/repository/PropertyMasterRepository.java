package com.cts.consumer.repository;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.consumer.model.PropertyMaster;

@Repository
@Transactional
@DynamicUpdate
public interface PropertyMasterRepository extends JpaRepository<PropertyMaster, Long> {

	PropertyMaster findByPropertytypeAndInsurancetypeAndBuildingtype(String propertytype, String insurancetype,
			String buildingtype);

}
