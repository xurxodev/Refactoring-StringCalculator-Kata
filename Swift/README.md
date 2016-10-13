# Swift initial implementation

## Tests

```swift
class StringCalculatorShould: XCTestCase {
    
    func test_return_zero_if_input_is_empty() {
        let expectedResult: Int = 0
    
        let calculator:StringCalculator = StringCalculator()

        let result: Int = try! calculator.add("")
    
        XCTAssertEqual(result, expectedResult)
    }

    func test_return_one_if_input_is_one() {
        let expectedResult: Int = 1
        
        let calculator:StringCalculator = StringCalculator()
        
        let result: Int = try! calculator.add("1")
        
        XCTAssertEqual(result, expectedResult)
    }
    
    func test_return_three_if_input_is_one_and_two() {
        let expectedResult: Int = 3
        
        let calculator:StringCalculator = StringCalculator()
        
        let result: Int = try! calculator.add("1,2")
        
        XCTAssertEqual(result, expectedResult)
    }
    
    
    func test_return_fifteen_if_input_is_from_one_to_five() {
        let expectedResult: Int = 15
        
        let calculator:StringCalculator = StringCalculator()
        
        let result: Int = try! calculator.add("1,2,3,4,5")
        
        XCTAssertEqual(result, expectedResult)
    }
    
    func test_return_two_if_input_is_two_and_thousand_and_one() {
        let expectedResult: Int = 2
        
        let calculator:StringCalculator = StringCalculator()
        
        let result: Int = try! calculator.add("2,1001")
        
        XCTAssertEqual(result, expectedResult)
    }
    
    func test_throw_exception_if_input_contains_negative_number() {
        let calculator:StringCalculator = StringCalculator()
        
        do {
            try calculator.add("2,-5")
        } catch InvalidInputError.NegativeNumbersFound() {
            XCTAssertTrue(true)
        } catch {
            
        }
    }
}
```

## Simple StringCalculator

```swift
enum InvalidInputError: ErrorType {
    
    case NegativeNumbersFound
}

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
```
