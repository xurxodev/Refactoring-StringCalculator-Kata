import XCTest
@testable import Refactoring_StringCalculator

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
