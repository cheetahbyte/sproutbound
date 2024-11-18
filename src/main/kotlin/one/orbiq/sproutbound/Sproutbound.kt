package one.orbiq.sproutbound

import net.fabricmc.api.ModInitializer

class Sproutbound : ModInitializer {
    companion object {
        const val MOD_ID = "sproutbound"
    }

    override fun onInitialize() {
        ModItems.initialize()
    }
}
