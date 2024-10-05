package svenhjol.charmony.ambient_sounds.client.environment.sounds;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;
import svenhjol.charmony.ambient_sounds.AmbientSounds;
import svenhjol.charmony.ambient_sounds.client.environment.EnvironmentSound;
import svenhjol.charmony.ambient_sounds.client.environment.RepeatingEnvironmentSound;
import svenhjol.charmony.ambient_sounds.client.sound.SoundHandler;
import svenhjol.charmony.ambient_sounds.client.sound.SoundType;
import svenhjol.charmony.scaffold.helper.WorldHelper;

import java.util.Optional;

public class Deepslate implements SoundType<EnvironmentSound> {
    public final SoundEvent sound;

    public Deepslate() {
        sound = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AmbientSounds.ID, "environment.deepslate"));
    }

    public void addSounds(SoundHandler<EnvironmentSound> handler) {
        handler.getSounds().add(new RepeatingEnvironmentSound(handler.getPlayer()) {
            @Override
            public boolean isValidEnvironmentCondition() {
                Optional<BlockPos> optBlock = BlockPos.findClosestMatch(player.blockPosition(), 8, 4, pos -> {
                    var block = level.getBlockState(pos).getBlock();
                    return block == Blocks.DEEPSLATE;
                });

                return optBlock.isPresent();
            }

            @Override
            public boolean isValidPlayerCondition() {
                return !WorldHelper.isOutside(player)
                    && WorldHelper.isBelowSeaLevel(player);
            }

            @Nullable
            @Override
            public SoundEvent getSound() {
                return sound;
            }

            @Override
            public int getDelay() {
                return level.random.nextInt(400) + 400;
            }

            @Override
            public float getVolume() {
                return 0.7f;
            }
        });
    }
}
