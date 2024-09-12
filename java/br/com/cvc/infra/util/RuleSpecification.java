package br.com.cvc.infra.util;

import br.com.cvc.infra.entity.RuleEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;

public class RuleSpecification {

    public static Specification<RuleEntity> generateListSpecification(final String name, final String user) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (!ObjectUtils.isEmpty(name)) {
                Predicate namePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
                predicate = criteriaBuilder.and(predicate, namePredicate);
            }

            if (!ObjectUtils.isEmpty(user)) {
                Predicate userPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("user")), "%" + user.toLowerCase() + "%");
                predicate = criteriaBuilder.and(predicate, userPredicate);
            }

            return predicate;
        };
    }
}
