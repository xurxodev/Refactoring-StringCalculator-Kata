using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StringCalculatorKata.Boundaries
{
    public interface INumberRemover
    {
        List<int> RemoveNumbersToIgnore(List<int> numbers);
    }
}
