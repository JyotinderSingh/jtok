package tok;

import java.util.List;

interface TokCallable {
    int arity();
    Object call(Interpreter interpreter, List<Object> arguments);
}
