package com.azer467.saphyre.entity.client;

import com.azer467.saphyre.SaphyreMetadata;
import com.azer467.saphyre.entity.SaphyreEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SaphyreModel extends AnimatedGeoModel<SaphyreEntity> {

    @Override
    public ResourceLocation getModelLocation(SaphyreEntity object) {
        return new ResourceLocation(SaphyreMetadata.MODID, "geo/saphyre.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SaphyreEntity object) {
        return new ResourceLocation(SaphyreMetadata.MODID, "textures/entity/saphyre/saphyre.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SaphyreEntity animatable) {
        return new ResourceLocation(SaphyreMetadata.MODID, "animations/saphyre.animation.json");
    }
}
