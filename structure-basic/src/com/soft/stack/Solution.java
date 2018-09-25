package com.soft.stack;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c=='('||c=='{'||c=='['){
                stack.push(c);
            }else {
                if (stack.empty()){
                    return false;
                }
                Character popCharacter = stack.pop();
                if (c==')' && popCharacter!='('){
                    return false;
                }else if (c=='}' && popCharacter!='{'){
                    return false;
                }else if (c==']' && popCharacter!='['){
                    return false;
                }
            }
        }
        return stack.isEmpty() && s.length()>0;
    }
}
