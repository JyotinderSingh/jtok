package tok;

import java.util.List;
import java.util.Map;

public class TokClass implements TokCallable {
    /**
     * TokClass is the runtime representation of a Tok Class.
     * The Stmt.Class AST node is converted into a TokClass by the interpreter at runtime.
     */

    final String name;
    final TokClass superclass;
    private final Map<String, TokFunction> methods;

    TokClass(String name, TokClass superclass, Map<String, TokFunction> methods) {
        this.name = name;
        this.superclass = superclass;
        this.methods = methods;
    }

    TokFunction findMethod(String name) {
        if (methods.containsKey(name)) {
            return methods.get(name);
        }

        if (superclass != null) {
            return superclass.findMethod(name);
        }

        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        TokInstance instance = new TokInstance(this);
        TokFunction initializer = findMethod("init");
        if (initializer != null) {
            initializer.bind(instance).call(interpreter, arguments);
        }
        return instance;
    }

    @Override
    public int arity() {
        TokFunction initializer = findMethod("init");
        if (initializer == null) return 0;
        return initializer.arity();
    }
}
