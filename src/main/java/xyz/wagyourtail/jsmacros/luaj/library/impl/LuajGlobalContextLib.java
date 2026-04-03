package xyz.wagyourtail.jsmacros.luaj.library.impl;

import org.luaj.vm2.Globals;
import xyz.wagyourtail.jsmacros.core.language.BaseLanguage;
import xyz.wagyourtail.jsmacros.core.library.Library;
import xyz.wagyourtail.jsmacros.core.library.PerExecLanguageLibrary;
import xyz.wagyourtail.jsmacros.luaj.language.impl.LuajLanguageDefinition;
import xyz.wagyourtail.jsmacros.luaj.language.impl.LuajScriptContext;

@Library(value = "GlobalContext", languages = LuajLanguageDefinition.class)
public class LuajGlobalContextLib extends PerExecLanguageLibrary<Globals, LuajScriptContext> {

    public LuajGlobalContextLib(LuajScriptContext context, Class<? extends BaseLanguage<Globals, LuajScriptContext>> language) {
        super(context, language);
    }

    public String getPool() {
        return LuajLanguageDefinition.getOwnedPool(ctx);
    }
    public boolean isGlobal() {
        return LuajLanguageDefinition.getOwnedPool(ctx) != null;
    }
    public void release() {
        LuajLanguageDefinition.releaseGlobal(ctx);
    }
    public boolean destroyPool(String poolName) {
        return LuajLanguageDefinition.destroyPool(poolName);
    }
}
