
namespace TDD_Template.UnitTests;

public class UnitTest1
{
    [Fact]
    public void MultiplyDollars()
    {
        var dollarInput = new Money() { Amount = 5.0m, Currency = "USD" };
        dollarInput.Multiply(2).Should().Be(new Money() { Amount = 10m, Currency = "USD" });
    }
}