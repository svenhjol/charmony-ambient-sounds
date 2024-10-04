package svenhjol.charmony.ambient_sounds;

import svenhjol.charmony.scaffold.base.Mod;

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
