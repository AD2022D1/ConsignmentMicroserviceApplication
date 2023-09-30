/**
 * 
 */
package com.ashokadtech.consignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokadtech.consignment.entity.Consignment;
import com.ashokadtech.consignment.repository.ConsignmentRepository;

/**
 * @author AshokaDevara
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ConsignmentController {

	@Autowired
	ConsignmentRepository consignmentRepository;

	@RequestMapping(name = "/")
	public String ConsignmentHealthCheck() {
		System.out.println(" ConsignmentController -> ConsignmentHealthCheck() ");
		return "Consignment Application is up........ ";
	}

	@GetMapping("/consignments")
	public List<Consignment> getAllConsignments() {
		System.out.println("ConsignmentController -> getAllConsignments()");
		return (List<Consignment>) consignmentRepository.findAll();

	}

	@PostMapping("/saveConsignment")
	public Consignment saveConsignment(@RequestBody Consignment entity) {
		System.out.println(" ConsignmentController -> saveConsignment() ");
		return consignmentRepository.save(entity);

	}

	@PutMapping("/updateConsignment/{id}")
	public Consignment updateConsignment(@PathVariable Integer id, @RequestBody Consignment consignment) {
		System.out.println(" ConsignmentController -> updateConsignments() ");
		Consignment existing = consignmentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Requested Consignments not found" + id));
		existing.setConsignmentStatus(consignment.getConsignmentStatus() != null ? consignment.getConsignmentStatus()
				: existing.getConsignmentStatus());
		existing.setConsignmentCatogery(consignment.getConsignmentCatogery() != null
				? consignment.getConsignmentCatogery() : existing.getConsignmentCatogery());
		existing.setDeleveryPartner(consignment.getDeleveryPartner() != null ? consignment.getDeleveryPartner()
				: existing.getDeleveryPartner());
		consignmentRepository.save(existing);
		return existing;

	}

	/*
	 * @GetMapping(name = "/getAllConsignmentById/{id}") public Consignment
	 * getAllConsignmentById(@PathVariable Integer id) { System.out.println(
	 * " ConsignmentController -> getAllConsignmentById() "); return
	 * consignmentRepository.findById(id) .orElseThrow(() -> new
	 * RuntimeException("Requested Consignments not found" + id));
	 * 
	 * }
	 */

	@DeleteMapping("/deleteConsignment/{id}")
	public String deleteConsignment(@PathVariable Integer id) {

		consignmentRepository.deleteById(id);

		return "Selected Consignment deleted" + id;

	}
}
