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
            if (params[0].equalsIgnoreCase("allowplace")) {
                BaritoneAPI.getSettings().allowPlace.value = Boolean.valueOf(params[1]);
            } else if (params[0].equalsIgnoreCase("allowbreak")) {
                BaritoneAPI.getSettings().allowBreak.value = Boolean.valueOf(params[1]);
            } else if (params[0].equalsIgnoreCase("allowsprint")) {
                BaritoneAPI.getSettings().allowSprint.value = Boolean.valueOf(params[1]);
            } else if (params[0].equalsIgnoreCase("allowparkour")) {
                BaritoneAPI.getSettings().allowParkour.value = Boolean.valueOf(params[1]);
            } else if (params[0].equalsIgnoreCase("allowinventory")) {
                BaritoneAPI.getSettings().allowInventory.value = Boolean.valueOf(params[1]);
            } else if (params[0].equalsIgnoreCase("allowwalkonbottomslab")) {
                BaritoneAPI.getSettings().allowWalkOnBottomSlab.value = Boolean.valueOf(params[1]);
            } else if (params[0].equalsIgnoreCase("allowWaterBucketFall")) {
                BaritoneAPI.getSettings().allowWaterBucketFall.value = Boolean.valueOf(params[1]);
            } else if (params[0].equalsIgnoreCase("blockBreakAdditionalPenalty")) {
                BaritoneAPI.getSettings().blockBreakAdditionalPenalty.value = Double.valueOf(params[1]);
            } else if (params[0].equalsIgnoreCase("blockPlacePenalty")) {
                BaritoneAPI.getSettings().blockPlacementPenalty.value = Double.valueOf(params[1]);
            } else if (params[0].equalsIgnoreCase("blockReachDistance")) {
                BaritoneAPI.getSettings().blockReachDistance.value = Float.valueOf(params[1]);
            } else if (params[0].equalsIgnoreCase("freelook")) {
                BaritoneAPI.getSettings().freeLook.value = Boolean.valueOf(params[1]);
            } else if (params[0].equalsIgnoreCase("maxFallHeightNoWater")) {
                BaritoneAPI.getSettings().maxFallHeightNoWater.value = Integer.valueOf(params[1]);
            } else if (params[0].equalsIgnoreCase("replantCrops")) {
                BaritoneAPI.getSettings().replantCrops.value = Boolean.valueOf(params[1]);
            }
        }
        return null;
    }


    @Override
    public void onInit() {
        this.context.getCore().registerScriptAction(this);
    }

}
