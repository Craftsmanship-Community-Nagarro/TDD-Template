using System.Diagnostics;

internal class AsyncExamples
{
    private static async Task PrepareBreakfastAsync()
    {
        Stopwatch sw = Stopwatch.StartNew();
        sw.Start();

        var foodPreparation = new List<Task> {
            PrepareFoodAsync("Coffee"),
            PrepareFoodAsync("Ham and Eggs"),
            PrepareFoodAsync("Tea")
        };

        await Task.WhenAll(foodPreparation);

        sw.Stop();
        Console.WriteLine("Done in " + sw.ElapsedMilliseconds + " ms");
    }

    private static async Task PrepareBreakfastAsync1()
    {
        Stopwatch sw = Stopwatch.StartNew();
        sw.Start();

        await PrepareFoodAsync("Coffee");
        await PrepareFoodAsync("Ham and Eggs");
        await PrepareFoodAsync("Tea");

        sw.Stop();
        Console.WriteLine("Done in " + sw.ElapsedMilliseconds + " ms");
    }

    private static async Task PrepareFoodAsync(string food)
    {
        await Task.Run(() =>
        {
            Console.WriteLine("   start preparing " + food + " ...");
            Thread.Sleep(2000);
            Console.WriteLine("   end preparing " + food + " ...");
        });
        Console.WriteLine("   " + food + " done");
    }
}
