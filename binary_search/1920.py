import sys

def merge(left, right, llen, rlen):
    i, j, result = 0, 0, []
    while(i < llen and j < rlen):
        if(left[i] <= right[j]):
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    if(i < llen):
        result.extend(left[i:])

    if(j < rlen):
        result.extend(right[j:])

    return result

def binary_sort(n, anums):
    if(n == 1):
        return anums
    start = n // 2
    end = n - start
    left = binary_sort(start, anums[:start])
    right = binary_sort(end, anums[start:])
    return merge(left, right, start, end)


def binary_search(n, anums, num):
    start, mid, end = 0, n // 2, n - 1

    while(start <= end):
        if(num == anums[mid]):
            return 1
        else:
            if(num > anums[mid]):
                start = mid + 1
            else:
                end = mid - 1
            mid = (start + end) // 2

    return 0

n = int(sys.stdin.readline())
anums = list(map(int, sys.stdin.readline().split()))
anums = binary_sort(n, anums)

m = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))


for i in nums:
    print(binary_search(n, anums, i))