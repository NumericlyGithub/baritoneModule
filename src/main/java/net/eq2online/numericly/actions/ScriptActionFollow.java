package net.eq2online.numericly.actions;

import baritone.api.BaritoneAPI;
import net.eq2online.numericly.ModuleInfo;
import net.eq2online.macros.scripting.api.*;
import net.eq2online.macros.scripting.parser.ScriptAction;
import net.eq2online.macros.scripting.parser.ScriptContext;

@APIVersion(ModuleInfo.API_VERSION)
public class ScriptActionFollow extends ScriptAction {

    public ScriptActionFollow() {
        super(ScriptContext.MAIN, "follow ");
    }

    @Override
    public boolean isThreadSafe() {
        return false;
    }


    @Override
    public IReturnValue execute(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params) {
        if (params[0].equalsIgnoreCase("entities")&&params.length == 1) {
            BaritoneAPI.getProvider().getPrimaryBaritone().getCommandManager().execute("follow entities");
        } else if (params[0].equalsIgnoreCase("entity")&&params.length == 2) {
            BaritoneAPI.getProvider().getPrimaryBaritone().getCommandManager().execute("follow entity "+params[1]);
        } else if (params[0].equalsIgnoreCase("players")&&params.length == 1) {
            BaritoneAPI.getProvider().getPrimaryBaritone().getCommandManager().execute("follow players");
        } else if (params[0].equalsIgnoreCase("player")&&params.length == 1) {
            BaritoneAPI.getProvider().getPrimaryBaritone().getCommandManager().execute("follow "+params[1]);
        }
        return null;
    }


    @Override
    public void onInit() {
        this.context.getCore().registerScriptAction(this);
    }

}
