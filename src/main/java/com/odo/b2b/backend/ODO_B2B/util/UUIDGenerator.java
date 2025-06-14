package com.odo.b2b.backend.ODO_B2B.util;

import java.util.UUID;

public class UUIDGenerator {
    public UUIDGenerator()
    {

    }

    public String generateUUID()
    {
        return UUID.randomUUID().toString();
    }
}
