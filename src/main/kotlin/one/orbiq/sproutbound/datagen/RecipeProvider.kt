package one.orbiq.sproutbound.datagen

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.item.Items
import net.minecraft.item.ToolMaterials
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryWrapper
import net.minecraft.util.Identifier
import one.orbiq.sproutbound.ModItems
import one.orbiq.sproutbound.Sproutbound
import one.orbiq.sproutbound.items.ModKnifes
import java.util.concurrent.CompletableFuture

class RecipeProvider(
    output: FabricDataOutput?,
    registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>?
) : FabricRecipeProvider(output, registriesFuture) {
    override fun generate(exporter: RecipeExporter) {
        // Recipe for the diamond knife
        ModKnifes.getKnifes().forEach { knife ->
            val ingredient = knife.getIngredient()

            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, knife)
                .pattern(" #")
                .pattern("/ ")
                .input('#', knife.getIngredient())
                .input('/', Items.STICK)
                .criterion("has_${ingredient.translationKey}", conditionsFromItem(ingredient))
                .offerTo(exporter)
        }
    }
}