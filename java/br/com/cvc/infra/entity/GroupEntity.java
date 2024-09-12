package br.com.cvc.infra.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "GFP_GROUP")
@Data
@NoArgsConstructor
public class GroupEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_seq_generator")
	@SequenceGenerator(name = "group_seq_generator", sequenceName = "payment_methods.gfp_group_sq01", allocationSize = 1)
	@Column(name = "CD_GROUP", unique = true)
	private Long id;

	@Column(name = "NM_GROUP", nullable = false, length = 40)
	private String name;

	@Column(name = "DS_UPDATED_BY", length = 40)
	private String user;

	@OneToOne
	@JoinColumn(name = "CD_PARAMETER_TYPE", referencedColumnName = "CD_PARAMETER_TYPE")
	private ParameterTypeEntity parameterType;

	@Column(name = "DT_UPDATED", updatable = false)
	private LocalDateTime updatedAt;
}
