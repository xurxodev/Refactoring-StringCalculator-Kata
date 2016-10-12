import UIKit

class StringCalculator{
    let default_result:Int = 0
    
    func add(numbers:String) -> Int {
        if (numbers=="")
        {
            return default_result;
        }
        if (numbers.containsString(","))
        {
            return handleMultiple(numbers);
        }
        return parseSingle(numbers);
    }
    
        
    private func parseSingle(input:String)-> Int {
        return Int(input)!;
    }
    
        
    private func handleMultiple(input:String)-> Int {
        let numbers = input.componentsSeparatedByString(",");
        return add(numbers[0]) + add(numbers[1]);
    }
}
