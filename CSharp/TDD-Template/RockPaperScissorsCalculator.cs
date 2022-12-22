namespace TDD_Template
{
    public class RockPaperScissorsCalculator
    {
        public int CalculateOutcome(char opponent, char myself)
        {
            if (IsDraw(opponent, myself))
            {
                if (myself == 'X')
                    return 4;
                if (myself == 'Y')
                    return 5;

            }
            return 8;
        }

        private bool IsDraw(char opponent, char myself)
        {
            return opponent == 'A' && myself == 'X' || opponent == 'B' && myself == 'Y';
        }
    }
}