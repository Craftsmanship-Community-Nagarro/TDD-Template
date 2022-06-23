namespace TDD_Template.UnitTests
{
    internal record Money
    {
        public decimal Amount { get; init; }
        public string Currency { get; init; }

        internal Money Multiply(decimal share)
            => new() { Amount = this.Amount * share, Currency = this.Currency };

        internal Money Divide(decimal share) 
            => new() { Amount = this.Amount / share, Currency = this.Currency };

        internal Money Add(Money money)
        {
            if (money is null)
            {
                return new() { Amount = this.Amount, Currency = this.Currency };
            }

            if (string.Compare(this.Currency, money.Currency, StringComparison.OrdinalIgnoreCase) == 0)
            {
                return new() { Amount = this.Amount + money.Amount, Currency = this.Currency };
            }

            decimal exchangeRate = 1.2m;
            var exchange = money.Amount * exchangeRate;

            return new() { Amount = this.Amount + exchange, Currency = this.Currency };
        }
    }
}