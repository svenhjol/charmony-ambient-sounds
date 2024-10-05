package svenhjol.charmony.ambient_sounds.fabric;

import net.fabricmc.api.ClientModInitializer;
import svenhjol.charmony.ambient_sounds.AmbientSounds;
import svenhjol.charmony.ambient_sounds.client.environment.Environment;
import svenhjol.charmony.ambient_sounds.client.settings.Settings;
import svenhjol.charmony.scaffold.enums.Side;

public class ClientInitializer implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Init charmony first.
        svenhjol.charmony.scaffold.fabric.ClientInitializer.init();

        // Bootstrap and run the mod.
        var ambientSounds = AmbientSounds.instance();
        ambientSounds.addFeature(Settings.class);
        ambientSounds.addFeature(Environment.class);
        ambientSounds.run(Side.Client);
    }
}
