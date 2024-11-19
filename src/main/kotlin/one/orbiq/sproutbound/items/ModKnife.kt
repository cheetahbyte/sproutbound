package one.orbiq.sproutbound.items

import net.minecraft.item.Item
import net.minecraft.item.ToolMaterial
import net.minecraft.item.ToolMaterials
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import one.orbiq.sproutbound.Sproutbound
import one.orbiq.sproutbound.items.tools.KnifeItem

object ModKnifes {
    private val knifes = mutableListOf<KnifeItem>()
    init {
        registerKnife("stone_knife", ToolMaterials.STONE)
        registerKnife("iron_knife", ToolMaterials.IRON)
        registerKnife("gold_knife", ToolMaterials.GOLD)
        registerKnife("diamond_knife", ToolMaterials.DIAMOND)
        registerKnife("netherite_knife", ToolMaterials.NETHERITE)
    }


    private fun registerKnife(name: String, material: ToolMaterial): Item {
        val item = Registry.register(
            Registries.ITEM,
            Identifier.of(Sproutbound.MOD_ID, name),
            KnifeItem(material, Item.Settings())
        )
        knifes.add(item)
        return item
    }

    fun getKnifes(): List<KnifeItem> {
        return knifes.toList()
    }

    fun initialize() {
    }
}