namespace TDD_Template
{
    public class RockPaperScissorsCalculator
    {
        private const int DRAW_SCORE = 3;

        public int CalculateOutcome(char opponent, char myself)
        {
            if (IsDraw(opponent, myself))
            {
                if (myself == 'X')
                    return DRAW_SCORE + 1;
                if (myself == 'Y')
                    return DRAW_SCORE + 2;
                if (myself == 'Z')
                    return DRAW_SCORE + 3;

            }
            return 8;
        }

        private bool IsDraw(char opponent, char myself)
        {
            return opponent == 'A' && myself == 'X' 
                || opponent == 'B' && myself == 'Y'
                || opponent == 'C' && myself == 'Z';
        }
    }
}