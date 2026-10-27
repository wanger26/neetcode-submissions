class Solution {
    public String intToRoman(int num) {
        StringBuilder bldr = new StringBuilder();

        Map<Integer, String> map = Map.ofEntries(Map.entry(1000, "M"), Map.entry(900, "CM"),
            Map.entry(500, "D"), Map.entry(400, "CD"), Map.entry(100, "C"), Map.entry(90, "XC"),
            Map.entry(50, "L"), Map.entry(40, "XL"), Map.entry(10, "X"), Map.entry(9, "IX"),
            Map.entry(5, "V"), Map.entry(4, "IV"), Map.entry(1, "I"));

        while (num > 0) {
            if (num / 1000 > 0) {
                int digit = num / 1000;
                for (int i = 0; i < digit; i++) {
                    bldr.append("M");
                }
                num -= digit * 1000;
            } else {
                int power = 1;
                for (; num / (power * 10) > 0; power *= 10) {
                }
                int base = (num / power) * power;
                if (base == 4 * power) {
                    bldr.append(map.get(base));
                    num -= base;
                } else if (base == 9 * power) {
                    bldr.append(map.get(base));
                    num -= base;
                } else {

                    if (base >= 5 * power) {
                        bldr.append(map.get(5 * power));
                        base -= 5 * power;
                        num -= 5 * power;
                    }
                    for (int i = 0; i < base/power; i++) {
                        bldr.append(map.get(1 * power));
                        num -= 1 * power;
                    }
                }
            }
            
        }

        return bldr.toString();
    }
}