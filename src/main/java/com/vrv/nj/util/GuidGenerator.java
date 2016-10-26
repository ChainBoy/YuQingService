package com.vrv.nj.util;

import java.util.UUID;

public abstract class GuidGenerator
{
    protected GuidGenerator()
    {
    }
    
    public static String generate()
    {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
