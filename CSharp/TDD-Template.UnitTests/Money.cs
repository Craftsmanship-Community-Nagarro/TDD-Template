namespace TDD_Template.UnitTests
{
    internal record Money
    {        
        public decimal Amount { get; init; }
        public string Currency { get; init; }

        internal Money Multiply(decimal share)
        {
            var x = this.Amount * share;

            return new Money { Amount = x, Currency = this.Currency };
        }
    }
}