package svenhjol.charmony.ambient_sounds.client.sound;

import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.List;

public class SoundHandler<T extends SoundInstance> {
    private Player player;
    private final List<T> sounds = new ArrayList<>();

    public SoundHandler(Player player) {
        updatePlayer(player);
    }

    public void updatePlayer(Player player) {
        this.player = player;
        sounds.forEach(s -> s.updatePlayer(this.player));
    }

    public List<T> getSounds() {
        return sounds;
    }

    public Player getPlayer() {
        return player;
    }

    public void tick() {
        if (player == null) return;
        sounds.forEach(T::tick);
    }

    public void stop() {
        sounds.forEach(T::stop);
    }
}
