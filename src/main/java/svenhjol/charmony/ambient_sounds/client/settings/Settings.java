package svenhjol.charmony.ambient_sounds.client.settings;

import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import svenhjol.charmony.scaffold.annotations.Configurable;
import svenhjol.charmony.scaffold.annotations.Feature;
import svenhjol.charmony.scaffold.base.Mod;
import svenhjol.charmony.scaffold.base.ModFeature;
import svenhjol.charmony.scaffold.enums.Side;

import java.util.Arrays;

@Feature(side = Side.Client, canBeDisabled = false, description = """
    Ambient sound settings.""")
public final class Settings extends ModFeature {
    @Configurable(
        name = "Audio channel",
        description = """
            The channel that Charmonium will use for playing sounds. Defaults to 'ambient'.
            Options: music, record, weather, block, hostile, neutral, player, ambient, voice"""
    )
    private static String audioChannel = "ambient";

    @Configurable(name = "Biome volume scaling", description = """
        Affects the volume of all biome ambient sounds. 1.0 is full volume.""", requireRestart = false)
    private static double biomeVolumeScaling = 0.55d;

    @Configurable(name = "Environment volume scaling", description = """
        Affects the volume of all environmental ambient sounds. 1.0 is full volume.""", requireRestart = false)
    private static double environmentVolumeScaling = 0.55d;

    @Configurable(
        name = "Height when silencing ambience",
        description = """
            Number of blocks above the ground that ambient sounds will be silenced.
            Set to zero to disable.""",
        requireRestart = false
    )
    private static int cullSoundAboveGround = 32;

    public Settings(Mod mod) {
        super(mod);
    }

    public static Settings feature() {
        return ModFeature.resolve(Settings.class).get();
    }

    public String audioChannel() {
        return audioChannel;
    }

    public double biomeVolumeScaling() {
        return Mth.clamp(biomeVolumeScaling, 0.0d, 1.0d);
    }

    public double environmentVolumeScaling() {
        return Mth.clamp(environmentVolumeScaling, 0.0d, 1.0d);
    }

    public int cullSoundAboveGround() {
        return Mth.clamp(cullSoundAboveGround, 0, 1024);
    }

    public SoundSource soundSource() {
        SoundSource source;
        var key = audioChannel.toLowerCase();
        source = Arrays.stream(SoundSource.values())
            .filter(v -> v.getName().equals(key))
            .findFirst()
            .orElse(SoundSource.AMBIENT);

        return source;
    }
}
