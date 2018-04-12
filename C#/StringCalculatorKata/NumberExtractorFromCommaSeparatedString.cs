using StringCalculatorKata.Boundaries;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringCalculatorKata
{
    public class NumberExtractorFromCommaSeparatedString : INumberExtractor
    {
        public List<int> Extract(string numbers)
        {
            List<int> numberList = new List<int>();

            if (numbers != "")
            {
                foreach (string number in numbers.Split(','))
                {
                    numberList.Add(int.Parse(number));
                }
            }

            return numberList;
        }
    }
}
