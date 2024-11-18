package one.orbiq.sproutbound

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider
import net.minecraft.advancement.Advancement
import net.minecraft.advancement.AdvancementEntry
import net.minecraft.advancement.AdvancementFrame
import net.minecraft.advancement.criterion.InventoryChangedCriterion
import net.minecraft.data.DataGenerator
import net.minecraft.item.Items
import net.minecraft.registry.RegistryWrapper
import net.minecraft.text.Text
import one.orbiq.sproutbound.datagen.AdvancementsProvider
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class SproutboundDataGenerator : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        val pack = fabricDataGenerator.createPack()

        pack.addProvider { output: FabricDataOutput, lookup: CompletableFuture<RegistryWrapper.WrapperLookup> ->
            AdvancementsProvider(output, lookup)
        }
    }
}