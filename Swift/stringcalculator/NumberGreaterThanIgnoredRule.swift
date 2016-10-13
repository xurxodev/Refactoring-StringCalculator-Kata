//
//  NumberGreaterThanIgnoredRule.swift
//  stringcalculator
//
//  Created by Jorge Sánchez on 13/10/16.
//  Copyright © 2016 xurxodev. All rights reserved.
//

import Foundation

class NumberGreaterThanIgnoredRule: IgnoredRule {
    
    let maxValue:Int
    
    init(maxValue:Int) {
        self.maxValue = maxValue
    }
    
    func isIgnored(number: Int) -> Bool{
        return number > maxValue        
    }
}