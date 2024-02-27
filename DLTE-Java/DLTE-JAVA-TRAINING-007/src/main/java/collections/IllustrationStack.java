package collections;

import java.util.Stack;

public class IllustrationStack {
    public static void main(String[] args) {
        Stack<String> stringStack=new Stack<>();
        stringStack.push("Hello");
        stringStack.push("how are you");
        System.out.println(stringStack);
        stringStack.pop();
        System.out.println(stringStack);

    }
}
