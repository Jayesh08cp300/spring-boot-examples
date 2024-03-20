package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TAX_RATE_CODE_MAPPING")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaxData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "JURISDICTION", length = 10)
	private String jurisdiction;

	@Column(name = "ITEM_GROUP_CODE", length = 10)
	private String itemGroupCode;

	@Column(name = "TAX_RATE_CODE", length = 10)
	private String taxRateCode;

}
