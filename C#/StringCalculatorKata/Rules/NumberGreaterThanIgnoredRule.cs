using StringCalculatorKata.Boundaries;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringCalculatorKata.Rules
{
    public class NumberGreaterThanIgnoredRule : IIgnoreRule
    {
        private readonly int maxValue;

        public NumberGreaterThanIgnoredRule(int maxValue)
        {
            this.maxValue = maxValue;
        }

        public bool isIgnored(int number)
        {
            return number > maxValue;
        }
    }
}
