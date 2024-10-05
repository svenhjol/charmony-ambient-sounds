package svenhjol.charmony.ambient_sounds.client.biomes.sounds;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.biome.Biome;
import svenhjol.charmony.ambient_sounds.AmbientSounds;
import svenhjol.charmony.ambient_sounds.client.biomes.BiomeSound;
import svenhjol.charmony.ambient_sounds.client.biomes.SurfaceBiomeSound;
import svenhjol.charmony.ambient_sounds.client.sound.SoundHandler;
import svenhjol.charmony.ambient_sounds.client.sound.SoundType;
import svenhjol.charmony.ambient_sounds.helper.BiomeCheckHelper;

import javax.annotation.Nullable;

public class River implements SoundType<BiomeSound> {
    public final SoundEvent sound;

    public River() {
        sound = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AmbientSounds.ID, "biome.river"));
    }

    @Override
    public void addSounds(SoundHandler<BiomeSound> handler) {
        handler.getSounds().add(new SurfaceBiomeSound(handler.getPlayer(), true) {
            @Nullable
            @Override
            public SoundEvent getSound() {
                return sound;
            }

            @Override
            public boolean isValidBiomeCondition(Holder<Biome> holder, ResourceKey<Biome> key) {
                return BiomeCheckHelper.RIVER.test(holder, key);
            }
        });
    }
}
