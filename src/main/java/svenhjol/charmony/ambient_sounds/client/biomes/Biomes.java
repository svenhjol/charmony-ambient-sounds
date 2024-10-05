package svenhjol.charmony.ambient_sounds.client.biomes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import svenhjol.charmony.scaffold.annotations.Configurable;
import svenhjol.charmony.scaffold.annotations.Feature;
import svenhjol.charmony.scaffold.base.Mod;
import svenhjol.charmony.scaffold.base.ModFeature;
import svenhjol.charmony.scaffold.enums.Side;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Feature(side = Side.Client, description = """
    Plays ambient background sound according to the biome and time of day.""")
public final class Biomes extends ModFeature {
    private final List<ResourceLocation> validDimensions = new ArrayList<>();

    public final Registers registers;
    public final Handlers handlers;

    @Configurable(
        name = "Biome sound blending",
        description = """
            Number of blocks to check for neighbouring biomes.
            Set to zero to disable.""",
        requireRestart = false
    )
    private static int biomeBlend = 32;

    @Configurable(
        name = "Valid dimensions",
        description = "Dimensions in which biome ambience will be played."
    )
    private static List<String> dimensions = Arrays.asList(
        "minecraft:overworld",
        "minecraft:the_end"
    );

    public Biomes(Mod mod) {
        super(mod);
        registers = new Registers(this);
        handlers = new Handlers(this);
    }

    public static Biomes feature() {
        return ModFeature.resolve(Biomes.class).get();
    }

    public int biomeBlend() {
        return Mth.clamp(biomeBlend, 0, 256);
    }

    public List<String> dimensions() {
        return dimensions;
    }

    public List<ResourceLocation> validDimensions() {
        if (dimensions().isEmpty()) return List.of();
        if (validDimensions.isEmpty()) {
            dimensions().forEach(dim -> validDimensions.add(ResourceLocation.parse(dim)));
        }
        return validDimensions;
    }
}
