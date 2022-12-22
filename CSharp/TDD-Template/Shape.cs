namespace TDD_Template;

public enum Shape 
{
    Rock = 1,
    Paper = 2,
    Scissor = 3
}

public static class ShapeExtensions
{
    private const int DrawScore = 3;
    private const int WinScore = 6;

    public static int Score(this Shape myShape, Shape opponentShape)
    {
        if (myShape.IsDraw(opponentShape))
        {
            return DrawScore + (int)myShape;
        }
        if (myShape.IsLoose(opponentShape))
        {
            return (int)myShape;
        }

        return WinScore + (int)myShape;
    }

    private static bool IsDraw(this Shape myShape, Shape opponentShape)
    {
        return opponentShape == myShape;
    }

    private static bool IsLoose(this Shape myShape, Shape opponentShape)
    {
        return myShape == Shape.Scissor && opponentShape == Shape.Rock
               || myShape == Shape.Rock && opponentShape == Shape.Paper
               || myShape == Shape.Paper && opponentShape == Shape.Scissor;
    }

}