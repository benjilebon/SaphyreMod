package com.azer467.saphyre.util.handlers;

import com.azer467.saphyre.SaphyreMetadata;
import com.google.gson.JsonObject;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.fml.common.Loader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.BooleanSupplier;

public class IsModPresentConditionHandler implements IConditionFactory {

    private static Logger logger = LogManager.getLogger(SaphyreMetadata.MODID);

    @Override
    public BooleanSupplier parse(JsonContext context, JsonObject json) {
        final String key = JsonUtils.getString(json , "mod");
        final boolean isModLoaded = Loader.isModLoaded(key);
        if (!isModLoaded) {
            logger.info("Ignoring recipe for non-present mod : " + key);
        }
        return () -> isModLoaded;
    }
}
