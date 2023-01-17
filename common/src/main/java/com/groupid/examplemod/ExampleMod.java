package com.groupid.examplemod;

import com.groupid.examplemod.platform.ModInstance;

public class ExampleMod {
    public static final String MOD_ID = "examplemod";
    public static final ModInstance INSTANCE = ModInstance.create(MOD_ID).build();

    public static void init() {
        INSTANCE.bootstrap();
    }
}