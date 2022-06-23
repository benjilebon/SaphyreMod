package com.azer467.saphyre.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GiftParticle extends TextureSheetParticle {
    protected GiftParticle(ClientLevel level, double xCoord, double yCoord, double zCoord,
                           SpriteSet spriteSet, double xd, double yd, double zd) {
        super(level, xCoord, yCoord, zCoord, xd, yd, zd);

        this.friction = 0.85F;
        this.xd = xd;
        this.yd = yd + 0.15d;
        this.zd = zd;
        this.quadSize *= 1.0F;
        this.lifetime = 50;
        this.setSpriteFromAge(spriteSet);

        this.rCol = 1f;
        this.gCol = 1f;
        this.bCol = 1f;
    }

    @Override
    public void tick() {
        super.tick();
        fadeOut();
    }

    private void fadeOut() {
        this.alpha = (-(1/(float)lifetime) * age + 1);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class EnhancedGiftProvider extends GiftProvider {
        public EnhancedGiftProvider(SpriteSet spriteSet) {
            super(spriteSet);
        }

        @Override
        public void setParticleColor(GiftParticle particle) {
            particle.setColor(0.125f, 0.900f, 0.980f);
        }
    }

    public static class AmazingGiftProvider extends GiftProvider {
        public AmazingGiftProvider(SpriteSet spriteSet) {
            super(spriteSet);
        }

        @Override
        public void setParticleColor(GiftParticle particle) {
            particle.setColor(0.015f, 0.505f, 0.250f);
        }
    }

    public static class IncredibleGiftProvider extends GiftProvider {
        public IncredibleGiftProvider(SpriteSet spriteSet) {
            super(spriteSet);
        }

        @Override
        public void setParticleColor(GiftParticle particle) {
            particle.setColor(0.835f, 0.065f, 0.780f);
        }
    }

    public static class UltimateGiftProvider extends GiftProvider {
        public UltimateGiftProvider(SpriteSet spriteSet) {
            super(spriteSet);
        }

        @Override
        public void setParticleColor(GiftParticle particle) {
            particle.setColor(1.0f, 0.525f, 0.020f);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class GiftProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public GiftProvider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public void setParticleColor(GiftParticle particle) {
            particle.setColor(0.090f, 0.120f, 0.835f);
        }

        public Particle createParticle(SimpleParticleType particleType, ClientLevel level,
                                       double x, double y, double z,
                                       double dx, double dy, double dz) {
            GiftParticle particle = new GiftParticle(level, x, y, z, this.sprites, dx, dy, dz);
            this.setParticleColor(particle);
            return particle;
        }
    }
}
