﻿namespace TDD_Template
{
    public class RockPaperScissorsCalculator
    {
        private const int DRAW_SCORE = 3;
        private const int WIN_SCORE = 6;

        public int CalculateOutcome(char opponent, char myself)
        {
            Shape myShape = CreateShape(myself);
            Shape opponentShape = CreateShape(opponent);

            if (IsDraw(opponentShape, myShape))
            {
                return DRAW_SCORE + (int)myShape;
            }

            return WIN_SCORE + (int) myShape;
        }

        private bool IsDraw(Shape opponentShape, Shape myShape)
        {
            return opponentShape == myShape;
        }

        private static Shape CreateShape(char input)
        {
            Shape shape = input switch
            {
                'X' => Shape.Rock,
                'A' => Shape.Rock,
                'Y' => Shape.Paper,
                'B' => Shape.Paper,
                'Z' => Shape.Scissor,
                'C' => Shape.Scissor,
                _ => 0
            };

            return shape;
        }
    }

    public enum Shape
    {
        Rock = 1,
        Paper = 2,
        Scissor = 3
    }
}