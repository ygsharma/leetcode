class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        counter = collections.Counter()
        max_fruits = -inf
        start = 0
        for end in range(len(fruits)):
            counter[fruits[end]] += 1
            while len(counter)>2:
                counter[fruits[start]] -= 1
                if counter[fruits[start]] == 0:
                    del counter[fruits[start]]
                start += 1
            max_fruits = max(max_fruits, end-start+1)
        return max_fruits
