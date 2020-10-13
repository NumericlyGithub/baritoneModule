package net.eq2online.numericly.vars;

import baritone.api.BaritoneAPI;
import baritone.api.IBaritone;
import net.eq2online.numericly.ModuleInfo;
import net.eq2online.macros.scripting.api.APIVersion;
import net.eq2online.macros.scripting.parser.ScriptContext;
import net.eq2online.macros.scripting.variable.VariableCache;

@APIVersion(ModuleInfo.API_VERSION)
public class VariableProviderRunning extends VariableCache {

    @Override
    public void updateVariables(boolean clock) {
        if (!clock) {
            return;
        }
        IBaritone baritone = BaritoneAPI.getProvider().getPrimaryBaritone();
        this.storeVariable("PATHFINDING",Boolean.valueOf(baritone.getCustomGoalProcess().isActive()));
        this.storeVariable("FARMING", Boolean.valueOf(baritone.getFarmProcess().isActive()));
        this.storeVariable("BUILDING", Boolean.valueOf(baritone.getBuilderProcess().isActive()));
        this.storeVariable("FOLLOWING", Boolean.valueOf(baritone.getFollowProcess().isActive()));
        this.storeVariable("MINING", Boolean.valueOf(baritone.getMineProcess().isActive()));
        if(baritone.getCustomGoalProcess().isActive()||
                baritone.getFarmProcess().isActive()||
                baritone.getBuilderProcess().isActive()||
                baritone.getFollowProcess().isActive()||
                baritone.getMineProcess().isActive()) {
            this.storeVariable("BARITONE", true);
        } else {
            this.storeVariable("BARITONE", false);
        }

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
