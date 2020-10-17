package com.piscesdan.aquaticastral;

import hellfirepvp.astralsorcery.common.registry.internal.InternalRegistryPrimer;

public class CommonProxy
{
    private InternalRegistryPrimer registryPrimer;

    public void initialize()
    {
        this.registryPrimer = new InternalRegistryPrimer();
    }

    public InternalRegistryPrimer getRegistryPrimer()
    {
        return registryPrimer;
    }
}
