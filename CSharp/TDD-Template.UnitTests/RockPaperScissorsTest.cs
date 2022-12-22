namespace TDD_Template.UnitTests;

public class RockPaperScissorsTest
{
    private RockPaperScissorsCalculator rpsCalc = new RockPaperScissorsCalculator();

    [Fact]
    public void PaperShouldDefeatRock()
    {
        int result = rpsCalc.CalculateOutcome('A','Y');

        result.Should().Be(8);
    }

    [Theory]
    [InlineData('B','Y', 5)]
    [InlineData('A','X', 4)]
    public void SameShapesShouldResultInDraw(char opponentMove, char myMove, int expectedResult)
    {
        int result = rpsCalc.CalculateOutcome(opponentMove, myMove);

        result.Should().Be(expectedResult);
    }
}