package svenhjol.charmony.ambient_sounds.mixins;

import svenhjol.charmony.ambient_sounds.AmbientSounds;
import svenhjol.charmony.scaffold.mixins.BaseMixinConfig;

public class MixinConfig extends BaseMixinConfig {
    @Override
    protected String modId() {
        return AmbientSounds.ID;
    }

    @Override
    protected String rootClassPath() {
        return "svenhjol.charmony.ambient_sounds";
    }
}
