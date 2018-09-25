package com.soft.stack;

public class Main {

    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);


        Solution solution = new Solution();
        String s = "({[]})";
        boolean isValid = solution.isValid(s);
        System.out.println(s+" is a valid string ? "+isValid);
    }
}
