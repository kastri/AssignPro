//
//  Calculation.m
//  AssignmentPro
//
//  Created by Kastriot Dreshaj on 13.3.22.
//

#import <Foundation/Foundation.h>
#import "CalculationModule.h"


@implementation CalculationModule

RCT_EXPORT_MODULE(CalculationModule)

RCT_EXPORT_BLOCKING_SYNCHRONOUS_METHOD(getCalculationResult:(NSString *)calculationType :(NSNumber *)numberOne :(NSNumber *)numberTwo)
{
      
  int sum = -1;
  
      if ([calculationType  isEqual: @"+"]) {
        sum = [numberOne intValue] + [numberTwo intValue];
      } else if ([calculationType  isEqual: @"-"]) {
        sum = [numberOne intValue] - [numberTwo intValue];
      } else if ([calculationType  isEqual: @"*"]) {
        sum = [numberOne intValue] * [numberTwo intValue];
      } else if ([calculationType  isEqual: @"/"]) {
        sum = [numberOne intValue] / [numberTwo intValue];
      }
    
  NSNumber *sumNumber = [NSNumber numberWithInt:sum];
  return sumNumber;
  

}


// - (NSInteger)getCalculationResult:(NSString *)calculationType :(NSInteger)numberOne :(NSInteger)numberTwo {
//
//    if ([calculationType  isEqual: @"+"]) {
//        return numberOne + numberTwo;
//    } else if ([calculationType  isEqual: @"-"]) {
//        return numberOne - numberTwo;
//    } else if ([calculationType  isEqual: @"*"]) {
//        return numberOne * numberTwo;
//    } else if ([calculationType  isEqual: @"/"]) {
//        return numberOne / numberTwo;
//    }
//
//    return -1;
//}

@end
