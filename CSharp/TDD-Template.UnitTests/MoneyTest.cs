
namespace TDD_Template.UnitTests;

public class MoneyTest
{
    [Fact]
    public void Multiply()
    {
        var dollarInput = new Money() { Amount = 5.0m, Currency = "USD" };
        dollarInput.Multiply(2).Should().Be(new Money() { Amount = 10.0m, Currency = "USD" });
    }

    [Fact]
    public void Divide()
    {
        var dollarInput = new Money() { Amount = 4002m, Currency = "KRW" };
        dollarInput.Divide(4).Should().Be(new Money() { Amount = 1000.5m, Currency = "KRW" });
    }

    [Fact]
    public void AddWithSameCurrency()
    {
        var moneyInput = new Money() { Amount = 4002m, Currency = "KRW" };
        var moneyResult = moneyInput.Add(new Money() { Amount = 100m, Currency = "KRW" });
        moneyResult.Should().Be(new Money() { Amount = 4102m, Currency = "KRW" });
    }

    [Fact]
    public void AddWithNull()
    {
        var moneyInput = new Money() { Amount = 4002m, Currency = "KRW" };
        var moneyResult = moneyInput.Add(null!);
        moneyResult.Should().Be(new Money() { Amount = 4002m, Currency = "KRW" });
    }

    [Fact]
    public void AddWithDifferentCurrency()
    {
        var moneyInput = new Money() { Amount = 5m, Currency = "USD" };
        var moneyResult = moneyInput.Add(new Money() { Amount = 10m, Currency = "EUR" });
        moneyResult.Should().Be(new Money() { Amount = 17m, Currency = "USD" });
    }

    [Fact]
    public void AddWithAnotherDifferentCurrency()
    {        
        var moneyInput = new Money() { Amount = 1100m, Currency = "KRW" };
        var moneyResult = moneyInput.Add(new Money() { Amount = 1m, Currency = "USD" });
        moneyResult.Should().Be(new Money() { Amount = 2200, Currency = "KRW" });
    }
}