namespace Lab4_Zad1
{
    internal class Zadanie1
    {
        static void Main(string[] args)
        {
            List<Shape> shapes = new List<Shape>
            {   new Shape(1, 2, 3, 5),
                new Rectangle(5, 4, 3, 1),
                new Triangle(1, 3, 3, 7),
                new Circle(9, 8, 7, 5)      };

            foreach (Shape shape in shapes)
                shape.DrawOverride();

            Console.WriteLine();
            foreach (Shape shape in shapes)
                shape.DrawNew();
        }
    }

    internal class Shape
    {
        private int x;
        private int y;
        private int height;
        private int width;

        public int X
        {
            get { return x; }
            set { x = value; if (value < 0) x = 0; }
        }
        public int Y
        {
            get { return y; }
            set { y = value; if (value < 0) y = 0; }
        }
        public int Height
        {
            get { return height; }
            set { height = value; if (value < 0) height = 0; }
        }
        public int Width
        {
            get { return width; }
            set { width = value; if (value < 0) width = 0; }
        }

        public Shape() { }
        public Shape(int x, int y, int height, int width)
        {
            X = x;
            Y = y;
            Height = height;
            Width = width;
        }

        public virtual void DrawOverride()
        {
            Console.WriteLine("Shape");
        }
        public virtual void DrawNew()
        {
            Console.WriteLine("Shape");
        }
    }

    internal class Rectangle : Shape
    {
        public Rectangle() : base() { }
        public Rectangle(int x, int y, int height, int width) : base(x, y, height, width) { }

        public override void DrawOverride() 
        {
            Console.WriteLine("Rectangle");
        }
        public new void DrawNew()
        {
            Console.WriteLine("Rectangle");
        }
    }

    internal class Triangle : Shape
    {
        public Triangle() : base() { }
        public Triangle(int x, int y, int height, int width) : base(x, y, height, width) { }

        public override void DrawOverride()
        {
            Console.WriteLine("Triangle");
        }
        public new void DrawNew()
        {
            Console.WriteLine("Triangle");
        }
    }

    internal class Circle : Shape
    {
        public Circle() : base() { }
        public Circle(int x, int y, int height, int width) : base(x, y, height, width) { }

        public override void DrawOverride()
        {
            Console.WriteLine("Circle");
        }
        public new void DrawNew()
        {
            Console.WriteLine("Circle");
        }
    }
}
