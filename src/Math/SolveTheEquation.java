package Math;

//题目描述:给定一个字符串，表示一个线性方程，求解该方程，例如"x+5-3+x=6+x-2"，返回"x=2"
//解法描述:找到x的系数和常数项，然后求解

public class SolveTheEquation {

    // 算出x的系数和常数项
    private int[] evaluateExpression(String exp) {
        String[] tokens = exp.split("(?=[-+])");
        int[] result = new int[2];
        for (final String token : tokens) {
            if (token.equals("+x") || token.equals("x")) {
                ++result[0];
            } else if (token.equals("-x")) {
                --result[0];
            } else if (token.contains("x")) {
                result[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
            } else {
                result[1] += Integer.parseInt(token);
            }
        }

        return result;
    }

    public String solveEquation(String equation) {
        int[] expression1 = evaluateExpression(equation.split("=")[0]);
        int[] expression2 = evaluateExpression(equation.split("=")[1]);

        expression1[0] -= expression2[0];
        expression1[1] = expression2[1] - expression1[1];

        if (expression1[0] == 0 && expression1[1] == 0) {
            return "Infinite solutions";
        }

        if (expression1[0] == 0) {
            return "No solution";
        }

        return "x=" + expression1[1] / expression1[0];
    }

}
