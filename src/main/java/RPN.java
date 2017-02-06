import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Author: timofeevdv
 * Date: 06.02.2017
 */
public class RPN {
    private static Stack<Character> stack;
    private static Map<Character, Integer> operators;

    static {
        stack = new Stack<>();
        operators = new HashMap<>();
        operators.put('(', 1);
        operators.put(')', 1);
        operators.put('+', 2);
        operators.put('-', 2);
        operators.put('*', 3);
        operators.put('/', 3);
    }

    public static String make(String expression) {
        StringBuilder result = new StringBuilder();
        for (Character c : expression.toCharArray()) {
            // Скобки
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (c == ')') {
                while (stack.size() > 0) {
                    Character op = stack.pop();
                    if (op != '(') {
                        result.append(op);
                    }
                }
                continue;
            }
            // Операнды
            if (operators.get(c) == null) {
                result.append(c);
                continue;
            }

            while (stack.size() > 0 && operators.get(stack.peek()) >= operators.get(c)) {
                result.append(stack.pop());
            }
            stack.push(c);
        }
        while (stack.size() > 0) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
