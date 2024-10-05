package svenhjol.charmony.ambient_sounds.helper;

import net.minecraft.sounds.SoundSource;
import svenhjol.charmony.ambient_sounds.AmbientSounds;
import svenhjol.charmony.ambient_sounds.client.settings.Settings;

public final class SettingsHelper {
    private static final Settings SETTINGS = AmbientSounds.instance().feature(Settings.class);

    public static SoundSource soundSource() {
        return SETTINGS.soundSource();
    }

    public static double worldAmbienceVolumeScaling() {
        return SETTINGS.environmentVolumeScaling();
    }

    public static int cullSoundAboveGround() {
        return SETTINGS.cullSoundAboveGround();
    }
}
