package net.darkhax.moreswords.proxy;

import net.darkhax.moreswords.handler.EnchantmentBookHandler;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerSidedEvents() {

        new EnchantmentBookHandler(true);
    }
}