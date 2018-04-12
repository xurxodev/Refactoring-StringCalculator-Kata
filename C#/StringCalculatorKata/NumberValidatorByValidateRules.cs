using StringCalculatorKata.Boundaries;
using System.Collections.Generic;

namespace StringCalculatorKata
{
    public class NumberValidatorByValidateRules : INumberValidator
    {
        List<IValidateRule> validateRules;

        public NumberValidatorByValidateRules(List<IValidateRule> validateRules)
        {
            this.validateRules = validateRules;
        }


        public void Validate(List<int> numbers)
        {
            foreach (int number in numbers)
            {
                Validate(number);
            }
        }

        private bool Validate(int number)
        {
            foreach (IValidateRule validateRule in validateRules)
            {
                validateRule.validate(number);
            }

            return false;
        }

    }
}
