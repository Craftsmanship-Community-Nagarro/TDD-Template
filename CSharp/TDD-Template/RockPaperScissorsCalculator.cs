namespace TDD_Template
{
    public class RockPaperScissorsCalculator
    {
        public int CalculateScore(char opponent, char myself)
        {
            var myShape = CreateShape(myself);
            var opponentShape = CreateShape(opponent);

            return myShape.Score(opponentShape);
        }

        private static Shape CreateShape(char input)
        {
            return input switch
            {
                'X' => Shape.Rock,
                'A' => Shape.Rock,
                'Y' => Shape.Paper,
                'B' => Shape.Paper,
                'Z' => Shape.Scissor,
                'C' => Shape.Scissor,
                _ => throw new ArgumentException($"No valid {nameof(input)}: {input}")
            };
        }
    }
}