package com.sopra.dao;

import com.sopra.entities.AppUser;
import org.springframework.data.jpa.domain.Specification;

public class SearchUsersSpecification {

    private static final String USER_FULL_NAME = "fullName";

    public static Specification<AppUser> select() {
        return (user, cq, cb) -> {

            // Set the DISTINCT flag
            cq.distinct(true);

            // Apply sorting
            cq.orderBy(cb.asc(user.get(USER_FULL_NAME).get("Ngor SECK")));

            return null;
        };
    }


}
