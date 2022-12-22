using System.Diagnostics;

internal class Program
{
    public static void Main(string[] args)
    {
        AsyncCallDemo();
    }

    private static void AsyncCallDemo()
    {
        Console.WriteLine("Prepare my breakfast (press key to cancel or close)!");

        PrepareBreakfast();

        Console.WriteLine("Breakfast is ready");

        Console.ReadKey();
    }

    private static void PrepareBreakfast()
    {
        Stopwatch sw = Stopwatch.StartNew();
        sw.Start();

        PrepareFood("Coffee");
        PrepareFood("Ham and Eggs");
        PrepareFood("Tea");

        sw.Stop();
        Console.WriteLine("Done in " + sw.ElapsedMilliseconds + " ms");
    }

    private static void PrepareFood(string food)
    {
        Console.WriteLine("   start preparing " + food + " ...");
        Thread.Sleep(2000);
        Console.WriteLine("   end preparing " + food + " ...");
    }
}
