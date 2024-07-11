namespace Lab4_ZadaniaLekcja_Przyklad1
{
    internal class Przyklad1
    {
        static void Main(string[] args)
        {
            Dog dog = new Dog();
            Cat cat = new Cat();
            Pig pig = new Pig();

            dog.AnimalSound();
            cat.AnimalSound();
            pig.AnimalSound();

            Console.WriteLine();

            dog.AnimalType();
            cat.AnimalType();
            pig.AnimalType();
        }
    }

    /* Polimorfizm dynamiczny - abstract, override, virtual, new */

    internal abstract class Animal
    {
        public abstract void AnimalSound();
        public virtual void AnimalType()
        {
            Console.WriteLine("Typ: zwierze");
        }
    }

    internal class Dog : Animal
    {
        public override void AnimalSound() // Nadpisana metoda
        {
            Console.WriteLine("Pies robi: Hau! Hau!");
        }
        public new void AnimalType() // Przysłonięta metoda
        {
            Console.WriteLine("Typ: Pies");
        }
    }

    internal class Cat : Animal
    {
        public override void AnimalSound()
        {
            Console.WriteLine("Kot robi: Meow! Meow!");
        }
        public new void AnimalType()
        {
            Console.WriteLine("Typ: Kot");
        }
    }

    internal class Pig : Animal
    {
        public override void AnimalSound()
        {
            Console.WriteLine("Świnia robi: Wee! Wee!");
        }
        public new void AnimalType()
        {
            Console.WriteLine("Typ: Świnia");
        }
    }
}
