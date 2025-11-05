package P200;
import java.util.Stack;

public class Infixtopostfix 
{


    static int priority(char ch) 
    {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return 0;
    }


    static String toPostfix(String infix)
    {
        Stack<Character> stack = new Stack<>(); 
        String postfix = "";                    

        
        for (int i = 0; i < infix.length(); i++)
        {
            char c = infix.charAt(i);

            
            if (Character.isLetterOrDigit(c)) 
            {
                postfix += c;
            }

            
            else if (c == '(')
            {
                stack.push(c);
            }

            
            else if (c == ')') 
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                {
                    postfix += stack.pop();
                }
                stack.pop(); 
            }

            
            
            else {
                while (!stack.isEmpty() && priority(c) <= priority(stack.peek()))
                {
                    postfix += stack.pop(); 
                }
                stack.push(c); 
            }
        }

       
        while (!stack.isEmpty())
        {
            postfix += stack.pop();
        }

        return postfix;
    }

    public static void main(String[] args)
    {
        String infix = ("A+B/C+D*E-F/G+H*I-J");

        System.out.println("Infix Expression: " + infix);
        System.out.println("Postfix Expression: " + toPostfix(infix));
    }
}