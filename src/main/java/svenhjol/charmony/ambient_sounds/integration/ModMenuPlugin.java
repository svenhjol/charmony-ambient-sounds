package svenhjol.charmony.ambient_sounds.integration;

import svenhjol.charmony.ambient_sounds.AmbientSoundsMod;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.integration.BaseModMenuPlugin;

public class ModMenuPlugin extends BaseModMenuPlugin {
    @Override
    public Mod mod() {
        return AmbientSoundsMod.instance();
    }
}
