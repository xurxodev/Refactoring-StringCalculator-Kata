using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringCalculatorKata.Boundaries
{
    public interface INumberExtractor
    {
        List<int> Extract(String numbers);
    }
}
