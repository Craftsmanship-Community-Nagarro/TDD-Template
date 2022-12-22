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