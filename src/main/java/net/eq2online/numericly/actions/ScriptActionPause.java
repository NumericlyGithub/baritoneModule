package net.eq2online.numericly.actions;

import baritone.api.BaritoneAPI;
import net.eq2online.numericly.ModuleInfo;
import net.eq2online.macros.scripting.api.*;
import net.eq2online.macros.scripting.parser.ScriptAction;
import net.eq2online.macros.scripting.parser.ScriptContext;

@APIVersion(ModuleInfo.API_VERSION)
public class ScriptActionPause extends ScriptAction {

    public ScriptActionPause() {
        super(ScriptContext.MAIN, "pause");
    }

    @Override
    public boolean isThreadSafe() {
        return false;
    }


    @Override
    public IReturnValue execute(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params) {
        BaritoneAPI.getProvider().getPrimaryBaritone().getCommandManager().execute("pause");
        return null;
    }


    @Override
    public void onInit() {
        this.context.getCore().registerScriptAction(this);
    }

}
