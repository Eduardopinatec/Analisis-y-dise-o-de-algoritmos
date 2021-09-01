def binarySearch(arr, begin, end, search):
    if (end<begin):
        return -1
        
    middle = (begin + end) //2

    if (search == arr[middle]):
        return middle
    elif (search < arr[middle]):
        return binarySearch(arr, begin, middle-1, search)
    else:
        return binarySearch(arr, middle+1, end, search)

a = []
for x in range(0, 1000):
    a.append(x)

print(binarySearch(a, 0, len(a)-1, 300))