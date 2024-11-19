package one.orbiq.sproutbound.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider
import net.minecraft.advancement.Advancement
import net.minecraft.advancement.AdvancementCriterion
import net.minecraft.advancement.AdvancementEntry
import net.minecraft.advancement.AdvancementFrame
import net.minecraft.advancement.criterion.Criterion
import net.minecraft.advancement.criterion.InventoryChangedCriterion
import net.minecraft.item.Items
import net.minecraft.predicate.item.ItemPredicate
import net.minecraft.registry.RegistryWrapper
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import one.orbiq.sproutbound.ModItems
import one.orbiq.sproutbound.items.ModKnifes
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

        val root = Advancement.Builder().display(
            Items.WHEAT_SEEDS, // The display icon
            Text.translatable("advancement.sproutbound.root.title"), // The title
            Text.translatable("advancement.sproutbound.root.description"), // The description
            Identifier.of("textures/gui/advancements/backgrounds/adventure.png"), // Background image
            AdvancementFrame.TASK, // Frame type
            true, // Show toast notification
            true, // Announce in chat
            false // Hidden
        ).criterion(
            "has_dough", InventoryChangedCriterion.Conditions.items(ModItems.DOUGH_ITEM)
        ).build(consumer, "sproutbound:root")
        //
        Advancement.Builder().parent(root).display(
            ModItems.DOUGH_ITEM, // The display icon
            Text.translatable("advancement.sproutbound.dough.title"), // The title
            Text.translatable("advancement.sproutbound.dough.description"), // The description
            Identifier.of("textures/gui/advancements/backgrounds/adventure.png"), // Background image
            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
            true, // Show toast top right
            true, // Announce to chat
            false // Hidden in the advancement tab
        )
            .criterion("made_dough", InventoryChangedCriterion.Conditions.items(ModItems.DOUGH_ITEM))
            .build(consumer, "sproutbound:make_dough")
        val knifeCollector = Advancement.Builder().parent(root).display(
            ModKnifes.getKnifes()[0], // Use any knife as the display icon
            Text.translatable("advancement.sproutbound.knife.title"), // Title
            Text.translatable("advancement.sproutbound.knife.description"), // Description
            Identifier.of("textures/gui/advancements/backgrounds/adventure.png"), // Background image
            AdvancementFrame.TASK, // Frame type: TASK, CHALLENGE, or GOAL
            true, // Show toast notification
            true, // Announce to chat
            false // Hidden in the advancement tab
        ).criterion(
            "has_knife", // Unique criterion name
            InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().tag(ItemTagProvider.KNIFE_TAG).build()) // Trigger for items in the tag
        ).build(consumer, "sproutbound:knife_collector")
        //
        Advancement.Builder().parent(knifeCollector).display(
            ModKnifes.getKnifes()[4], // The display icon
            Text.translatable("advancement.sproutbound.netherite_knife.title"), // The title
            Text.translatable("advancement.sproutbound.netherite_knife.description"), // The description
            Identifier.of("textures/gui/advancements/backgrounds/adventure.png"), // Background image
            AdvancementFrame.CHALLENGE, // Mark this as a challenge
            true, // Show toast notification
            true, // Announce in chat
            true // Not hidden in the tab
        )
            .criterion(
                "crafted_netherite_knife",
                InventoryChangedCriterion.Conditions.items(ModKnifes.getKnifes()[4]) // Trigger when player obtains the knife
            ).build(consumer, "sproutbound:crafted_netherite_knife")

    }


}