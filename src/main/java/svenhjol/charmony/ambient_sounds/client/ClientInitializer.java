package svenhjol.charmony.ambient_sounds.client;

import net.fabricmc.api.ClientModInitializer;
import svenhjol.charmony.ambient_sounds.AmbientSounds;
import svenhjol.charmony.ambient_sounds.client.features.biomes.Biomes;
import svenhjol.charmony.ambient_sounds.client.features.environment.Environment;
import svenhjol.charmony.ambient_sounds.client.features.settings.Settings;
import svenhjol.charmony.core.enums.Side;

public class ClientInitializer implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Init charmony first.
        svenhjol.charmony.core.client.ClientInitializer.init();

        // Bootstrap and run the mod.
        var ambientSounds = AmbientSounds.instance();
        ambientSounds.addSidedFeature(Settings.class);
        ambientSounds.addSidedFeature(Biomes.class);
        ambientSounds.addSidedFeature(Environment.class);
        ambientSounds.run(Side.Client);
    }
}
