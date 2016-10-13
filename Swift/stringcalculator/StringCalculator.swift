import UIKit

class StringCalculator{
    let default_result:Int = 0
    
    let numberExtractor:NumberExtractor
    let numberRemover:NumberRemover
    let numberValidator:NumberValidator
    
    init(numberExtractor:NumberExtractor,
         numberRemover:NumberRemover,
         numberValidator:NumberValidator){
        
       self.numberExtractor = numberExtractor
       self.numberRemover = numberRemover
       self.numberValidator = numberValidator
    }
    
    func add(input:String) throws -> Int {
        let allNumbers:[Int] = numberExtractor.extract(input);
        
        let numbersWithoutIgnored = numberRemover.removeNumbersToIgnore(allNumbers);
        
        try numberValidator.validate(numbersWithoutIgnored);
        
        return sumNumbers(numbersWithoutIgnored);
    }
    
        
    private func sumNumbers(numbers:[Int]) -> Int {
        var sum:Int = 0
    
        
        for number in numbers {
            sum += number
        }
        
        return sum;
    }
}


