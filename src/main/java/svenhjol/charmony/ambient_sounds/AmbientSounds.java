package svenhjol.charmony.ambient_sounds;

import svenhjol.charmony.core.annotations.ModDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.enums.Side;

@ModDefinition(id = AmbientSounds.ID, sides = {Side.Client},
    name = "Ambient sounds",
    description = "Simple ambient sounds for Minecraft. Compatible with vanilla servers such as Realms.")
public class AmbientSounds extends Mod {
    public static final String ID = "charmony-ambient-sounds";

    private static AmbientSounds instance;

    public static AmbientSounds instance() {
        if (instance == null) {
            instance = new AmbientSounds();
        }
        return instance;
    }

    @Override
    public String id() {
        return ID;
    }
}
