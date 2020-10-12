package net.eq2online.numericly.vars;

import baritone.api.BaritoneAPI;
import baritone.api.Settings;
import net.eq2online.numericly.ModuleInfo;
import net.eq2online.macros.scripting.api.APIVersion;
import net.eq2online.macros.scripting.parser.ScriptContext;
import net.eq2online.macros.scripting.variable.VariableCache;

@APIVersion(ModuleInfo.API_VERSION)
public class VariableProviderSettings extends VariableCache {

    @Override
    public void updateVariables(boolean clock) {
        if (!clock) {
            return;
        }
        Settings baritone = BaritoneAPI.getSettings();
        this.storeVariable("ALLOWBREAK", Boolean.valueOf(baritone.allowBreak.value));
        this.storeVariable("ALLOWPLACE", Boolean.valueOf(baritone.allowBreak.value));
        this.storeVariable("ALLOWSPRINT", Boolean.valueOf(baritone.allowBreak.value));
        this.storeVariable("ALLOWPARKOUR", Boolean.valueOf(baritone.allowParkour.value));
        this.storeVariable("ALLOWINVENTORY", Boolean.valueOf(baritone.allowInventory.value));
        this.storeVariable("ALLOWWALKONBOTTOMSLAB", Boolean.valueOf(baritone.allowWalkOnBottomSlab.value));
        this.storeVariable("ALLOWWATERBUCKETFALL", Boolean.valueOf(baritone.allowWaterBucketFall.value));
        this.storeVariable("BLOCKBREAKADDITIONALMENTPENALTY", String.valueOf(baritone.blockBreakAdditionalPenalty.value));
        this.storeVariable("BLOCKPLACEMENTPENALTY", String.valueOf(baritone.blockPlacementPenalty.value));
        this.storeVariable("BLOCKREACHDISTANCE", String.valueOf(baritone.blockReachDistance.value));
        this.storeVariable("MAXFALLHEIGHTNOWATER", baritone.maxFallHeightNoWater.value);
        this.storeVariable("FREELOOK", Boolean.valueOf(baritone.freeLook.value));
        this.storeVariable("REPLANTCROPS", Boolean.valueOf(baritone.replantCrops.value));
    }

    @Override
    public Object getVariable(String variableName) {
        return this.getCachedValue(variableName);
    }

    @Override
    public void onInit() {
        ScriptContext.MAIN.getCore().registerVariableProvider(this);
    }

}
