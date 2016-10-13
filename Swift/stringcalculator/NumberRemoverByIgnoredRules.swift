//
//  NumberRemoverByIgnoredRules.swift
//  stringcalculator
//
//  Created by Jorge Sánchez on 13/10/16.
//  Copyright © 2016 xurxodev. All rights reserved.
//

import Foundation

class NumberRemoverByIgnoredRules:NumberRemover {
    
    let ignoredRules:[IgnoredRule]
    
    init (ignoredRules:[IgnoredRule]){
        self.ignoredRules = ignoredRules
    }
    
    func removeNumbersToIgnore(numbers:[Int]) -> [Int]{
        
        let numbersWithoutIgnored = numbers.filter {!isIgnored($0)}
        
        return numbersWithoutIgnored;
    }
    
    private func isIgnored(number:Int) -> Bool{
        
        for ignoreRule in ignoredRules {
            if(ignoreRule.isIgnored(number)){
                return true
            }
        }

        return false;
    }
}