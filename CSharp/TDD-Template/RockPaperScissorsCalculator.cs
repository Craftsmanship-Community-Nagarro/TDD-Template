namespace TDD_Template
{
    public class RockPaperScissorsCalculator
    {
        private const int DRAW_SCORE = 3;
        private const int WIN_SCORE = 6;

        public int CalculateScore(char opponent, char myself)
        {
            var myShape = CreateShape(myself);
            var opponentShape = CreateShape(opponent);

            if (IsDraw(opponentShape, myShape))
            {
                return DRAW_SCORE + (int)myShape;
            }
            if (OpponentWins(opponentShape, myShape))
            {
                return (int)myShape;
            }

            return WIN_SCORE + (int)myShape;
        }

        private static bool OpponentWins(Shape opponentShape, Shape myShape)
        {
            return myShape == Shape.Scissor && opponentShape == Shape.Rock
                            || myShape == Shape.Rock && opponentShape == Shape.Paper
                            || myShape == Shape.Paper && opponentShape == Shape.Scissor;
        }

        private static bool IsDraw(Shape opponentShape, Shape myShape)
        {
            return opponentShape == myShape;
        }

        private static Shape CreateShape(char input)
        {
            Shape shape = input switch
            {
                'X' => Shape.Rock,
                'A' => Shape.Rock,
                'Y' => Shape.Paper,
                'B' => Shape.Paper,
                'Z' => Shape.Scissor,
                'C' => Shape.Scissor,
                _ => 0
            };

            return shape;
        }
    }
}