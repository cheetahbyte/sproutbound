package one.orbiq.sproutbound.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.item.Item
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import one.orbiq.sproutbound.Sproutbound
import one.orbiq.sproutbound.items.ModKnifes
import java.util.concurrent.CompletableFuture

class ItemTagProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>) :
    FabricTagProvider.ItemTagProvider(output, registriesFuture) {
        companion object {
            val KNIFE_TAG = TagKey.of(RegistryKeys.ITEM, Identifier.of(Sproutbound.MOD_ID, "knife"))
        }

    override fun configure(arg: RegistryWrapper.WrapperLookup) {
        val knifeTag = getOrCreateTagBuilder(KNIFE_TAG)

        // Add all knives to the tag
        ModKnifes.getKnifes().forEach { knife ->
            knifeTag.add(knife)
        }
    }
}