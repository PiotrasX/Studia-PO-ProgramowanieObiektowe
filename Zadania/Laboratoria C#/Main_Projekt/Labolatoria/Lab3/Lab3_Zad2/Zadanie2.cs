namespace Lab3_Zad2
{
    internal class Zadanie2
    {
        static void Main(string[] args)
        {
            Samochod samochod1 = new Samochod(Marka.Audi, "R8", Nadwozie.Sedan, Kolor.Czerwony, 2024, 19560);
            Samochod samochod2 = new SamochodOsobowy(Marka.BMW, "HT", Nadwozie.Couple, Kolor.Szary, 2021, 9564);
            SamochodOsobowy samochod3 = new SamochodOsobowy(Marka.Honda, "Accord", Nadwozie.Sedan, Kolor.Zielony, 2005, 235560, 2.3M, 2.0M, 5);

            samochod1.InfoNew();
            samochod2.InfoNew();
            samochod3.InfoNew();

            Console.WriteLine();
            samochod1.InfoOverride();
            samochod2.InfoOverride();
            samochod3.InfoOverride();
        }
    }

    public enum Marka
    {
        BMW, Volvo, Mazda, Honda, Toyota, Ford, Volkswagen, Mercedes_Benz, Chevrolet, Audi, Nissan, Hyundai, Kia, Tesla, Renault, Porsche, Lexus
    }

    public enum Nadwozie
    {
        Sedan, Hatchback, Kombi, Couple, Cabrio, SUV, Crossover, Minivan, Pickup, Roadster, Limuzyna, Mikrovan, Van
    }

    public enum Kolor
    { 
        Czerwony, Niebieski, Zielony, Czarny, Biały, Szary, Żółty, Różowy, Pomarańczowy, Fioletowy, Brązowy, Beżowy, Turkusowy, Srebrny, Złoty, Purpurowy
    }

    internal class Samochod
    {
        private Marka marka;
        private string model;
        private Nadwozie nadwozie;
        private Kolor kolor;
        private int rokProdukcji;
        private int przebieg;

        public Samochod(Marka marka, string model, Nadwozie nadwozie, Kolor kolor, int rokProdukcji, int przebieg)
        {
            Marka = marka;
            Model = model;
            Nadwozie = nadwozie;
            Kolor = kolor;
            RokProdukcji = rokProdukcji;
            Przebieg = przebieg;
        }

        public Marka Marka 
        { 
            get => marka; 
            set => marka = value; 
        }
        public string Model 
        { 
            get => model;
            set
            {
                model = value;
                if (value == null || value.Equals("")) model = "N_A";
            } 
        }
        public Nadwozie Nadwozie 
        { 
            get => nadwozie; 
            set => nadwozie = value; 
        }
        public Kolor Kolor 
        { 
            get => kolor; 
            set => kolor = value; 
        }
        public int RokProdukcji 
        { 
            get => rokProdukcji; 
            set
            {
                rokProdukcji = value;
                if (value < 1970) rokProdukcji = 1970;
                if (value > DateTime.Now.Year) rokProdukcji = DateTime.Now.Year;
            }
        }
        public int Przebieg 
        { 
            get => przebieg; 
            set
            {
                przebieg = value;
                if (value < 0) przebieg = 0;
            }
        }

        public virtual void InfoNew()
        {
            Console.WriteLine($"Samochód; Marka: {Marka}; Model: {Model}; Nadwozie: {Nadwozie}; Kolor: {Kolor}; Rok produkcji: {RokProdukcji}; Przebieg: {Przebieg};");
        }
        public virtual void InfoOverride()
        {
            Console.WriteLine($"Samochód; Marka: {Marka}; Model: {Model}; Nadwozie: {Nadwozie}; Kolor: {Kolor}; Rok produkcji: {RokProdukcji}; Przebieg: {Przebieg};");
        }
    }

    internal class SamochodOsobowy : Samochod
    {
        private decimal waga;
        private decimal pojemnoscSilnika;
        private int iloscMiejsc;

        public SamochodOsobowy(Marka marka, string model, Nadwozie nadwozie, Kolor kolor, int rokProdukcji, int przebieg) : base(marka, model, nadwozie, kolor, rokProdukcji, przebieg) { }
        public SamochodOsobowy(Marka marka, string model, Nadwozie nadwozie, Kolor kolor, int rokProdukcji, int przebieg, decimal waga, decimal pojemnoscSilnika, int iloscMiejsc) : base(marka, model, nadwozie, kolor, rokProdukcji, przebieg)
        {
            Waga = waga;
            PojemnoscSilnika = pojemnoscSilnika;
            IloscMiejsc = iloscMiejsc;
        }

        public decimal Waga 
        { 
            get => waga;
            set
            {
                waga = value;
                if (value < 2M) waga = 2M;
                if (value > 4.5M) waga = 4.5M;
            }
        }
        public decimal PojemnoscSilnika 
        { 
            get => pojemnoscSilnika; 
            set
            {
                pojemnoscSilnika = value;
                if (value < 0.8M) pojemnoscSilnika = 0.8M;
                if (value > 3.0M) pojemnoscSilnika = 3.0M;
            }
        }
        public int IloscMiejsc 
        { 
            get => iloscMiejsc; 
            set
            {
                iloscMiejsc = value;
                if (value < 0) iloscMiejsc = 0;
            }
        }

        public new void InfoNew()
        {
            Console.WriteLine($"Samochód osobowy; Marka: {Marka}; Model: {Model}; Nadwozie: {Nadwozie}; Kolor: {Kolor}; Rok produkcji: {RokProdukcji}; Przebieg: {Przebieg}; Waga: {Waga}; Pojemność silnika: {PojemnoscSilnika}; Ilość miejsc: {iloscMiejsc};");
        }
        public override void InfoOverride()
        {
            Console.WriteLine($"Samochód osobowy; Marka: {Marka}; Model: {Model}; Nadwozie: {Nadwozie}; Kolor: {Kolor}; Rok produkcji: {RokProdukcji}; Przebieg: {Przebieg}; Waga: {Waga}; Pojemność silnika: {PojemnoscSilnika}; Ilość miejsc: {iloscMiejsc};");
        }
    }
}
