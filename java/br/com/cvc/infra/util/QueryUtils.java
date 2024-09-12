package br.com.cvc.infra.util;

import br.com.cvc.core.dto.pagination.PageAndSortRequestParametersDTO;
import br.com.cvc.infra.entity.GroupEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.Locale;

public class QueryUtils<E> {

    public <T> Specification<E> equals(final String field, final T expression) {
        if(expression == null) return null;
        return (root, query, builder) -> builder.equal(root.get(field), expression);
    }

    public Specification<E> like(final String field, final String expression) {
        if(expression == null) return null;
        return (root, query, builder) -> builder.like(builder.lower(root.get(field)), "%" + expression.toLowerCase() + "%");
    }

    public Specification<GroupEntity> likeParameterName(String name){
        if(name == null) return null;
        return (root, query, builder) ->
                builder.like(builder.lower(root.join("groupItens").join("parameterItem").join("parameter").get("name")),
                        "%" + name.toLowerCase() + "%");
    }

    public Specification<GroupEntity> equalsParamId(Long parameterId){
        if(parameterId == null) return null;
        return (root, query, builder) ->
                builder.equal(root.join("parameterType").get("id"),
                        parameterId);
    }

    public Specification<GroupEntity> equalsParamIdAndName(Long parameterId, String name){
        if(parameterId == null) return null;
        return (root, query, builder) ->
                builder.and(builder.equal(root.join("parameterType").get("id"), parameterId),
                        builder.equal(root.get("name"), name));
    }


    public <T> Specification<E> not(final String field, final T expression) {
        if(expression == null) return null;
        return (root, query, builder) -> builder.not(builder.equal(root.get(field), expression));
    }

    public static Pageable getPagination(PageAndSortRequestParametersDTO parameters) {
        return PageRequest.of(
                parameters.getOffset() == null ? 0 : parameters.getOffset(),
                parameters.getLimit() == null || parameters.getLimit() < 1 ? Integer.MAX_VALUE : parameters.getLimit(),
                obtainSort(parameters.getSort(), parameters.getSortBy()));
    }

    private static Sort obtainSort(final String sort, final String sortBy) {
        final var sortableBy = (sortBy  ==  null) ? "name" : sortBy;

        if(sort == null || sort.toUpperCase(Locale.ROOT).equals("ASC".toUpperCase(Locale.ROOT)))
            return Sort.by(sortableBy).ascending();
        return Sort.by(sortableBy).descending();
    }

}
