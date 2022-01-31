package cope.cosmos.client.features.modules.visual;

import cope.cosmos.client.events.RenderFogColorEvent;
import cope.cosmos.client.events.RenderSkyEvent;
import cope.cosmos.client.features.modules.Category;
import cope.cosmos.client.features.modules.Module;
import cope.cosmos.client.features.setting.Setting;
import cope.cosmos.util.string.ColorUtil;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;

/**
 * @author linustouchtips
 * @since 12/28/2021
 */
public class SkyColor extends Module {
    public static SkyColor INSTANCE;

    public SkyColor() {
        super("SkyColor", Category.VISUAL, "Colors the sky");
        INSTANCE = this;
    }

    public static Setting<Boolean> sky = new Setting<>("Sky", true).setDescription("Colors the sky");
    public static Setting<Boolean> fog = new Setting<>("Fog", true).setDescription("Colors the fog");

    @SubscribeEvent
    public void onRenderSky(RenderSkyEvent event) {
        if (sky.getValue()) {
            // override sky color
            event.setCanceled(true);
            event.setColor(new Color(ColorUtil.getPrimaryColor().getRed() / 255F, ColorUtil.getPrimaryColor().getGreen() / 255F, ColorUtil.getPrimaryColor().getBlue() / 255F));
        }
    }

    @SubscribeEvent
    public void onRenderFogColor(RenderFogColorEvent event) {
        if (fog.getValue()) {
            // override fog color
            event.setColor(new Color(ColorUtil.getPrimaryColor().getRed() / 255F, ColorUtil.getPrimaryColor().getGreen() / 255F, ColorUtil.getPrimaryColor().getBlue() / 255F));
        }
    }
}
