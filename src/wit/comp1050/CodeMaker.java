package wit.comp1050;

import java.util.Random;

public class CodeMaker {
    public Code makeCode(boolean allowDups)
    {
        Code theCode = new Code();
        Random r = new Random();
        for (int i = 0; i < Code.LENGTH; i++) {
            int n = r.nextInt(Code.MAX_CODE_VAL + 1);
            if (!allowDups) {
                while (theCode.contains(n)) {
                    n = r.nextInt(Code.MAX_CODE_VAL + 1);
                }
            }
            theCode.addPegValue(n);
        }
        return theCode;
    }
}
