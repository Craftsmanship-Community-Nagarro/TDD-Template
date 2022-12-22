namespace TDD_Template
{
    public enum Shape 
    {
        Rock = 1,
        Paper = 2,
        Scissor = 3
    }

    public static class ShapeExtensions
    {
        public static bool IsDraw(this Shape myShape, Shape opponentShape)
        {
            return opponentShape == myShape;
        }

        public static bool IsLoose(this Shape myShape, Shape opponentShape)
        {
            return myShape == Shape.Scissor && opponentShape == Shape.Rock
                            || myShape == Shape.Rock && opponentShape == Shape.Paper
                            || myShape == Shape.Paper && opponentShape == Shape.Scissor;
        }
    }
}