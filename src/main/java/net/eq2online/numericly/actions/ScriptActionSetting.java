package net.eq2online.numericly.actions;

import baritone.api.BaritoneAPI;
import net.eq2online.numericly.ModuleInfo;
import net.eq2online.macros.scripting.api.*;
import net.eq2online.macros.scripting.parser.ScriptAction;
import net.eq2online.macros.scripting.parser.ScriptContext;

@APIVersion(ModuleInfo.API_VERSION)
public class ScriptActionSetting extends ScriptAction {

    public ScriptActionSetting() {
        super(ScriptContext.MAIN, "setting");
    }

    @Override
    public boolean isThreadSafe() {
        return false;
    }

    @Override
    public IReturnValue execute(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params) {
        if(params.length == 2) {
            if (provider.expand(macro,params[0],false).equalsIgnoreCase("allowplace")) {
                BaritoneAPI.getSettings().allowPlace.value = Boolean.valueOf(provider.expand(macro,params[1],false));
            } else if (provider.expand(macro,params[0],false).equalsIgnoreCase("allowbreak")) {
                BaritoneAPI.getSettings().allowBreak.value = Boolean.valueOf(provider.expand(macro,params[1],false));
            } else if (provider.expand(macro,params[0],false).equalsIgnoreCase("allowsprint")) {
                BaritoneAPI.getSettings().allowSprint.value = Boolean.valueOf(provider.expand(macro,params[1],false));
            } else if (provider.expand(macro,params[0],false).equalsIgnoreCase("allowparkour")) {
                BaritoneAPI.getSettings().allowParkour.value = Boolean.valueOf(provider.expand(macro,params[1],false));
            } else if (provider.expand(macro,params[0],false).equalsIgnoreCase("allowinventory")) {
                BaritoneAPI.getSettings().allowInventory.value = Boolean.valueOf(provider.expand(macro,params[1],false));
            } else if (provider.expand(macro,params[0],false).equalsIgnoreCase("allowwalkonbottomslab")) {
                BaritoneAPI.getSettings().allowWalkOnBottomSlab.value = Boolean.valueOf(provider.expand(macro,params[1],false));
            } else if (provider.expand(macro,params[0],false).equalsIgnoreCase("allowWaterBucketFall")) {
                BaritoneAPI.getSettings().allowWaterBucketFall.value = Boolean.valueOf(provider.expand(macro,params[1],false));
            } else if (provider.expand(macro,params[0],false).equalsIgnoreCase("blockBreakAdditionalPenalty")) {
                BaritoneAPI.getSettings().blockBreakAdditionalPenalty.value = Double.valueOf(provider.expand(macro,params[1],false));
            } else if (provider.expand(macro,params[0],false).equalsIgnoreCase("blockPlacePenalty")) {
                BaritoneAPI.getSettings().blockPlacementPenalty.value = Double.valueOf(provider.expand(macro,params[1],false));
            } else if (provider.expand(macro,params[0],false).equalsIgnoreCase("blockReachDistance")) {
                BaritoneAPI.getSettings().blockReachDistance.value = Float.valueOf(provider.expand(macro,params[1],false));
            } else if (provider.expand(macro,params[0],false).equalsIgnoreCase("freelook")) {
                BaritoneAPI.getSettings().freeLook.value = Boolean.valueOf(provider.expand(macro,params[1],false));
            } else if (provider.expand(macro,params[0],false).equalsIgnoreCase("maxFallHeightNoWater")) {
                BaritoneAPI.getSettings().maxFallHeightNoWater.value = Integer.valueOf(provider.expand(macro,params[1],false));
            } else if (provider.expand(macro,params[0],false).equalsIgnoreCase("replantCrops")) {
                BaritoneAPI.getSettings().replantCrops.value = Boolean.valueOf(provider.expand(macro,params[1],false));
            } else if (provider.expand(macro,params[0],false).equalsIgnoreCase("buildInLayers")) {
                BaritoneAPI.getSettings().buildInLayers.value = Boolean.valueOf(provider.expand(macro,params[1],false));
            }
        }
        return null;
    }


    @Override
    public void onInit() {
        this.context.getCore().registerScriptAction(this);
    }

}


