// Last updated: 10/1/2025, 8:43:53 PM
class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drink = numBottles;
        while (numExchange <= numBottles) {
            ++drink;
            numBottles -= numExchange;
            ++numExchange;
            ++numBottles;
        }
        return drink;
    }
}