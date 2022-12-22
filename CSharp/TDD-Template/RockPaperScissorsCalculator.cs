namespace TDD_Template
{
    public class RockPaperScissorsCalculator
    {
        public int CalculateOutcome(string inputOpponent, string inputMyself)
        {
            if (inputOpponent[0] == 'A' && inputMyself[0] == 'X')
            {
                return 4;
            }
            return 8;
        }
    }
}