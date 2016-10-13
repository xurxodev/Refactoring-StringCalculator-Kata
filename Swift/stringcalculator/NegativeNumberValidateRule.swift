//
//  NegativeNumberValidateRule.swift
//  stringcalculator
//
//  Created by Jorge Sánchez on 13/10/16.
//  Copyright © 2016 xurxodev. All rights reserved.
//

import Foundation

class NegativeNumberValidateRule: ValidateRule {
    func validate(number: Int) throws {
        if (number < 0){
            throw InvalidInputError.NegativeNumbersFound
        }
        
    }
}