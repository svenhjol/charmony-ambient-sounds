 package svenhjol.charmony.ambient_sounds.client.environment.sounds;

 import net.minecraft.resources.ResourceLocation;
 import net.minecraft.sounds.SoundEvent;
 import net.minecraft.world.level.Level;
 import org.jetbrains.annotations.Nullable;
 import svenhjol.charmony.ambient_sounds.AmbientSounds;
 import svenhjol.charmony.ambient_sounds.client.environment.EnvironmentSound;
 import svenhjol.charmony.ambient_sounds.client.environment.RepeatingEnvironmentSound;
 import svenhjol.charmony.ambient_sounds.client.sound.SoundHandler;
 import svenhjol.charmony.ambient_sounds.client.sound.SoundType;
 import svenhjol.charmony.scaffold.helper.WorldHelper;

 public class High implements SoundType<EnvironmentSound> {
     public final SoundEvent sound;

     public High() {
         sound = SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(AmbientSounds.ID, "environment.high"));
     }

     public void addSounds(SoundHandler<EnvironmentSound> handler) {
         handler.getSounds().add(new RepeatingEnvironmentSound(handler.getPlayer()) {
             @Override
             public boolean isValidEnvironmentCondition() {
                 var top = level.getMaxY() > 256 ? 200 : 150;
                 return level.dimension() == Level.OVERWORLD
                     && player.blockPosition().getY() > top;
             }

             @Override
             public boolean isValidPlayerCondition() {
                 return level.dimension() == Level.OVERWORLD
                     && WorldHelper.isOutside(player);
             }

             @Nullable
             @Override
             public SoundEvent getSound() {
                 return sound;
             }

             @Override
             public int getDelay() {
                 return level.random.nextInt(200) + 100;
             }

             @Override
             public float getVolume() {
                 return 0.5f;
             }
         });
     }
 }
