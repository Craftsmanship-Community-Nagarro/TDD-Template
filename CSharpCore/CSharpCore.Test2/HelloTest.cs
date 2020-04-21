using Xunit;
using FluentAssertions;

namespace CSharpCore.Test
{
    public class HelloTest
    {
        [Fact]
        public void ShouldGreet()
        {
            Hello hello = new Hello();

            string greeting = hello.Greetings();

            greeting.Should().Be("Hello!");
        }
    }
}