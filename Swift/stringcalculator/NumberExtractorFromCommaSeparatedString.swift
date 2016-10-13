//
//  NumberExtractorFromCommaSeparatedString.swift
//  stringcalculator
//
//  Created by Jorge Sánchez on 13/10/16.
//  Copyright © 2016 xurxodev. All rights reserved.
//

import Foundation

class NumberExtractorFromCommaSeparatedString:NumberExtractor {
    
    func extract(input:String)-> [Int] {
        
        var numbers:[Int] = []
        
        if (input != ""){
            let inputs = input.componentsSeparatedByString(",");
            numbers = inputs.map { Int($0)!}
        }
        
        return numbers;
    }
}