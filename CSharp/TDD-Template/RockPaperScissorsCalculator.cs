namespace TDD_Template
{
    public class RockPaperScissorsCalculator
    {
        private const int DRAW_SCORE = 3;
        private const int WIN_SCORE = 6;

        public int CalculateOutcome(char opponent, char myself)
        {
            Shape myShape = CreateShape(myself);
            if (IsDraw(opponent, myself))
            {
                return DRAW_SCORE + (int)myShape;
            }
            return WIN_SCORE + (int) myShape;
        }

        private static Shape CreateShape(char myself)
        {
            Shape shape = 0;
            switch (myself)
            {
                case 'X':
                    shape = Shape.Rock;
                    break;
                case 'Y':
                    shape = Shape.Paper;
                    break;
                case 'Z':
                    shape = Shape.Scissor;
                    break;
            }

            return shape;
        }

        private bool IsDraw(char opponent, char myself)
        {
            return opponent == 'A' && myself == 'X' 
                || opponent == 'B' && myself == 'Y'
                || opponent == 'C' && myself == 'Z';
        }
    }

    public enum Shape
    {
        Rock = 1,
        Paper = 2,
        Scissor = 3
    }
}