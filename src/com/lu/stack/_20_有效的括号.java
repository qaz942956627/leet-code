package com.lu.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author 小卢
 */
public class _20_有效的括号 {

    private static HashMap<Character, Character> match = new HashMap<>();

    static  {
        match.put('(', ')');
        match.put('[', ']');
        match.put('{', '}');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (match.containsKey(aChar)) {
                stack.push(aChar);
            }else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character lift = stack.pop();
                    Character right = match.get(lift);
                    if (aChar!=right) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }


    private boolean isLift(char aChar) {
        if (aChar == '(' || aChar == '[' || aChar == '{') {
            return true;
        }
        return false;
    }

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (isLift(aChar)) {
                stack.push(aChar);
            }else {
                if (stack.size() == 0) {
                    return false;
                } else {
                    Character pop = stack.pop();
                    if (!match(pop, aChar)) {
                        return false;
                    }
                }
            }
        }
        if (stack.size()==0) {
            return true;
        }else  {
            return false;
        }
    }

    private boolean match(Character left,Character right) {
        if (left == '(' && right == ')') {
            return true;
        } else if (left == '[' && right == ']') {
            return true;
        } else if (left == '{' && right == '}') {
            return true;
        } else {
            return false;
        }
    }
}
