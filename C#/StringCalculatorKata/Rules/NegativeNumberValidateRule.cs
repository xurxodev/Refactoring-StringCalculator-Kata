using StringCalculatorKata.Boundaries;
using StringCalculatorKata.Errors;

namespace StringCalculatorKata.Rules
{
    public class NegativeNumberValidateRule : IValidateRule
    {
        public void validate(int number)
        {
            if (number < 0)
                throw new NegativeNumbersNotAllowedException();
        }
    }
}