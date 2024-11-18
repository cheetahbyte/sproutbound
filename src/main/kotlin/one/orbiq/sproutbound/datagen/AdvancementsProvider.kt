package one.orbiq.sproutbound.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider
import net.minecraft.advancement.Advancement
import net.minecraft.advancement.AdvancementEntry
import net.minecraft.advancement.AdvancementFrame
import net.minecraft.advancement.criterion.InventoryChangedCriterion
import net.minecraft.registry.RegistryWrapper
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import one.orbiq.sproutbound.ModItems
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class AdvancementsProvider(
    output: FabricDataOutput?,
    registryLookup: CompletableFuture<RegistryWrapper.WrapperLookup>?
) : FabricAdvancementProvider(output, registryLookup) {
    override fun generateAdvancement(
        registryLookup: RegistryWrapper.WrapperLookup?,
        consumer: Consumer<AdvancementEntry>?
    ) {
        // dough
        Advancement.Builder().display(
            ModItems.DOUGH_ITEM, // The display icon
            Text.translatable("advancement.sproutbound.dough.title"), // The title
            Text.translatable("advancement.sproutbound.dough.description"), // The description
            Identifier.of("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
            true, // Show toast top right
            true, // Announce to chat
            false // Hidden in the advancement tab
        ).criterion("made_dough", InventoryChangedCriterion.Conditions.items(ModItems.DOUGH_ITEM))
            .build(consumer, "sproutbound:make_dough");
    }
}