package com.benjilebon.saphyre.entity.client;

import com.benjilebon.saphyre.SaphyreMetadata;
import com.benjilebon.saphyre.entity.SaphyreEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SaphyreModel extends AnimatedGeoModel<SaphyreEntity> {
    @Override
    public ResourceLocation getModelResource(SaphyreEntity object) {
        return new ResourceLocation(SaphyreMetadata.MODID, "geo/saphyre.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SaphyreEntity object) {
        return new ResourceLocation(SaphyreMetadata.MODID, "textures/entity/saphyre/saphyre.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SaphyreEntity animatable) {
        return new ResourceLocation(SaphyreMetadata.MODID, "animations/saphyre.animation.json");
    }

    @Override
    public IBone getBone(String boneName) {
        return super.getBone(boneName);
    }
}
