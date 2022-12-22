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
        private const int DRAW_SCORE = 3;
        private const int WIN_SCORE = 6;

        public static int Score(this Shape myShape, Shape opponentShape)
        {
            if (myShape.IsDraw(opponentShape))
            {
                return DRAW_SCORE + (int)myShape;
            }
            if (myShape.IsLoose(opponentShape))
            {
                return (int)myShape;
            }

            return WIN_SCORE + (int)myShape;
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
}