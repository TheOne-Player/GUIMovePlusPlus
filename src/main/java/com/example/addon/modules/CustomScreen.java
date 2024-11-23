package com.example.addon.modules;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class CustomScreen extends Screen {
    private boolean minimized = false;

    protected CustomScreen(Text title) {
        super(title);
    }

    public boolean isMinimized() {
        return minimized;
    }

    public void minimize(boolean minimize) {
        this.minimized = minimize;
        // Add logic to handle the actual minimization of the screen
        if (minimize) {
            // Logic to minimize the screen
            this.width = 0;
            this.height = 0;
        } else {
            // Logic to restore the screen size
            this.width = this.client.getWindow().getScaledWidth();
            this.height = this.client.getWindow().getScaledHeight();
        }
    }
}
