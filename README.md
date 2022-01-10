# SharedWeightCalculator
A program that allows you to spend less time in the gym with your lifting partner.

Lifting weights with a partner is fun, but many can recall the laborious task of switching the plates on the bar to your partner will be lifting after your set.
This program is designed to find the optimal configuration of plates you and your partner should use to minimize the time spent switching them each set.

Given the plates that you have available in your gym, the bar weight (default 45), the weight you will be lifting, and the weight your partner will be lifting, the program 
computes both sets of plates that you and your lifting partner should use (on each side) by finding all of the possible configurations that you and your partner could use and
determining the best pair. The best pair is determined by both the number of common plates and the number of plates used in each configuration. This program only supports weights
with increments of 2.5.
