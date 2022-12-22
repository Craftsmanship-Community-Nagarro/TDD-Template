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

    [Fact]
    public void RockShouldDrawRock()
    {
        int result = rpsCalc.CalculateOutcome('A', 'X');

        result.Should().Be(4);
    }

    [Fact]
    public void PaperShouldDrawPaper()
    {
        int result = rpsCalc.CalculateOutcome('B', 'Y');

        result.Should().Be(5);
    }
}