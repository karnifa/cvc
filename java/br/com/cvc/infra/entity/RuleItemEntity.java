package br.com.cvc.infra.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "GFP_RULE_ITEM")
@Data
@NoArgsConstructor
public class RuleItemEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rule_item_seq_generator")
	@SequenceGenerator(name = "rule_item_seq_generator", sequenceName = "payment_methods.gfp_rule_item_sq01", allocationSize = 1)
	@Column(name = "CD_RULE_ITEM", unique = true)
	private Long id;

	@Column(name = "CD_RULE")
	private Long ruleId;

	@OneToOne
	@JoinColumn(name = "CD_PARAMETER_TYPE", referencedColumnName = "CD_PARAMETER_TYPE")
	private ParameterTypeEntity parameterType;

	@Column(name = "DS_VALUE_1")
	private String value1;

	@Column(name = "DS_VALUE_2")
	private String value2;

	@Column(name = "DS_VALUE_3")
	private String value3;

	@Column(name = "DS_VALUE_4")
	private String value4;

	@Column(name = "DS_VALUE_5")
	private String value5;

	@Column(name = "DS_UPDATED_BY")
	private String user;

	@Column(name = "DT_UPDATED")
	private LocalDateTime updatedAt;
}
