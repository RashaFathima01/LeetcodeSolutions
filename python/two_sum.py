from typing import List


def two_sum(nums: List[int], target: int) -> List[int]:
    seen = {}

    for index, value in enumerate(nums):
        complement = target - value
        if complement in seen:
            return [seen[complement], index]
        seen[value] = index

    return []


if __name__ == "__main__":
    example_nums = [2, 7, 11, 15]
    example_target = 9
    print(two_sum(example_nums, example_target))
