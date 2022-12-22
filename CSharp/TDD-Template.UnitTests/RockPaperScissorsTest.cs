namespace TDD_Template.UnitTests;

public class RockPaperScissorsTest
{
    private RockPaperScissorsCalculator rpsCalc = new RockPaperScissorsCalculator();

    [Theory]
    [InlineData('A', 'Y', 8)]
    [InlineData('B', 'Z', 9)]
    [InlineData('C', 'X', 7)]
    public void MyShapeShouldWin(char opponentMove, char myMove, int expectedResult)
    {
        int result = rpsCalc.CalculateOutcome(opponentMove, myMove);

        result.Should().Be(expectedResult);
    }

    [Theory]
    [InlineData('A','X', 4)]
    [InlineData('B','Y', 5)]
    [InlineData('C','Z', 6)]
    public void SameShapesShouldResultInDraw(char opponentMove, char myMove, int expectedResult)
    {
        int result = rpsCalc.CalculateOutcome(opponentMove, myMove);

        result.Should().Be(expectedResult);
    }
}