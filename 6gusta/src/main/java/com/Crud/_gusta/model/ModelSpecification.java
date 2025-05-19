package com.Crud._gusta.model;

import org.springframework.data.jpa.domain.Specification;

public class ModelSpecification {

    public static Specification<PetModel> filter(String porte, String cidade, String estado, String idade) {
        return (root, query, cb) -> {
            var predicates = cb.conjunction();

            if (porte != null && !porte.isEmpty()) {
                predicates = cb.and(predicates, cb.equal(root.get("porte"), porte));
            }
            if (cidade != null && !cidade.isEmpty()) {
                predicates = cb.and(predicates, cb.equal(root.get("cidade"), cidade));
            }
            if (estado != null && !estado.isEmpty()) {
                predicates = cb.and(predicates, cb.equal(root.get("estado"), estado));
            }
            if (idade != null && !idade.isEmpty()) {
                predicates = cb.and(predicates, cb.equal(root.get("idade"), idade));
            }

            return predicates;
        };
    }
}
