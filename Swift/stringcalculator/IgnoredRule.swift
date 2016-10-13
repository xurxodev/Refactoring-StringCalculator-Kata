//
//  IgnoredRule.swift
//  stringcalculator
//
//  Created by Jorge Sánchez on 13/10/16.
//  Copyright © 2016 xurxodev. All rights reserved.
//

import Foundation

protocol IgnoredRule {
    func isIgnored(number:Int) -> Bool
}