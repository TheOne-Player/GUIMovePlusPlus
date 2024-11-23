package com.example.addon.modules;

import meteordevelopment.meteorclient.settings.BoolSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Categories;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.player.ChatUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;

public class GuiMovePlusPlus extends Module {

    public GuiMovePlusPlus() {
        super(Categories.Movement, "Gui Move ++", "Allows minimizing GUI's");
    }

    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Boolean> displayGuiStatus = sgGeneral.add(new BoolSetting.Builder()
        .name("display-gui-status")
        .description("Displays the current status of the GUI")
        .defaultValue(true)
        .build()
    );

    @Override
    public void onActivate() {
        MinecraftClient client = MinecraftClient.getInstance();
        Screen currentScreen = client.currentScreen;

        if (currentScreen != null) {
            if (currentScreen instanceof CustomScreen customScreen) {
                if (!customScreen.isMinimized()) {
                    customScreen.minimize(true);
                    updateGUIMinimizationStatus("Minimized");
                } else {
                    customScreen.minimize(false);
                    updateGUIMinimizationStatus("Maximized");
                }
            } else {
                ChatUtils.info("The current screen is not a CustomScreen.");
            }
        } else {
            ChatUtils.info("There is currently no active GUI to minimize.");
        }
    }

    private void updateGUIMinimizationStatus(String status) {
        if (displayGuiStatus.get()) {
            ChatUtils.info("GUI is now " + status);
        }
    }

    @Override
    public void onDeactivate() {
        // Add any necessary cleanup code here
    }
}
