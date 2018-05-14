# Refactoring-StringCalculator-Kata
Given a simple implementation of string calculator, how would you refactor this, based on SOLID principles?

## Kata Description
1. Create a simple String calculator with a method int Add(string numbers)
  1. The method can take 0, 1 or 2 numbers, and will return their sum (for an empty string it will return 0) for example “” or “1” or “1,2”
2. Allow the Add method to handle an unknown amount of numbers
3. Calling Add with a negative number will throw an exception “negatives not allowed”
4. Numbers bigger than 1000 should be ignored, so adding 2 + 1001  = 2

## Problem Description

Given a simple implementation of string calculator.

Refactor string calculator based in SOLID Principles.

All Test must pass

The code should be flexible for receive different separators or validations on the future

## Developed By

* Jorge Sánchez Fernández aka [xurxodev](https://twitter.com/xurxodev)

## License


    Copyright 2016 Jorge Sánchez Fernández

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
