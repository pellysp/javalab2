public class Task5 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private static int d = 0;
    private static boolean l = false;

    private static void parseArgs(String[] args) throws Exception {
        if (args.length != 4 && args.length != 2) {
            throw new Exception("Invalid arguments were passed");
        }
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-d":
                    try {
                        d = Integer.parseInt(args[i+1]);
                    } catch (NumberFormatException e) {
                        throw new Exception("Invalid argument type passed for a");
                    }
                    if (d < 1) {
                        throw new Exception("Number of days couldn't be more or equals to 1");
                    }
                    break;
                case "-l":
                    try {
                        l = Boolean.parseBoolean(args[i+1]);
                    } catch (NumberFormatException e) {
                        throw new Exception("Invalid argument type passed for c");
                    }
                    break;
                default:
                    throw new Exception("Invalid argument passed, required float arguments: -a, -c");
            }
            i++;
        }
        if ((l && d > 366) || (!l && d > 365)) {
            throw new Exception("Maximum number of days was exceed");
        }
    }

    public static DecryptedDay decryptDay(int day, boolean l) {
        int inx = 0;
        if (l) {
            inx = 1;
        }

        if (0 < day && day <= 31) {
            return new DecryptedDay(1, day);
        } else if (31 < day && day <= 59 + inx) {
            return new DecryptedDay(2, day - 31);
        } else if (59 + inx < day && day <= 90 + inx) {
            return new DecryptedDay(3, day - 59 - inx);
        } else if (90 + inx < day && day <= 120 + inx) {
            return new DecryptedDay(4, day - 90 - inx);
        } else if (120 + inx < day && day <= 151 + inx) {
            return new DecryptedDay(5, day - 120 - inx);
        } else if (151 + inx < day && day <= 181 + inx) {
            return new DecryptedDay(6, day - 151 - inx);
        } else if (181 + inx < day && day <= 212 + inx) {
            return new DecryptedDay(7, day - 181 - inx);
        } else if (212 + inx < day && day <= 243 + inx) {
            return new DecryptedDay(8, day - 212 - inx);
        } else if (243 + inx < day && day <= 273 + inx) {
            return new DecryptedDay(9, day - 243 - inx);
        } else if (273 + inx < day && day <= 314 + inx) {
            return new DecryptedDay(10, day - 273 - inx);
        } else if (314 + inx < day && day <= 334 + inx) {
            return new DecryptedDay(11, day - 314 - inx);
        } else if (334 + inx < day && day <= 365 + inx) {
            return new DecryptedDay(12, day - 334 - inx);
        }

        return new DecryptedDay(1, 1);
    }

    public static void main(String[] args) {
        try {
            parseArgs(args);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "Error during parsing arguments: " + e.getMessage() + ANSI_RESET);
        }

        DecryptedDay dd = decryptDay(d, l);

        System.out.println("Decrypted day:\nMonth: " + dd.getMonth() + "\nDay: " + dd.getDay());
    }
}

class DecryptedDay {
    private int month = 1; // Set January by default
    private int day = 1; // Set 1st day of month as default

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public DecryptedDay(int month, int day) {
        this.day = day;
        this.month = month;
    }
}