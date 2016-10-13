//
//  NumberValidatorByValidateRules.swift
//  stringcalculator
//
//  Created by Jorge Sánchez on 13/10/16.
//  Copyright © 2016 xurxodev. All rights reserved.
//

import Foundation

class NumberValidatorByValidateRules:NumberValidator {
    
    let validateRules:[ValidateRule]
    
    init (validateRules:[ValidateRule]){
        self.validateRules = validateRules
    }
    
    func validate(numbers:[Int]) throws{
        
        for number in numbers {
            try validate(number)
        }
    }
    
    private func validate(number:Int) throws{
        
        for validateRule in validateRules {
            try validateRule.validate(number)
        }
    }
}