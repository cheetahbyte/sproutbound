package one.orbiq.sproutbound

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.ServerStarting
import net.minecraft.server.MinecraftServer
import net.minecraft.util.Identifier


class Sproutbound : ModInitializer {
    companion object {
        const val MOD_ID = "sproutbound"
    }

    override fun onInitialize() {
        ModItems.initialize()
    }
}
