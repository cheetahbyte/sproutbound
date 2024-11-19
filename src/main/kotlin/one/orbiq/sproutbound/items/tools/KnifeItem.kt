package one.orbiq.sproutbound.items.tools

import net.minecraft.item.*
import net.minecraft.recipe.Ingredient

class KnifeItem(material: ToolMaterial, settings: Settings) : SwordItem(
    material, settings.attributeModifiers(
        SwordItem.createAttributeModifiers(
            material,
            (if (material != ToolMaterials.NETHERITE && material != ToolMaterials.DIAMOND && material != ToolMaterials.IRON)
                material.attackDamage.toInt() + 1
            else
                material.attackDamage.toInt() -1), -2.0f
        )
    )
) {

    private val material: ToolMaterial = material

    fun getIngredient(): Item {
        return when (material) {
            ToolMaterials.STONE -> Items.COBBLESTONE
            ToolMaterials.IRON -> Items.IRON_INGOT
            ToolMaterials.GOLD -> Items.GOLD_INGOT
            ToolMaterials.DIAMOND -> Items.DIAMOND
            ToolMaterials.NETHERITE -> Items.NETHERITE_INGOT
            else -> Items.STICK // Default fallback
        }
    }
}