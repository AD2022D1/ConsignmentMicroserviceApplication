/**
 * 
 */
package com.ashokadtech.consignment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashokadtech.consignment.entity.Consignment;

/**
 * @author AshokaDevara
 *
 */
@Repository
public interface ConsignmentRepository extends CrudRepository<Consignment, Integer> {

}
