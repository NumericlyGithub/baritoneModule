package net.eq2online.numericly.vars;

import baritone.api.BaritoneAPI;
import baritone.api.Settings;
import net.eq2online.numericly.ModuleInfo;
import net.eq2online.macros.scripting.api.APIVersion;
import net.eq2online.macros.scripting.parser.ScriptContext;
import net.eq2online.macros.scripting.variable.VariableCache;

@APIVersion(ModuleInfo.API_VERSION)
public class VariableProviderInstalled extends VariableCache {

    @Override
    public void updateVariables(boolean clock) {
        if (!clock) {
            return;
        }
        Settings baritone = BaritoneAPI.getSettings();
        this.storeVariable("MODULEBARITONE", true);
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
