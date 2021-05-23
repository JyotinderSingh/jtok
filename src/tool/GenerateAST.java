/*
 * Instead of tediously handwriting each class definition, field declaration, constructor, and initializer,
 * we’ve hacked together a script that does it for us. It has a description of each tree type—its name and fields —
 * and it prints out the Java code needed to define a class with that name and state.
 *
 * This script is a tiny Java command-line app that generates a file named “Expr.java”:
 */

package tok;

public class GenerateAST {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: generate_ast <output directory>");
            System.exit(64);
        }
    }
}
