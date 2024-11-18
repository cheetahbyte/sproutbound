package one.orbiq.sproutbound.items

import net.minecraft.component.type.FoodComponent
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World

class DoughItem(settings: Settings) : Item(settings) {
    companion object {
        val CUSTOM_FOOD =
            FoodComponent.Builder()
                .nutrition(2)
                .statusEffect(StatusEffectInstance(StatusEffects.NAUSEA, 2, 1), 0.5f)
                .build()
    }
}