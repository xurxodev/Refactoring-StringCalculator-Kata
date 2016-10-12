# Java initial implementation

## Tests

```swift
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
```

## Simple StringCalculator

```swift
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


```