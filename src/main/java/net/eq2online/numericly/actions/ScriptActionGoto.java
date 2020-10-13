package net.eq2online.numericly.actions;

import baritone.api.BaritoneAPI;
import net.eq2online.numericly.ModuleInfo;
import net.eq2online.macros.scripting.api.*;
import net.eq2online.macros.scripting.parser.ScriptAction;
import net.eq2online.macros.scripting.parser.ScriptContext;

@APIVersion(ModuleInfo.API_VERSION)
public class ScriptActionGoto extends ScriptAction {

    public ScriptActionGoto() {
        super(ScriptContext.MAIN, "goto");
    }

    @Override
    public boolean isThreadSafe() {
        return false;
    }


    @Override
    public IReturnValue execute(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params) {
        if (params.length == 3) {
            BaritoneAPI.getProvider().getPrimaryBaritone().getCommandManager().execute("goto "+provider.expand(macro,params[0],false)+
                    " "+provider.expand(macro,params[1],false)+
                    " "+provider.expand(macro,params[2],false));
        }
        return null;
    }


    @Override
    public void onInit() {
        this.context.getCore().registerScriptAction(this);
    }

}
