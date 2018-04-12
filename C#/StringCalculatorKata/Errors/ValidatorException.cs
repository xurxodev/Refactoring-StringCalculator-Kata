
using System;

namespace StringCalculatorKata.Errors
{
    public class ValidatorException: Exception
    {
        public ValidatorException(string message):base(message) { }
    }
}
