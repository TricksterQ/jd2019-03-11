package by.it.vashkevich.jd02_04;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private static Map<String, Integer> mapPriority = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    private int getIndexOperation(List<String> operations) {
        int priorityValue = -1;
        int index = -1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            int current = mapPriority.get(op);
            if (current > priorityValue) {
                priorityValue = current;
                index = i;
            }
        }
        return index;
    }

    private Var doOperation(String strLeft, String operation, String strRight) throws CalcException {
        Var rightVar = Var.createVar(strRight);
        if (operation.equals("=")) {
            Var.saveVar(strLeft, rightVar);
            return rightVar;
        }
        Var leftVar = Var.createVar(strLeft);
        if (leftVar == null || rightVar == null)
            throw new CalcException("неизвестная операция");
        switch (operation) {
            case "+":
                return leftVar.add(rightVar);
            case "-":
                return leftVar.sub(rightVar);
            case "*":
                return leftVar.mul(rightVar);
            case "/":
                return leftVar.div(rightVar);
            default:
                throw new CalcException("неизвестная операция");
        }
    }

    Var calc(String expression) throws CalcException {
        expression = expression.replaceAll("\\(", "").replaceAll("\\)", "");
        List<String> operations = new ArrayList<>();
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find())
            operations.add(matcher.group());
        while (operations.size() > 0) {
            int index = getIndexOperation(operations);
            String operation = operations.remove(index);
            String leftPart = operands.remove(index);
            String rightPart = operands.remove(index);
            Var doOperationResult = doOperation(leftPart, operation, rightPart);
            operands.add(index, doOperationResult.toString());
        }
        return Var.createVar(operands.get(0));
    }
}
