import XCTest
@testable import Refactoring_StringCalculator

class StringCalculatorShould: XCTestCase {
    
    func test_return_zero_if_input_is_empty() {
        let expectedResult: Int = 0
    
        let calculator:StringCalculator = StringCalculator()

        let result: Int = calculator.add("")
    
        XCTAssertEqual(result, expectedResult)
    }

    func test_return_one_if_input_is_one() {
        let expectedResult: Int = 1
        
        let calculator:StringCalculator = StringCalculator()
        
        let result: Int = calculator.add("1")
        
        XCTAssertEqual(result, expectedResult)
    }
    
    func test_return_three_if_input_is_one_and_two() {
        let expectedResult: Int = 3
        
        let calculator:StringCalculator = StringCalculator()
        
        let result: Int = calculator.add("1,2")
        
        XCTAssertEqual(result, expectedResult)
    }
    
}
