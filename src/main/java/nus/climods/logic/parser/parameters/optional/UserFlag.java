package nus.climods.logic.parser.parameters.optional;

/**
 * UserFlag corresponding to OptionalArgument of --user or -u
 */
public class UserFlag extends OptionalArgument {
    public static final String SHORT_OPTION = "u";
    public static final String LONG_OPTION = "user";

    public UserFlag() {
        super(SHORT_OPTION, LONG_OPTION);
    }
}
