using StringCalculatorKata.Errors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringCalculatorKata.Errors
{
    public class NegativeNumbersNotAllowedException : ValidatorException
    {
        public NegativeNumbersNotAllowedException() :base("Negatives not allowed")
        {
        }
    }
}
