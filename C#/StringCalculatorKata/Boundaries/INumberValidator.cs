using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringCalculatorKata.Boundaries
{
    public interface INumberValidator
    {
        void Validate(List<int> numbers);
    }
}
