package one.orbiq.sproutbound

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import one.orbiq.sproutbound.items.DoughItem
import one.orbiq.sproutbound.items.FlourItem

object ModItems {
    private fun register(item: Item, id: String): Item{
        val itemID = Identifier.of(Sproutbound.MOD_ID, id)
        val registeredItem = Registry.register(Registries.ITEM, itemID, item)
        return registeredItem
    }

    fun initialize() {
        group()
    }

    private fun group() {
        Registry.register(Registries.ITEM_GROUP, Identifier.of(Sproutbound.MOD_ID, "sproutbound"), SPROUTBOUND_GROUP)
    }

    private val DOUGH_ITEM = register(DoughItem(Item.Settings().food(DoughItem.CUSTOM_FOOD)), "dough")
    private val FLOUR_ITEM = register(FlourItem(Item.Settings()), "flour")

    private val SPROUTBOUND_GROUP: ItemGroup = FabricItemGroup.builder()
        .displayName(Text.translatable("sproutbound.group"))
        .icon { ItemStack(Items.STONE_HOE) } // Icon for the group
        .entries { _, entries ->
            // Automatically adds all items registered in this mod
            entries.add(DOUGH_ITEM)
            entries.add(FLOUR_ITEM)
        }
        .build()
}