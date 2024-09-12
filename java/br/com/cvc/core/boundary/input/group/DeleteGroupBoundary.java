package br.com.cvc.core.boundary.input.group;

@FunctionalInterface
public interface DeleteGroupBoundary {

    void execute(Long id);
}
