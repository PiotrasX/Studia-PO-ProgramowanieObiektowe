using System.Collections;
using System.Collections.Generic;

namespace Lab5_Zad6
{
    internal class Zadanie6
    {
        static void Main(string[] args)
        {
            var list = new MyList<int>();
            list.Add(13);
            list.Add(25);
            list.Add(37);
            list.Print();

            list.Insert(1, 17);
            list.Insert(3, 1);
            list.Print();

            list.Remove(0);
            list.Remove(1);
            list.Print();

            list.RemoveAt(2);
            list.Print();
        }
    }

    internal class MyList<T>
    {
        private class Node
        {
            public T value { get; set; }
            public Node next;
        }

        private Node first = null;
        private Node last = null;

        private Node Get(int i)
        {
            var e = first;
            while (i-- > 0 && e != null)
                e = e.next;
            if (e == null)
                throw new IndexOutOfRangeException();
            return e;
        }

        public void Add(T element)
        {
            if (first == null)
                first = last = new Node() { value = element };
            else
                last = last.next = new Node() { value = element };
        }

        public void Insert(int i, T element)
        {
            if (i == 0)
            {
                var newNode = new Node() { value = element, next = first };
                first = newNode;
                if (last == null)
                    last = first;
                return;
            }

            var current = first;
            for (int index = 0; index < i - 1; index++)
            {
                if (current == null)
                    throw new IndexOutOfRangeException();
                current = current.next;
            }

            var newNewNode = new Node() { value = element, next = current.next };
            current.next = newNewNode;

            if (current == last)
                last = newNewNode;
        }

        public bool Remove(T element)
        {
            Node previous = null;
            var current = first;

            while (current != null)
            {
                if (current.value.Equals(element))
                {
                    if (previous == null)
                        first = current.next;
                    else
                        previous.next = current.next;

                    if (current == last)
                        last = previous;

                    return true;
                }

                previous = current;
                current = current.next;
            }

            return false;
        }

        public bool RemoveAt(int i)
        {
            if (i == 0 && first != null)
            {
                first = first.next;
                if (first == null)
                    last = null;
                return true;
            }

            var current = first;
            for (int index = 0; index < i - 1; index++)
            {
                if (current == null)
                    return false;
                current = current.next;
            }

            if (current != null && current.next != null)
            {
                current.next = current.next.next;

                if (current.next == null)
                    last = current;

                return true;
            }

            return false;
        }

        public T this[int i] 
        { 
            get => Get(i).value; 
            set => Get(i).value = value; 
        }

        public int Count 
        { 
            get
            {
                int count = 0;
                var current = first;
                while (current != null)
                {
                    count++;
                    current = current.next;
                }
                return count;
            }
        }

        public void Print()
        {
            Console.WriteLine("Elementów na liście: " + this.Count);
            Console.Write("Elementy na liście: | ");
            for (int i = 0; i < this.Count; i++)
                Console.Write(this[i] + " | ");
            Console.WriteLine("\n");
        }
    }
}
