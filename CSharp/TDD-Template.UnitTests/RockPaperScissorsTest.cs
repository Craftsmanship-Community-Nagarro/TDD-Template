namespace TDD_Template.UnitTests;

public class RockPaperScissorsTest
{
    [Fact]
    public void PaperShouldDefeatRock()
    {
        var rpsCalc = new RockPaperScissorsCalculator();
        int result = rpsCalc.CalculateOutcome("A", "Y");

        result.Should().Be(8);
    }

    [Fact]
    public void RockShouldDrawRock()
    {
        var rpsCalc = new RockPaperScissorsCalculator();
        int result = rpsCalc.CalculateOutcome("A", "X");

        result.Should().Be(4);
    }
}