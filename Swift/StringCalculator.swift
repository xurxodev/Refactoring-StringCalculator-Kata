import UIKit



class StringCalculator{
    let default_result:Int = 0
    
    func add(input:String) throws -> Int {
        if (input==""){
            return default_result;
        }
        
        if (input.containsString(",")){
            return try handleMultiple(input);
        }
        
        return try parseSingle(input);
    }
    
        
    private func parseSingle(input:String)throws -> Int {
        let number = Int(input)!;
        
        if (number > 1000){
            return 0;
        }
        else if (number < 0){
            throw InvalidInputError.NegativeNumbersFound
        }
        else{
            return number
        }
    }
        
    private func handleMultiple(input:String)throws -> Int {
        var sum:Int = 0
        
        let numbers = input.componentsSeparatedByString(",");
        
        for number in numbers {
            sum += try parseSingle(number)
        }
        
        return sum;
    }
}


