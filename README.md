# SharedWeightCalculator
A program that allows you to spend less time in the gym with your lifting partner.

Lifting weights with a partner is fun, but many can recall the laborious task of switching the plates on the bar to what your partner will be lifting after your set.
This program is designed to find the optimal configuration of plates you and your partner should use to minimize the time spent switching them after each set.

Given the plates that you have available in your gym, the bar weight (default 45), the weight you will be lifting, and the weight your partner will be lifting, the program 
computes both sets of plates that you and your lifting partner should use (on each side) by finding all of the possible configurations that you and your partner could use and
determining the _best_ pair. The _best_ pair is determined by both the number of common plates and the number of plates used in each configuration.

Variables:
**weights:** the plates available for you to use (only put one number for each pair)
**bar:** the weight of the bar
**targetA:** one partner's lift
**targetB:** the other partner's lift

The first output array is the configuration for the targetA lift, and the second output array is the configuration for the targetB lift.

