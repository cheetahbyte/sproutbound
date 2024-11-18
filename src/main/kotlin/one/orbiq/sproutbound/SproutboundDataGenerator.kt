package one.orbiq.sproutbound

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider
import net.minecraft.advancement.Advancement
import net.minecraft.advancement.AdvancementEntry
import net.minecraft.advancement.AdvancementFrame
import net.minecraft.advancement.criterion.InventoryChangedCriterion
import net.minecraft.item.Items
import net.minecraft.registry.RegistryWrapper
import net.minecraft.text.Text
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class AdvancementsProvider(dataOutput: FabricDataOutput,
                           registryLookup: CompletableFuture<RegistryWrapper.WrapperLookup>?
) : FabricAdvancementProvider(dataOutput, registryLookup) {
    fun generateAdvancements(consumer: Consumer<Advancement>) {
        // Example: Define a custom advancement
        val customAdvancement = Advancement.Builder.create()
            .display(
                Items.DIAMOND.defaultStack, // Icon
                Text.translatable("advancement.yourmod.custom.title"), // Title
                Text.translatable("advancement.yourmod.custom.description"), // Description
                null, // Background texture (use a custom resource location if desired)
                AdvancementFrame.TASK, // Frame type
                true, // Show toast
                true, // Announce to chat
                false // Is hidden
            )
            .criterion(
                "has_diamond",
                InventoryChangedCriterion.Conditions.items(Items.DIAMOND)
            )
            .build(consumer, "yourmod:custom_advancement")
    }

    override fun generateAdvancement(
        registryLookup: RegistryWrapper.WrapperLookup?,
        consumer: Consumer<AdvancementEntry>?
    ) {
        TODO("Not yet implemented")
    }
}

class SproutboundDataGenerator: DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator?) {
        val pack = fabricDataGenerator?.createPack()
        pack.addProvider(AdvancementsProvider::new)
    }

    class AdvancementsProvider protected constructor(dataGenerator: FabricDataOutput?) :
        FabricAdvancementProvider(dataGenerator) {
        override fun generateAdvancement(consumer: Consumer<AdvancementEntry?>?) {
            //
            // We will create our custom advancements here...
            //
        }
    }
}