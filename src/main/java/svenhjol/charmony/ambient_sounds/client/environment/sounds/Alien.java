 package svenhjol.charmony.ambient_sounds.client.environment.sounds;

 import net.minecraft.resources.ResourceLocation;
 import net.minecraft.sounds.SoundEvent;
 import org.jetbrains.annotations.Nullable;
 import svenhjol.charmony.ambient_sounds.AmbientSounds;
 import svenhjol.charmony.ambient_sounds.client.environment.EnvironmentSound;
 import svenhjol.charmony.ambient_sounds.client.environment.RepeatingEnvironmentSound;
 import svenhjol.charmony.ambient_sounds.client.sound.SoundHandler;
 import svenhjol.charmony.ambient_sounds.client.sound.SoundType;
 import svenhjol.charmony.ambient_sounds.helper.BiomeCheckHelper;

 public class Alien implements SoundType<EnvironmentSound> {
    public final SoundEvent sound;

    public Alien() {
        sound = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AmbientSounds.ID, "environment.alien"));
    }

    public void addSounds(SoundHandler<EnvironmentSound> handler) {
        handler.getSounds().add(new RepeatingEnvironmentSound(handler.getPlayer()) {
            @Override
            public boolean isValidEnvironmentCondition() {
                var holder = getBiomeHolder(player.blockPosition());
                return BiomeCheckHelper.THE_END.test(holder);
            }

            @Override
            public boolean isValidPlayerCondition() {
                return true;
            }

            @Nullable
            @Override
            public SoundEvent getSound() {
                return sound;
            }

            @Override
            public int getDelay() {
                return level.random.nextInt(400) + 300;
            }

            @Override
            public float getVolume() {
                return 0.85f;
            }
        });
    }
 }
