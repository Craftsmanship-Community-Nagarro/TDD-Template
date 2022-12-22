
namespace TDD_Template.UnitTests;

public class RockPaperScissorsTest
{
    [Fact]
    public void PaperShouldDefeatRock()
    {
        RockPaperScissorsCalculator rpsCalc = new RockPaperScissorsCalculator();
        int result = rpsCalc.CalculateOutcome("A", "Y");

        result.Should().Be(8);
    }

}