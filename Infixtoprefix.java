package P300;
import java.util.*;

public class Infixtoprefix 
{
    
  
    static int precedence(char ch)
    {
        switch (ch)
        {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    static String infixToPostfix(String infix) 
    {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < infix.length(); i++)
        {
            char c = infix.charAt(i);

          
            if (c == ' ') continue;

            
            if (Character.isLetterOrDigit(c))
            {
                result.append(c);
            }
            
            else if (c == '(') 
            {
                stack.push(c);
            }
          
            else if (c == ')') 
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                {
                    result.append(stack.pop());
                }
                stack.pop(); 
            }

            else 
            {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek()))
                {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
      
        while (!stack.isEmpty()) result.append(stack.pop());
        return result.toString();
    }

    
    static String infixToPrefix(String infix)
    {
       
        StringBuilder rev = new StringBuilder(infix).reverse();
        String reversed = rev.toString();

        char[] chars = reversed.toCharArray();
        for (int i = 0; i < chars.length; i++) 
        {
            if (chars[i] == '(') chars[i] = ')';
            else if (chars[i] == ')') chars[i] = '(';
        }

    
        String postfix = infixToPostfix(new String(chars));

    
        return new StringBuilder(postfix).reverse().toString();
    }

    public static void main(String[] args)
    {
        String infix = ("A+B/C+D*E-F/G+H*I-J");
        System.out.println("Infix: " + infix);

        String postfix = infixToPostfix(infix);
        System.out.println("Postfix: " + postfix);

        String prefix = infixToPrefix(infix);
        System.out.println("Prefix: " + prefix);
    }
}