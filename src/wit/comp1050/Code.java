package wit.comp1050;

public class Code {
    public static final int LENGTH = 4;
    public static final int MAX_CODE_VAL = 5;

    public Code() {
        _value = new int[LENGTH];
    }

    public Code(String cs) {

        // Iterate over the string and make a code from that ---
        // You will need to map String -> int and build the code
        String str = cs;


        for (int i = 0; i < Code.LENGTH; i++){
            char convert = cs.charAt(i);
            System.out.print(convert);
            return;
        }

    }


    public void addPegValue(int npegVal) {
        ++_index;
        if (_index >= LENGTH) {
            throw new ArrayIndexOutOfBoundsException("Cannot add another peg to the code");
        }
        if ((npegVal < 0) || (npegVal > MAX_CODE_VAL)) {
            throw new IllegalArgumentException("Invalid peg value");
        }
        _value[_index] = npegVal;
    }

    @Override
    public String toString() {
        String codeRep = "";
        for (int i = 0; i <= _index; i++) {
            String colorString = colorFromPegNumber(_value[i]);
            codeRep += colorString;
        }
        return codeRep;
    }

    public boolean contains(int n) {
        boolean isFound = false;
        for (int i = 0; i <= _index; i++) {
            isFound = (n == _value[i]);
            if (isFound) break;
        }
        return isFound;
    }

    private String colorFromPegNumber(int n) {
        return switch (n) {
            case 0 -> "R";
            case 1 -> "G";
            case 2 -> "B";
            case 3 -> "Y";
            case 4 -> "O";
            case 5 -> "P";
            default ->
                    throw new IllegalArgumentException("Cannot get color from peg number");
        };
    }


    // Code values expected to be between 0 - MAX
    int[] _value;
    int _index = -1;
}