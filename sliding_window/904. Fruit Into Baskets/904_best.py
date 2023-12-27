class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        counter = collections.Counter()
        max_fruits = 0
        for end in range(len(fruits)):
            counter[fruits[end]] += 1
            if len(counter) <= 2:
                max_fruits += 1
            else:
                counter[fruits[end-max_fruits]] -= 1
                if counter[fruits[end-max_fruits]] == 0:
                    del counter[fruits[end-max_fruits]]
        return max_fruits
