namespace TDD_Template.UnitTests
{
    internal record Money
    {
        public decimal Amount { get; init; }
        public string Currency { get; init; }

        internal Money Multiply(decimal share)
            => new() { Amount = this.Amount * share, Currency = this.Currency };

        internal Money Divide(int v)
        {
            throw new NotImplementedException();
        }
    }
}