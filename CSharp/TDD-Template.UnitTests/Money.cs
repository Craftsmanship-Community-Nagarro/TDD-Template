namespace TDD_Template.UnitTests
{
    internal class Money
    {
        public decimal Amount { get; init; }
        public string Currency { get; init; }

        private readonly Dictionary<string, decimal> exchangeRates = new()
        {
             {"USD-EUR", 1.2m },
             {"KRW-USD", 1100m }
        };


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

            decimal exchangeRate = this.exchangeRates[$"{this.Currency}-{money.Currency}"];

            var exchange = money.Amount * exchangeRate;

            return new() { Amount = this.Amount + exchange, Currency = this.Currency };
        }

        public override bool Equals(object? obj)
        {
            if (obj is null) return false;

            int amountX = this.Amount.GetHashCode();
            int currencyX = this.Currency.GetHashCode();

            int amountY = ((Money)obj).Amount.GetHashCode();
            int currencyY = ((Money)obj).Currency.GetHashCode();

            return amountX == amountY && currencyX == currencyY;
        }
    }
}