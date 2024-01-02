# Integer Division Algorithm 🧮

Welcome to the Integer Division Algorithm repository! This codebase is dedicated to performing integer division without using the multiplication, division, or mod operator. A handy tool for environments with limited arithmetic capabilities!
## Features 🌟  

    Efficient Integer Division: Divide two integers in a way that truncates towards zero, following the constraints of 32-bit signed integers.  
    Overflow Handling: Ensures the result stays within the 32-bit signed integer range.  
    No Multiplication/Division/Mod: Uses a clever subtraction-based method for division.  
    Sign Aware: Correctly handles positive and negative integers.  

## How It Works 🔍  

The algorithm uses a simple yet effective approach of repeated subtraction. It subtracts the divisor from the dividend until the dividend is less than the divisor and counts these operations to get the quotient.