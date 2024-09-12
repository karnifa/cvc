package br.com.cvc.infra.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "GFP_RULE")
@Data
@NoArgsConstructor
public class RuleEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rule_seq_generator")
	@SequenceGenerator(name = "rule_seq_generator", sequenceName = "payment_methods.gfp_rule_sq01", allocationSize = 1)
	@Column(name = "CD_RULE", unique = true)
	private Long id;

	@Column(name = "NM_RULE", nullable = false, length = 40)
	private String name;

	@Column(name = "DS_UPDATED_BY", length = 40)
	private String user;

	@Column(name = "DT_UPDATED", updatable = false)
	private LocalDateTime updatedAt;
}
