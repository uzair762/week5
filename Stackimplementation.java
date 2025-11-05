package p100;
import java.util.Scanner;

public class Stackimplementation
{
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stackimplementation(int size) 
    {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value)
    {
        if (top == maxSize - 1)
        {
            System.out.println("Stack is full!");
        } else
        {
            stackArray[++top] = value;
            System.out.println(value + " pushed into stack.");
        }
    }

    public int pop()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty!");
            return -1;
        } else
        {
            int value = stackArray[top--];
            System.out.println(value + " popped from stack.");
            return value;
        }
    }

    public int peek()
    {
        if (isEmpty()) 
        {
            System.out.println("Stack is empty!");
            return -1;
        } else 
        {
            return stackArray[top];
        }
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter size of stack: ");
        int size = input.nextInt();

        Stackimplementation stack = new Stackimplementation(size);

        while (true) 
        {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if Empty");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = input.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = input.nextInt();
                    stack.push(value);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    System.out.println("Top element: " + stack.peek());
                    break;

                case 4:
                    System.out.println("Is stack empty? " + stack.isEmpty());
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}