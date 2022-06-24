package com.benjilebon.saphyre.entity.client;

import com.benjilebon.saphyre.SaphyreMetadata;
import com.benjilebon.saphyre.entity.SaphyreEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SaphyreRenderer extends GeoEntityRenderer<SaphyreEntity> {
    public SaphyreRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SaphyreModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(SaphyreEntity instance) {
        return new ResourceLocation(SaphyreMetadata.MODID, "textures/entity/saphyre/saphyre.png");
    }
}
