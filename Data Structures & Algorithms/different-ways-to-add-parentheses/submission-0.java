class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char operator = expression.charAt(i);
            if (operator != '+' && operator != '-' && operator != '*') {
                continue;
            }

            List<Integer> left = diffWaysToCompute(expression.substring(0, i));
            List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

            for (int a : left) {
                for (int b : right) {
                    if (operator == '+') {
                        results.add(a + b);
                    } else if (operator == '-') {
                        results.add(a - b);
                    } else {
                        results.add(a * b);
                    }
                }
            }
        }

        if (results.isEmpty()) {
            results.add(Integer.parseInt(expression));
        }

        return results;
    }
}