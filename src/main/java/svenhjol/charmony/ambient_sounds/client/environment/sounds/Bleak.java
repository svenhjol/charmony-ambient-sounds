 package svenhjol.charmony.ambient_sounds.client.environment.sounds;

 import net.minecraft.resources.ResourceLocation;
 import net.minecraft.sounds.SoundEvent;
 import org.jetbrains.annotations.Nullable;
 import svenhjol.charmony.ambient_sounds.AmbientSounds;
 import svenhjol.charmony.ambient_sounds.client.environment.EnvironmentSound;
 import svenhjol.charmony.ambient_sounds.client.environment.SurfaceEnvironmentSound;
 import svenhjol.charmony.ambient_sounds.client.sound.SoundHandler;
 import svenhjol.charmony.ambient_sounds.client.sound.SoundType;
 import svenhjol.charmony.ambient_sounds.helper.BiomeCheckHelper;
 import svenhjol.charmony.scaffold.helper.WorldHelper;

 public class Bleak implements SoundType<EnvironmentSound> {
     public final SoundEvent sound;

     public Bleak() {
         sound = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AmbientSounds.ID, "environment.bleak"));
     }

     public void addSounds(SoundHandler<EnvironmentSound> handler) {
         handler.getSounds().add(new SurfaceEnvironmentSound(handler.getPlayer()) {
             @Override
             public boolean isValidEnvironmentCondition() {
                 var holder = getBiomeHolder(player.blockPosition());
                 return BiomeCheckHelper.ICY.test(holder)
                     || BiomeCheckHelper.MOUNTAIN.test(holder);
             }

             @Override
             public boolean isValidPlayerCondition() {
                 return !WorldHelper.isNight(player)
                     && WorldHelper.isOutside(player)
                     && !WorldHelper.isBelowSeaLevel(player);
             }

             @Nullable
             @Override
             public SoundEvent getSound() {
                 return sound;
             }

             @Override
             public int getDelay() {
                 return level.random.nextInt(750) + 500;
             }

             @Override
             public float getVolume() {
                 return 0.5f;
             }
         });
     }
 }