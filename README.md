# MATH_4161_Assignment_9_Feistel_cipher
This program decrypts a variant of Feistel cipher

The ninth and last assignment uses the Feistel cipher with
(a) **8 left bits and 8 right bits**

(b) **two keys of 8 bits each**
**the key used in the first round is: 149
the key used in the second round is: 193**
note that these are numerical values that should be interpreted as 8 bit binary
numbers in the function f below.

**(c) the function f(R,K) = (reverse the bits of R) XOR (bits of K)**

(d) the cyphertext produced by encoding the **first two letters of the word is binary
00100101 00001010**
the cyphertext produced by encoding the **second two letters of the word is binary
11001001 00100110**

The plaintext is a 4 letter English word and the letters were
encrypted two at a time.  **The Roman letters correspond to binary
using the ASCII code** (see for instance:
https://www.duplichecker.com/text-to-binary.php
https://www.duplichecker.com/binary-to-text.php).
