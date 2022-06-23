﻿namespace TDD_Template.UnitTests
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
            => new() { Amount = this.Amount + (money?.Amount ?? 0.0m), Currency = this.Currency };
    }
}