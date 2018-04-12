using StringCalculatorKata.Boundaries;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringCalculatorKata
{
    public class NumberRemoverByIgnoredRules : INumberRemover
    {
        List<IIgnoreRule> ignoredRules;

        public NumberRemoverByIgnoredRules(List<IIgnoreRule> ignoredRules)
        {
            this.ignoredRules = ignoredRules;
        }

        public List<int> RemoveNumbersToIgnore(List<int> numbers)
        {
            List<int> numbersWithoutIgnored = new List<int>();

            foreach (int number in numbers)
            {
                if (!IsIgnored(number))
                    numbersWithoutIgnored.Add(number);
            }

            return numbersWithoutIgnored;
        }

        private bool IsIgnored(int number)
        {
            foreach (IIgnoreRule ignoreRule in ignoredRules)
            {
                if (ignoreRule.isIgnored(number))
                    return true;
            }

            return false;
        }
    }
}
