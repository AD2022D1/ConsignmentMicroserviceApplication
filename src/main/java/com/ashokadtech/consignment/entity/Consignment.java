/**
 * 
 */
package com.ashokadtech.consignment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author AshokaDevara
 *
 */
@Entity
public class Consignment {
    @Id
    @GeneratedValue
	private Integer consignmentId;
	private String consignmentCatogery;
	private String deleveryPartner;
	private String consignmentStatus;

	public Integer getConsignmentId() {
		return consignmentId;
	}

	public void setConsignmentId(Integer consignmentId) {
		this.consignmentId = consignmentId;
	}

	public String getConsignmentCatogery() {
		return consignmentCatogery;
	}

	public void setConsignmentCatogery(String consignmentCatogery) {
		this.consignmentCatogery = consignmentCatogery;
	}

	public String getDeleveryPartner() {
		return deleveryPartner;
	}

	public void setDeleveryPartner(String deleveryPartner) {
		this.deleveryPartner = deleveryPartner;
	}

	public String getConsignmentStatus() {
		return consignmentStatus;
	}

	public void setConsignmentStatus(String consignmentStatus) {
		this.consignmentStatus = consignmentStatus;
	}

}
