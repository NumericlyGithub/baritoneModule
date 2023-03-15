package net.eq2online.numericly.actions;

import baritone.api.BaritoneAPI;
import baritone.api.utils.BetterBlockPos;
import net.eq2online.macros.scripting.parser.ScriptCore;
import net.eq2online.numericly.ModuleInfo;
import net.eq2online.macros.scripting.api.*;
import net.eq2online.macros.scripting.parser.ScriptAction;
import net.eq2online.macros.scripting.parser.ScriptContext;

@APIVersion(ModuleInfo.API_VERSION)
public class ScriptActionSelArray extends ScriptAction {

    public ScriptActionSelArray() {
        super(ScriptContext.MAIN, "selarray");
    }

    @Override
    public boolean isThreadSafe() {
        return false;
    }


    @Override
    public IReturnValue execute(IScriptActionProvider provider, IMacro macro, IMacroAction instance, String rawParams, String[] params) {
        String returnMessage = new String("");
        if (params.length >= 3) {

            String arrayNameX = provider.expand(macro,params[0],false);
            String arrayNameY = provider.expand(macro,params[1],false);
            String arrayNameZ = provider.expand(macro,params[2],false);

            if(!provider.getArrayExists(macro, arrayNameX) || !provider.getArrayExists(macro, arrayNameY) || !provider.getArrayExists(macro, arrayNameZ) ) {
                return new ReturnValue("Not all arrays exist! ("+provider.getArrayExists(macro, arrayNameX)+","+provider.getArrayExists(macro, arrayNameY)+","+provider.getArrayExists(macro, arrayNameZ)+")");
            }

            int size = Math.min(Math.min(provider.getArraySize(macro, arrayNameX), provider.getArraySize(macro, arrayNameY)), provider.getArraySize(macro, arrayNameZ));

            int x;
            int y;
            int z;
            for(int i = 0; i < size;i++) {
                x = ScriptCore.tryParseInt(provider.getArrayElement(macro, arrayNameX, i).toString(), Integer.MAX_VALUE);
                y = ScriptCore.tryParseInt(provider.getArrayElement(macro, arrayNameY, i).toString(), Integer.MAX_VALUE);
                z = ScriptCore.tryParseInt(provider.getArrayElement(macro, arrayNameZ, i).toString(), Integer.MAX_VALUE);
                if ((x != Integer.MAX_VALUE) && (y != Integer.MAX_VALUE) && (z != Integer.MAX_VALUE)) {
                    BetterBlockPos block = new BetterBlockPos(x, y, z);
                    BaritoneAPI.getProvider().getPrimaryBaritone().getSelectionManager().addSelection(block, block);
                } else {
                    returnMessage += "{input at index "+i+" is not int}";
                }
            }
        }
        if (!returnMessage.isEmpty())
            return new ReturnValue(returnMessage);
        else
            return null;
    }

    @Override
    public void onInit() {
        this.context.getCore().registerScriptAction(this);
    }

}
