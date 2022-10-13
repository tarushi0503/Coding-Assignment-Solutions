class InsertSigns {
    public int findTargetSumWays(int[] nums, int target) {
        var dp = new HashMap<Integer, Integer>();
        dp.put(0, 1);
        for (int n : nums){
            var ndp = new HashMap<Integer, Integer>();
            for (int key : dp.keySet()){
                ndp.merge(key-n, dp.get(key), Integer::sum);
                ndp.merge(key+n, dp.get(key), Integer::sum);
            }
            dp=ndp;
        }
        return dp.getOrDefault(target, 0);
    }
}


/*
Approach:
mutiple ways of getting 100 as sum from 1,2,3,4,5,6,7,89 can be:
1 + 2 + 34 - 5 + 67 - 8 + 9 = 100
1 + 23 - 4 + 5 + 6 + 78 - 9 = 100
1 + 23 - 4 + 56 + 7 + 8 + 9 = 100
12 + 3 + 4 + 5 - 6 - 7 + 89 = 100
12 + 3 - 4 + 5 + 67 + 8 + 9 = 100
12 - 3 - 4 + 5 - 6 + 7 + 89 = 100
123 + 4 - 5 + 67 - 89 = 100
123 + 45 - 67 + 8 - 9 = 100
123 - 4 - 5 - 6 - 7 + 8 - 9 = 100
1 + 2 + 3 - 4 + 5 + 6 + 78 + 9 = 100
123 - 45 - 67 + 89 = 100

if we pass any of the numbers on LHS as array "nums" and 100 as "target" 
and get 1 as output, it means, it is possibility. eg:
nums=[1,2,34,5,67,8,9], target=100
output=1
Thus, this combination is valid. Similarly all combinations can be checked.
*/


