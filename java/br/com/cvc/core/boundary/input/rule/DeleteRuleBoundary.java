package br.com.cvc.core.boundary.input.rule;

@FunctionalInterface
public interface DeleteRuleBoundary {

    void execute(Long id);
}
