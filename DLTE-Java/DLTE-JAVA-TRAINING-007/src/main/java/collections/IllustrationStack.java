package collections;

import java.util.Stack;

public class IllustrationStack {
    public static void main(String[] args) {
        Stack<String> stringStack=new Stack<>();
        stringStack.push("I am first");
        stringStack.push("I am Second");
        stringStack.push("I am third");
        System.out.println(stringStack);
        stringStack.pop();
        System.out.println(stringStack);

    }
}
