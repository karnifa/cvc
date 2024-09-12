package br.com.cvc.infra.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "GFP_PARAMETER_TYPE")
@Data
@NoArgsConstructor
public class ParameterTypeEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CD_PARAMETER_TYPE")
	private Long id;

	@Column(name = "NM_PARAMETER_TYPE")
	private String name;

	@Column(name = "DS_VALUE_TYPE_1")
	private String valueType1;

	@Column(name = "DS_VALUE_TYPE_2")
	private String valueType2;

	@Column(name = "DS_VALUE_TYPE_3")
	private String valueType3;

	@Column(name = "DS_VALUE_TYPE_4")
	private String valueType4;

	@Column(name = "DS_VALUE_TYPE_5")
	private String valueType5;
}
