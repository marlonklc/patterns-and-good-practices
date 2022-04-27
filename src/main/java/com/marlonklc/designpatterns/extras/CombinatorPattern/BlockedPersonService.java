package com.marlonklc.designpatterns.extras.CombinatorPattern;

import java.util.Set;

public class BlockedPersonService {

    private static final Set<String> blockedPersonsList = Set.of(
        "88888-000",
        "77777-000",
        "66666-000",
        "55555-000"
    );

    static public Set<String> getBlockedPersons() {
        return blockedPersonsList;
    }
}
