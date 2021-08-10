def check():
    x = input("Input: ")
    stack = []
    for i in x:
        if (i == '(' or i == '['):
            stack.append(i)
        else:
            if (len(stack) == 0):
                return False
            else:
                y = stack.pop()
                if (y == '('):
                    if (i != ')'):
                        return False
                elif (y == '['):
                    if (i != ']'):
                        return False
    return True

print (check())