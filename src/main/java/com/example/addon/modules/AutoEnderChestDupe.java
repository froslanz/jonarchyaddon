package com.example.addon.modules;

import com.example.addon.AddonTemplate;
import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;

public class AutoEnderChestDupe extends Module {

    public AutoEnderChestDupe() {
        super(AddonTemplate.CATEGORY, "auto-enderchest-dupe", "Mantiene presionada la tecla Q para dupes en Ender Chest.");
    }

    @Override
    public void onDeactivate() {
        unpressKey();
    }

    @EventHandler
    private void onTick(TickEvent.Pre event) {
        if (mc.player == null || mc.world == null) return;


        mc.options.dropKey.setPressed(true);
    }

    private void unpressKey() {
        if (mc.options != null && mc.options.dropKey != null) {
            mc.options.dropKey.setPressed(false);
        }
    }
}
