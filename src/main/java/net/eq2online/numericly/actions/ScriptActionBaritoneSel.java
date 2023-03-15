package net.eq2online.numericly.actions;

import baritone.api.BaritoneAPI;
import baritone.api.utils.BetterBlockPos;
import net.eq2online.macros.scripting.parser.ScriptCore;
import net.eq2online.numericly.ModuleInfo;
import net.eq2online.macros.scripting.api.*;
import net.eq2online.macros.scripting.parser.ScriptAction;
import net.eq2online.macros.scripting.parser.ScriptContext;

@APIVersion(ModuleInfo.API_VERSION)
public class ScriptActionBaritoneSel extends ScriptAction {

    public ScriptActionBaritoneSel() {
        super(ScriptContext.MAIN, "baritonesel");
    }

    @Override
    public boolean isThreadSafe() {
        return false;
    }


    @Override
    public IReturnValue execute(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params) {
        if (params.length >= 3) {

            int x = ScriptCore.tryParseInt(provider.expand(macro,params[0],false), Integer.MAX_VALUE);
            int y = ScriptCore.tryParseInt(provider.expand(macro,params[1],false), Integer.MAX_VALUE);
            int z = ScriptCore.tryParseInt(provider.expand(macro,params[2],false), Integer.MAX_VALUE);

            if ((x != Integer.MAX_VALUE) && (y != Integer.MAX_VALUE) && (z != Integer.MAX_VALUE)) {
                BetterBlockPos block = new BetterBlockPos(x, y, z);
                BaritoneAPI.getProvider().getPrimaryBaritone().getSelectionManager().addSelection(block, block);
            } else {
                String returnMessage = new String("");
                if (x == Integer.MAX_VALUE)
                    returnMessage+="{1st parameter is not int ("+provider.expand(macro,params[0],false)+")}";
                if (y == Integer.MAX_VALUE)
                    returnMessage+="{2nd parameter is not int ("+provider.expand(macro,params[1],false)+")}";
                if (z == Integer.MAX_VALUE)
                    returnMessage+="{3rd parameter is not int ("+provider.expand(macro,params[2],false)+")}";
                return new ReturnValue(returnMessage);
            }
        }
        return null;
    }

    @Override
    public void onInit() {
        this.context.getCore().registerScriptAction(this);
    }

}
