package P400;
import java.util.Scanner;

public class Queue4
{
    private int front, rear, size;
    private int[] queue;

    public Queue4(int capacity)
    {
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value)
    {
        if (isFull())
        {
            System.out.println("Queue is full!");
            return;
        }

        if (front == -1)
            front = 0;

        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;

        System.out.println(value + " added to queue.");
    }

    public int dequeue()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty!");
            return -1;
        }

        int value = queue[front];
        System.out.println(value + " removed from queue.");

        if (front == rear) 
        {
            front = -1;
            rear = -1;
        } else
        {
            front = (front + 1) % queue.length;
        }

        size--;
        return value;
    }

    public int peek()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queue[front];
    }

    public boolean isEmpty()
    {
        return (front == -1);
    }

    public boolean isFull()
    {
        return (front == (rear + 1) % queue.length);
    }

    // Optional: Display queue elements
    public void display()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        int i = front;
        while (true)
        {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % queue.length;
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue capacity: ");
        int capacity = sc.nextInt();

        Queue4 q = new Queue4(capacity);

        int choice;
        do {
            System.out.println("\n--- Queue Menu ---");
            System.out.println("1. Enqueue (Add)");
            System.out.println("2. Dequeue (Remove)");
            System.out.println("3. Peek (Front element)");
            System.out.println("4. Display Queue");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("Enter value to add: ");
                    int value = sc.nextInt();
                    q.enqueue(value);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    System.out.println("Front element: " + q.peek());
                    break;
                case 4:
                    q.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}