namespace Lab5_Zad3
{
    internal class Zadanie3
    {
        static void Main(string[] args)
        {
            SomeClass someClassObj = new SomeClass();
            try
            {
                someClassObj.CanThrowException();
                someClassObj.CanThrowException();
                someClassObj.CanThrowException();
                someClassObj.CanThrowException();
                someClassObj.CanThrowException();
            }
            catch (Exception e)
            {
                string tekst = e.StackTrace;
                int startIndex = tekst.LastIndexOf(".cs:line");
                Console.WriteLine("Linijka gdzie nastąpił wyjątek: " + tekst.Substring(startIndex + 9));
            }
        }
    }

    internal class SomeClass
    {
        public void CanThrowException()
        {
            if (new Random().Next(5) == 0)
                throw new Exception();
        }
    }
}
