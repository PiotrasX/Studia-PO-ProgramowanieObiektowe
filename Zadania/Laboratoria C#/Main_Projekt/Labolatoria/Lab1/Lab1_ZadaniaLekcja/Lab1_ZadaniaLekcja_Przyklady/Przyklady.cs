using System.Linq.Expressions;

namespace Lab1_ZadaniaLekcja_Przyklady
{
    internal class Przyklady
    {
        static void Main(string[] args)
        {
            Console.Write("Hello World!");
            Console.WriteLine(" I am learning C#");



            /* Wyświetlanie tekstu na konsoli */

            string name = "Jan";
            Console.WriteLine("Hello " + name);
            Console.WriteLine("Hello {0}", name);
            Console.WriteLine($"Hello {name}");

            // Komentowanie dużej ilości lini odbywa się za pomocą ctrl+k+c a odkomentowanie za pomocą ctrl+k+u



            /* Zmienne */
            Console.WriteLine("\n\tZmienne");

            int a = 2, b = 1, c;
            float f = 35e3F;
            double d = 3.23;
            char charValue = 'a';
            string firstName = "Ala ";
            string lastName = "Nowak";
            bool boolValue = false;

            Console.WriteLine("Wartosc int a: " + a);
            Console.WriteLine("Wartosc int b: " + b);
            Console.WriteLine("Wartosc float: " + f);
            Console.WriteLine("Wartosc double: " + d);
            Console.WriteLine("Wartosc char: " + charValue);
            Console.WriteLine("Imię i nazwisko: " + firstName + lastName);
            Console.WriteLine("Wartość bool: " + boolValue);
            Console.WriteLine("a + b = " + (a + b));
            Console.WriteLine();



            /* Rzutowanie i konwertowanie zmiennych */
            Console.WriteLine("\tRzutowanie i konwertowanie zmiennych");

            int intA = 5;
            double doubleA = intA; // Rzutowanie automatyczne
            Console.WriteLine(intA); // Outputs 5
            Console.WriteLine(doubleA); // Outputs 5

            doubleA = 9.78;
            intA = (int)doubleA; // Rzutowanie ręczne: double to int
            Console.WriteLine(doubleA); // Outputs 9.78
            Console.WriteLine(intA); // Outputs 9

            int myInt = 1;
            double myDouble = 5.14;
            bool myBool = false;
            Console.WriteLine(Convert.ToString(myInt)); // Konwertowanie int to string
            Console.WriteLine(Convert.ToDouble(myInt)); // Konwertowanie int to double
            Console.WriteLine(Convert.ToInt32(myDouble)); // Konwertowanie double to int
            Console.WriteLine(Convert.ToString(myBool)); // Konwertowanie bool to string
            Console.WriteLine();



            /* Wczytywanie danych z klawiatury */
            Console.WriteLine("\tWczytywanie danych z klawiatury");

            name = "";
            int age;
            Console.Write("Podaj imię: ");
            name = Console.ReadLine();
            Console.Write("Podaj wiek: ");
            int.TryParse(Console.ReadLine(), out age);
            Console.WriteLine("Twoje imię: " + name + ", Twój wiek: " + age + "\n");
            // Jeśli mamy pewność, że użytkownik poda faktycznie wartość int możemy zastosować następujący zapis:
            // age = Convert.ToInt32(Console.ReadLine());



            /* Operatory matematyczne */
            Console.WriteLine("\tOperatory matematyczne");

            // +, -, *, /, % (modulo), ++ (inkrementacja przyrostkowa i prefiksowa), -- (dekrementacja przyrostkowa i prefiksowa)
            a = 1; b = 2;
            Console.WriteLine("a + b = " + (a + b));
            Console.WriteLine("a - b = " + (a - b));
            Console.WriteLine("a * b = " + (a * b));
            Console.WriteLine("a / b = " + (a / b));
            Console.WriteLine("a % b = " + (a % b));
            Console.WriteLine();

            // Operator inkrementacji przyrostkowej
            int i = 3;
            Console.WriteLine(i); // Output: 3
            Console.WriteLine(i++); // Output: 3
            Console.WriteLine(i); // Output: 4
            Console.WriteLine();

            // Operator inkrementacji prefiksu
            double j = 1.5;
            Console.WriteLine(j); // Output: 1.5
            Console.WriteLine(++j); // Output: 2.5
            Console.WriteLine(j); // Output: 2.5
            Console.WriteLine();

            // Operator dekrementacji przyrostkowej
            int k = 3;
            Console.WriteLine(k); // Output: 3
            Console.WriteLine(k--); // Output: 3
            Console.WriteLine(k); // Output: 2
            Console.WriteLine();

            // Operator dekrementacji prefiksu
            double l = 1.5;
            Console.WriteLine(l); // Output: 1.5
            Console.WriteLine(--l); // Output: 0.5
            Console.WriteLine(l); // Output: 0.5
            Console.WriteLine();



            /* Inne operatowy */

            // Operatory przypisania: +=, -=, *=., /=, %=, &=, |=, ^=, >>=, <<=.
            // Operatory porównania: ==, !=, >, <, >=, <=.
            // Operatory logiczne: && (and), || (or), ! (not).



            /* Klasa Math */

            // W C# zdefiniowana jest klasa Math, która posiada wiele metod umożliwiających wykonywanie zadań matematycznych na liczbach.
            a = 5; b = 10;
            Console.WriteLine("Wartośc min z pary liczb: " + a + " i " + b + " wynosi: " + Math.Min(a, b) + "\n");



            /* String */
            Console.WriteLine("\tString");

            string str1 = "HELLO";
            string str2 = "To jest string zawierający wiele znaków";
            Console.WriteLine("str1: " + str1);
            Console.WriteLine("str2: " + str2);
            Console.WriteLine("Dlugosc str1: " + str1.Length);
            Console.WriteLine("Dlugosc str2: " + str2.Length);
            Console.WriteLine("Lower str1: " + str1.ToLower());
            Console.WriteLine("Upper str2: " + str2.ToUpper());

            firstName = "Jan";
            lastName = "Kowalski";
            Console.WriteLine(firstName + " " + lastName);
            // Metoda Concat łączy wiele stringów w jeden
            name = string.Concat(firstName, " ", lastName);
            Console.WriteLine(name);
            Console.WriteLine();



            /* Instrukcja warunkowa if */
            Console.WriteLine("\tInstrukcja warunkowa if");

            a = 2;
            if (a == 0)
            {
                Console.WriteLine("'a' równe zero");
            }
            else if (a > 0)
            {
                Console.WriteLine("'a' większe od zera");
            }
            else
            {
                Console.WriteLine("'a' mniejsze od zera");
            }

            if (false) { }
            else { }

            // Skrócony operator if else, tak zwany operator trójargumentowy
            // variable = (condition) ? expressionTrue : expressionFalse;

            // Zapis I
            int time = 20;
            if (time < 18)
                Console.WriteLine("Good day");
            else
                Console.WriteLine("Good evening");

            // Użycie operatora trójargumentowego
            string result = (time < 18) ? "Good day" : "Good evening";
            Console.WriteLine(result);

            int x = 50;
            int y = 10;
            result = (x > y) ? "wartosc x wieksza" : "wartosc y wieksza";
            Console.WriteLine(result);
            Console.WriteLine();



            /* Instrukcja wyboru switch */
            Console.WriteLine("\tInstrukcja wyboru switch");

            int switch_on = 3;
            switch (switch_on)
            {
                case 1:
                    Console.WriteLine("Case 1");
                    break;
                case 2:
                    Console.WriteLine("Case 2");
                    break;
                default:
                    Console.WriteLine("Default");
                    break;
            }



            /* Instrukcje iteracyjne */
            Console.Write("\n\tInstrukcje iteracyjne");

            Console.Write("\nPetla while: ");
            i = 0;
            while (i < 5)
            {
                Console.Write(i + " ");
                i++;
            }

            Console.Write("\nPetla do while: ");
            i = 0;
            do
            {
                Console.Write(i + " ");
                i++;
            }
            while (i < 5);

            Console.Write("\nPetla for: ");
            for (i = 0; i < 5; i++)
            {
                Console.Write(i + " ");
            }

            Console.Write("\nPetla foreach: ");
            string[] cars = { "Volvo", "BMW", "Ford", "Mazda" };
            foreach (string item in cars)
            {
                Console.Write(item + " ");
            }
            Console.WriteLine();



            /* Break i Continue */
            Console.WriteLine("\n\tBreak i Continue");

            Console.WriteLine("Break: ");
            i = 0;
            for (i = 0; i < 10; i++)
            {
                if (i == 4)
                    break;
                Console.WriteLine(i);
            }
            Console.WriteLine();
            Console.WriteLine("Continue: ");
            for (i = 0; i < 10; i++)
            {
                if (i == 4)
                    continue;
                Console.WriteLine(i);
            }



            /* Tablice */
            Console.WriteLine("\n\tTablice");

            // Deklaracja tablicy
            string[] cars1;
            // Deklaracja tablicy z inicjalizacją tablicy
            string[] cars2 = { "Volvo", "BMW", "Ford", "Mazda" };
            int[] myNum1 = { 10, 20, 30, 40 };

            // Dostęp do elementów tablicy
            Console.WriteLine("Pierwszy element tablicy: " + cars2[0]);
            // Zmiana elementow tablicy
            cars2[0] = "Opel";
            Console.WriteLine("Pierwszy element tablicy: " + cars2[0]);
            // Długość tablicy
            Console.WriteLine("Długość tablicy: " + cars2.Length);

            // Inne sposoby tworzenia tablicy
            string[] cars3 = new string[4];
            string[] cars4 = new string[4] { "Volvo", "BMW", "Ford", "Mazda" };
            string[] cars5 = new string[] { "Volvo", "BMW", "Ford", "Mazda" };
            string[] cars6 = { "Volvo", "BMW", "Ford", "Mazda" };

            // UWAGA! Jeżeli deklarujsz tablice a potem ją inicjujesz pamiętaj o użyciu operatora new
            // Deklaracja tablicy
            string[] cars7;
            // Dodanie wartości z użyciem new
            cars7 = new string[] { "Volvo", "BMW", "Ford" };
            // Dodanie wartości bez użycia new spowoduje blad
            // cars7 = { "Volvo", "BMW", "Ford"}; - błąd

            // Przeglądanie tablicy - for
            Console.Write("Tablica: ");
            for (i = 0; i < cars7.Length; i++)
                Console.Write(cars7[i] + ", ");

            // Przeglądanie tablicy - foreach
            Console.Write("\nTablica: ");
            foreach (string car in cars7)
                Console.Write(car + ", ");

            // Sortowanie tablicy

            string[] cars8 = { "Volvo", "BMW", "Ford", "Mazda" };
            Console.Write("\nPosortowana tablica: ");
            Array.Sort(cars8);
            foreach (string car in cars8)
                Console.Write(car + ", ");

            int[] myNumbers = { 5, 1, 8, 9 };
            Console.Write("\nPosortowana tablica: ");
            Array.Sort(myNumbers);
            foreach (int number in myNumbers)
                Console.Write(number + ", ");
            Console.WriteLine();



            /* Tablice wielowymiarowe */
            Console.WriteLine("\n\tTablice wielowymiarowe");

            int[,] numbers = { { 1, 4, 2 }, { 3, 6, 8 } };
            Console.WriteLine("Element numbers[0, 2]: " + numbers[0, 2]); // Outputs 2
            numbers[0, 0] = 5; // Change value to 5
            Console.WriteLine("Element numbers[0, 0]: " + numbers[0, 0]); // Outputs 5 instead of 1

            // Wypisanie elementów tablicy wielowymiarowej - foreach
            Console.Write("Tablica: ");
            foreach (int number in numbers)
                Console.Write(number + " ");

            // Wypisanie elementów tablicy wielowymiarowej - for
            Console.WriteLine();
            Console.Write("Tablica: ");
            for (int i1 = 0; i1 < numbers.GetLength(0); i1++)
            {
                for (int j1 = 0; j1 < numbers.GetLength(1); j1++)
                    Console.Write(numbers[i1, j1] + " ");
                Console.Write("\n\t ");
            }



            /* Metody */
            Console.WriteLine("\n\tMetody");

            // Wywołanie metody w głowym programie Main
            View();
            a = 1; b = 2;
            Console.WriteLine("Suma liczb " + a + " + " + b + " = " + sum(a, b));
            Console.WriteLine("Suma liczb 3 + 4 = " + sum(3, 4));

            // Przeciążanie metod
            int myNumSum1 = PlusMethod(8, 5);
            double myNumSum2 = PlusMethod(4.3, 6.26);
            Console.WriteLine("Przeciążenie dla Int: " + myNumSum1);
            Console.WriteLine("Przeciążenie dla Double: " + myNumSum2);
        }

        // Deklaracja metody wraz z ciałem metody
        static void View()
        {
            Console.WriteLine("Hello");
        }

        // Deklaracja metody wraz z ciałem metody
        static int sum(int a, int b)
        {
            return a + b;
        }

        // Przeciążąnie metody
        static int PlusMethod(int x, int y)
        {
            return x + y;
        }

        // Przeciążąnie metody
        static double PlusMethod(double x, double y)
        {
            return x + y;
        }
    }
}
